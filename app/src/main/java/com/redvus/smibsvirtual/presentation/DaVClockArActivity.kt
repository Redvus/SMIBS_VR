package com.redvus.smibsvirtual.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.Config
import com.google.ar.core.Config.InstantPlacementMode
import com.google.ar.core.Session
import com.redvus.smibsvirtual.helpers.CameraPermissionHelper
import com.redvus.smibsvirtual.helpers.DepthSettings
import com.redvus.smibsvirtual.helpers.InstantPlacementSettings
import com.redvus.smibsvirtual.samplerender.SampleRender
import com.redvus.smibsvirtual.domain.ARCoreSessionLifecycleHelper
import com.google.ar.core.exceptions.CameraNotAvailableException
import com.google.ar.core.exceptions.UnavailableApkTooOldException
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException
import com.google.ar.core.exceptions.UnavailableSdkTooOldException
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException
import com.redvus.smibsvirtual.R
import com.redvus.smibsvirtual.data.DaVClockArRenderer
import com.redvus.smibsvirtual.databinding.ActivityArtestBinding
import com.redvus.smibsvirtual.domain.DaVClockArView

/**
 * This is a simple example that shows how to create an augmented reality (AR) application using the
 * ARCore API. The application will display any detected planes and will allow the user to tap on a
 * plane to place a 3D model.
 */
class DaVClockArActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "DaVClockArActivity"
    }

    lateinit var arCoreSessionHelper: ARCoreSessionLifecycleHelper
    lateinit var view: DaVClockArView
    private lateinit var renderer: DaVClockArRenderer
    private lateinit var binding: ActivityArtestBinding

    val instantPlacementSettings = InstantPlacementSettings()
    val depthSettings = DepthSettings()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtestBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        supportActionBar?.title = getString(R.string.titleAR)
//        setSupportActionBar(binding.toolbarMain)

        // Setup ARCore session lifecycle helper and configuration.
        arCoreSessionHelper = ARCoreSessionLifecycleHelper(this)
        // If Session creation or Session.resume() fails, display a message and log detailed
        // information.
        arCoreSessionHelper.exceptionCallback =
            { exception ->
                val message =
                    when (exception) {
                        is UnavailableUserDeclinedInstallationException ->
                            getString(R.string.setupARServices)
                        is UnavailableApkTooOldException -> getString(R.string.updateARCore)
                        is UnavailableSdkTooOldException -> getString(R.string.updateARApp)
                        is UnavailableDeviceNotCompatibleException -> getString(R.string.deviceNotAR)
                        is CameraNotAvailableException -> getString(R.string.cameraNotActive)
                        else -> "Ошибка пр создании AR сессии: $exception"
                    }
                Log.e(TAG, "ARCore выдал исключение", exception)
                view.snackbarHelper.showError(this, message)
            }

        // Configure session features, including: Lighting Estimation, Depth mode, Instant Placement.
        arCoreSessionHelper.beforeSessionResume = ::configureSession
        lifecycle.addObserver(arCoreSessionHelper)

        // Set up the Hello AR renderer.
        renderer = DaVClockArRenderer(this)
        lifecycle.addObserver(renderer)

        // Set up Hello AR UI.
        view = DaVClockArView(this)
        lifecycle.addObserver(view)
        setContentView(view.root)

        // Sets up an example renderer using our HelloARRenderer.
        SampleRender(view.surfaceView, renderer, assets)

        depthSettings.onCreate(this)
        instantPlacementSettings.onCreate(this)
    }

    // Configure the session, using Lighting Estimation, and Depth mode.
    fun configureSession(session: Session) {
        session.configure(
            session.config.apply {
                lightEstimationMode = Config.LightEstimationMode.ENVIRONMENTAL_HDR

                // Depth API is used if it is configured in Hello AR's settings.
                depthMode =
                    if (session.isDepthModeSupported(Config.DepthMode.AUTOMATIC)) {
                        Config.DepthMode.AUTOMATIC
                    } else {
                        Config.DepthMode.DISABLED
                    }

                // Instant Placement is used if it is configured in Hello AR's settings.
                instantPlacementMode =
                    if (instantPlacementSettings.isInstantPlacementEnabled) {
                        InstantPlacementMode.LOCAL_Y_UP
                    } else {
                        InstantPlacementMode.DISABLED
                    }
            }
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        results: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, results)
        if (!CameraPermissionHelper.hasCameraPermission(this)) {
            // Use toast instead of snackbar here since the activity will exit.
            Toast.makeText(
                this,
                getText(R.string.cameraARPermission),
                Toast.LENGTH_LONG
            )
                .show()
            if (!CameraPermissionHelper.shouldShowRequestPermissionRationale(this)) {
                // Permission denied with checking "Do not ask again".
                CameraPermissionHelper.launchPermissionSettings(this)
            }
            finish()
        }
    }
}
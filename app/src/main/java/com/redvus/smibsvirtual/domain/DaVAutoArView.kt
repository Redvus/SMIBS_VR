package com.redvus.smibsvirtual.domain

import android.opengl.GLSurfaceView
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.google.ar.core.Config
import com.redvus.smibsvirtual.R
import com.redvus.smibsvirtual.helpers.SnackbarHelper
import com.redvus.smibsvirtual.helpers.TapHelper
import com.redvus.smibsvirtual.presentation.DaVAutoArActivity

class DaVAutoArView(val activity: DaVAutoArActivity) : DefaultLifecycleObserver {
    val root = View.inflate(activity, R.layout.activity_artest, null)
    val surfaceView = root.findViewById<GLSurfaceView>(R.id.surfaceview)

    val session
        get() = activity.arCoreSessionHelper.session

    val snackbarHelper = SnackbarHelper()
    val tapHelper = TapHelper(activity).also { surfaceView.setOnTouchListener(it) }

    override fun onResume(owner: LifecycleOwner) {
        surfaceView.onResume()
    }

    override fun onPause(owner: LifecycleOwner) {
        surfaceView.onPause()
    }

    /**
     * Shows a pop-up dialog on the first tap in HelloARRenderer, determining whether the user wants
     * to enable depth-based occlusion. The result of this dialog can be retrieved with
     * DepthSettings.useDepthForOcclusion().
     */
    fun showOcclusionDialogIfNeeded() {
        val session = session ?: return
        val isDepthSupported = session.isDepthModeSupported(Config.DepthMode.AUTOMATIC)
        if (!activity.depthSettings.shouldShowDepthEnableDialog() || !isDepthSupported) {
            return // Don't need to show dialog.
        }

        // Asks the user whether they want to use depth-based occlusion.
        AlertDialog.Builder(activity)
            .setTitle(R.string.options_title_with_depth)
            .setMessage(R.string.depth_use_explanation)
            .setPositiveButton(R.string.button_text_enable_depth) { _, _ ->
                activity.depthSettings.setUseDepthForOcclusion(true)
            }
            .setNegativeButton(R.string.button_text_disable_depth) { _, _ ->
                activity.depthSettings.setUseDepthForOcclusion(false)
            }
            .show()
    }
}
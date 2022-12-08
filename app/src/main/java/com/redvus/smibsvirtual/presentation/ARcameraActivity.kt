package com.redvus.smibsvirtual.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.redvus.smibsvirtual.R
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ARcameraActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {

    private lateinit var zbView: ZXingScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arcamera)
        zbView = ZXingScannerView(this)
        setContentView(zbView)
    }

    override fun onPause() {
        super.onPause()
        zbView.stopCamera()
    }

    override fun onResume() {
        super.onResume()
        zbView.setResultHandler(this)
        zbView.startCamera()
    }

    override fun handleResult(rawResult: com.google.zxing.Result?) {
//        Log.d("MyLog", "Сканер работает")
//        Log.v("MyLog", rawResult.toString())
//        Toast.makeText(this, "Scan Result = " + data.getStringExtra(ZBarConstants.SCAN_RESULT), Toast.LENGTH_SHORT).show()

//        startActivity(Intent(this,HelloArActivity::class.java))

        val scanQRResult: String = rawResult.toString()
        val davClockQR = getString(R.string.davClockQR)
        val davCalculatorQR = getString(R.string.davCalculatorQR)
        val davAutoQR = getString(R.string.davAutoQR)
        val davParachuteQR = getString(R.string.davParachuteQR)
        val davGiantBowQR = getString(R.string.davGiantBowQR)
        val davExcavatorQR = getString(R.string.davExcavatorQR)
        val davWheelQR = getString(R.string.davWheelQR)
////
        when (scanQRResult) {
            davClockQR -> {
                startActivity(Intent(this, DaVClockArActivity::class.java))
            }
            davCalculatorQR -> {
                startActivity(Intent(this, DaVCalculatorArActivity::class.java))
            }
            davAutoQR -> {
                startActivity(Intent(this, DaVAutoArActivity::class.java))
            }
            davParachuteQR -> {
                startActivity(Intent(this, DaVParashuteArActivity::class.java))
            }
            davGiantBowQR -> {
                startActivity(Intent(this, DaVGiantBowArActivity::class.java))
            }
            davExcavatorQR -> {
                startActivity(Intent(this, DavExcavatorArActivity::class.java))
            }
            davWheelQR -> {
                startActivity(Intent(this, DavWheelArActivity::class.java))
            }
            else -> {
                startActivity(Intent(this, ARealityActivity::class.java))
                Toast.makeText(this, getText(R.string.scanQRCodeFail), Toast.LENGTH_LONG).show()
            }
        }
        finish()
    }


}
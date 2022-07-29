package com.redvus.smibsvirtual.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.redvus.smibsvirtual.R
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView

class ARcameraActivity : AppCompatActivity(), ZBarScannerView.ResultHandler {

    private lateinit var zbView: ZBarScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arcamera)
        zbView = ZBarScannerView(this)
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

    override fun handleResult(result: Result?) {
//        Log.d("MyLog", "Сканер работает")
//        Toast.makeText(this, "Сканер работает", Toast.LENGTH_LONG).show()
        startActivity(Intent(this,HelloArActivity::class.java))
        finish()
    }


}
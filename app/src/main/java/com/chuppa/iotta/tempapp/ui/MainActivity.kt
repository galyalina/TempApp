package com.chuppa.iotta.tempapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chuppa.iotta.tempapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadContent()
    }

    private fun loadContent() {
        webview.loadUrl("file:///android_res/raw/sample.html")
        webview.webViewClient.
    }
}

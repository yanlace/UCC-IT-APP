package com.example.uccapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.uccapplication.databinding.ActivityAdmissionsBinding


class Admissions : AppCompatActivity() {

    private  lateinit var binding: ActivityAdmissionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)

        binding = ActivityAdmissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)





        webViewSetup()
    }
    @SuppressLint("SetJavaScriptEnabled")
    private  fun webViewSetup(){
       binding.wbWebView.webViewClient = WebViewClient()

        binding.wbWebView.apply {
            loadUrl("https://www.ucc.edu.jm/programmes/tm/bsc-in-information-technology/")
            settings.javaScriptEnabled = true
        }
    }

    override fun onBackPressed() {
       if(binding.wbWebView.canGoBack())
           binding.wbWebView.goBack()
        else super.onBackPressed()
    }
}
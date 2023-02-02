package com.pikpok.hrc.ui.ffd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pikpok.hrc.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isTaskRoot
            && intent.hasCategory(Intent.CATEGORY_LAUNCHER)
            && intent.action != null && intent.action == Intent.ACTION_MAIN
        ) {
            finish()
        }
        setContentView(R.layout.activity_main)
    }
    override fun onBackPressed() {

    }

}
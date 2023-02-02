package com.pikpok.hrc.ui


import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pikpok.hrc.databinding.ActivitySplashBinding
import com.pikpok.hrc.startEgypt.StartEgypt
import com.pikpok.hrc.ui.ffd.EgyptLuckActivity
import com.pikpok.hrc.ui.ffd.MainActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val startEgypt = StartEgypt(this)
        startEgypt.start { b ->
            if (b){
                Log.e("weq","oo")
                val intent = Intent(this, EgyptLuckActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Log.e("weq","ggg")
                try {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }catch (e:Exception){
                    e.message
                }

            }
        }
        animateImageView()
        setContentView(binding.root)
    }

    private fun animateImageView() {
        binding.tvWelcome.startAnimation(
            AnimationUtils.loadAnimation(
                applicationContext,
                com.pikpok.hrc.R.anim.zoom_in_out
            )
        )
    }

    fun dialog(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            .setMessage("connect to the internet")
            .setPositiveButton(
                "Ok",
                DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()
                    startActivity(Intent(this,SplashActivity::class.java))
                    finish()
                    android.os.Process.killProcess(android.os.Process.myPid())
                })
        builder.create()
        builder.show()
    }
}
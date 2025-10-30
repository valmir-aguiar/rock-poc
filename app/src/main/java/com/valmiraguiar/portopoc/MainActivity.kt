package com.valmiraguiar.portopoc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.callstack.reactnativebrownfield.ReactNativeFragment
import com.callstack.reactnativebrownfield.ReactNativeBrownfield
import com.facebook.react.ReactActivity
import com.testrockappreact.ReactNativeHostManager

class MainActivity : ReactActivity() {

//    private val pickImageLauncher = registerForActivityResult(
//        ActivityResultContracts.GetContent()
//    ) { uri: Uri? ->
//        {
//            Log.d("MainActivity", "onActivityResult: uri=${uri.toString()}");
//
//            uri?.let {
////            imageView.setImageURI(it)
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ReactNativeHostManager.initialize(this.application) {
            println("JS Initialized")
        }

        val rnAppFragment = ReactNativeFragment.createReactNativeFragment("TestRockApp")


        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_layout, rnAppFragment)
            .addToBackStack(null)
            .commit()

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        Log.d("MainActivity", "onActivityResult: requestCode=$requestCode resultCode=$resultCode data=${data.toString()}")
//        super.onActivityResult(requestCode, resultCode, data)
//
//        // Delega ao ReactInstanceManager via Brownfield
//        ReactNativeHostManager.getReactNativeHost().getReactInstanceManager().onActivityResult(this, requestCode, resultCode, data);
//
//
//        Log.d("MainActivity", "Resultado encaminhado ao Brownfield")
//    }
}
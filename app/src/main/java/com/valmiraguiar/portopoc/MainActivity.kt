package com.valmiraguiar.portopoc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.callstack.reactnativebrownfield.ReactNativeFragment
import com.testrockappreact.ReactNativeHostManager

class MainActivity : AppCompatActivity() {
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
}
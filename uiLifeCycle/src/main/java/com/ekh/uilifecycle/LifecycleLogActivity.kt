package com.ekh.uilifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

abstract class LifecycleLogActivity : AppCompatActivity() {
    abstract val target: String

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("__ lifecycle: onCreate $target")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Timber.d("__ lifecycle: onStart $target")
        super.onStart()
    }

    override fun onResume() {
        Timber.d("__ lifecycle: onResume $target")
        super.onResume()
    }

    override fun onPause() {
        Timber.d("__ lifecycle: onPause $target")
        super.onPause()
    }

    override fun onStop() {
        Timber.d("__ lifecycle: onStop $target")
        super.onStop()
    }

    override fun onDestroy() {
        Timber.d("__ lifecycle: onDestroy $target")
        super.onDestroy()
    }
}
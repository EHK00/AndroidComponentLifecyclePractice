package com.ekh.uilifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ekh.uilifecycle.databinding.ActivityUiTestMainBinding

class UiTestMainActivity : LifecycleLogActivity() {
    override val target: String = this.localClassName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUiTestMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
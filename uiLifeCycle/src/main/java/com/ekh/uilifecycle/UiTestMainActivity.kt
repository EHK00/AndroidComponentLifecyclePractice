package com.ekh.uilifecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ekh.uilifecycle.databinding.ActivityUiTestMainBinding
import timber.log.Timber

class UiTestMainActivity : LifecycleLogActivity() {
    override val target: String get() = this.localClassName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUiTestMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateTo(FirstFragment())
    }

    fun navigateTo(fragment: Fragment) {
        Timber.d("replace() - ${fragment.javaClass.simpleName}")
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
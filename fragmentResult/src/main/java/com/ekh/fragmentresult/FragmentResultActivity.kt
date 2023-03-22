package com.ekh.fragmentresult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.ekh.fragmentresult.databinding.ActivityFragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentResultActivity : AppCompatActivity(), FragmentResultListener {
    private val binding by lazy { ActivityFragmentResultBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun createNewFragment(type: FragmentEnum) {
        supportFragmentManager.commit {
            replace(binding.container.id, type.getFragment())
            addToBackStack(null)
        }
    }

    override fun popBackstack() {
        supportFragmentManager.popBackStack()
    }
}

interface FragmentResultListener {
    fun createNewFragment(type: FragmentEnum)
    fun popBackstack()
}

enum class FragmentEnum {
    A,
    B,
    Result,
    ;

    fun getFragment() = when (this) {
        A -> FragmentA()
        B -> FragmentB()
        Result -> ResultFragment()
    }
}
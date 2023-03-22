package com.ekh.componentlifecyclepractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ekh.componentlifecyclepractice.databinding.ActivityPracticeListBinding
import com.ekh.fragmentresult.FragmentResultActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PracticeListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPracticeListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btFragmentResult.setOnClickListener {
            startActivity(Intent(this, FragmentResultActivity::class.java))
        }


    }
}
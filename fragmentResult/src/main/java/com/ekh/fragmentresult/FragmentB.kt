package com.ekh.fragmentresult

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.ekh.fragmentresult.databinding.FragmentBBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class FragmentB : Fragment(R.layout.fragment_b) {
    private var binding: FragmentBBinding? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultCallback()
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBBinding.bind(view).also { this.binding = it }
//        setFragmentResultCallback()

        binding.btRequest.setOnClickListener {
            (activity as? FragmentResultListener)?.createNewFragment(FragmentEnum.Result)
        }

        binding.btBack.setOnClickListener {
            (activity as? FragmentResultListener)?.popBackstack()

        }
    }

    @SuppressLint("SetTextI18n")
    private fun setFragmentResultCallback() {
        setFragmentResultListener(ResultFragment.REQUEST_KEY) { _, bundle ->
            val result = bundle.getString(ResultFragment.RESULT_HASH_CODE)
            Timber.d("__ received result: $result")
            binding?.tvFragmentResult?.text = "received result\n$result"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
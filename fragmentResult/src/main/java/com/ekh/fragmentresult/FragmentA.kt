package com.ekh.fragmentresult

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.ekh.fragmentresult.databinding.FragmentABinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class FragmentA : Fragment(R.layout.fragment_a) {
    private var binding: FragmentABinding? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultCallback()
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentABinding.bind(view).also { this.binding = it }
//        setFragmentResultCallback()

        binding.btRequest.setOnClickListener {
            (activity as? FragmentResultListener)?.createNewFragment(FragmentEnum.Result)
        }

        binding.btCreateBfragment.setOnClickListener {
            (activity as? FragmentResultListener)?.createNewFragment(FragmentEnum.B)
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
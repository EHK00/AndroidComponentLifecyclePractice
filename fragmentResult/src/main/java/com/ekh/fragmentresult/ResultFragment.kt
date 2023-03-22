package com.ekh.fragmentresult

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.ekh.fragmentresult.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
internal class ResultFragment : Fragment(R.layout.fragment_result) {
    companion object {
        const val REQUEST_KEY = "RESULT_FRAGMENT_RESULT_KEY"
        const val RESULT_HASH_CODE = "RESULT_HASH_CODE"
    }

    var binding: FragmentResultBinding? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentResultBinding.bind(view).also { this.binding = it }
        val result = Any().hashCode().toString()

        binding.tvFragmentResult.text = "result: $result"

        binding.btSendResult.setOnClickListener {
            val bundle = bundleOf(RESULT_HASH_CODE to result)
            setFragmentResult(REQUEST_KEY, bundle)
            Timber.d("__ return result: $result")
            (activity as? FragmentResultListener)?.popBackstack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

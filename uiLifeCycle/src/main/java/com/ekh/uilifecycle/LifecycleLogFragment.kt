package com.ekh.uilifecycle

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import timber.log.Timber

abstract class LifecycleLogFragment : Fragment() {
    private val target = this.javaClass.simpleName

    override fun onAttach(context: Context) {
        Timber.d("__ lifecycle: onAttach $target")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("__ lifecycle: onCreate $target")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("__ lifecycle: onCreateView $target")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.d("__ lifecycle: onViewCreated $target")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Timber.d("__ lifecycle: onViewStateRestored $target")
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

    override fun onSaveInstanceState(outState: Bundle) {
        Timber.d("__ lifecycle: onSaveInstanceState $target")
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        Timber.d("__ lifecycle: onDestroy $target")
        super.onDestroy()
    }

    override fun onDestroyView() {
        Timber.d("__ lifecycle: onDestroyView $target")
        super.onDestroyView()
    }

    override fun onDetach() {
        Timber.d("__ lifecycle: onDetach $target")
        super.onDetach()
    }
}
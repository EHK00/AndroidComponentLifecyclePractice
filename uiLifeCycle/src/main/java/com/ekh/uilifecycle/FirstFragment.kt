package com.ekh.uilifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ekh.uilifecycle.databinding.FragmentFirstBinding


class FirstFragment : LifecycleLogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return FragmentFirstBinding.inflate(layoutInflater).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view.findViewById(R.id.next_button) as Button).apply {
            setOnClickListener {
                (requireActivity() as UiTestMainActivity).navigateTo(SecondFragment())
            }
        }
    }
}
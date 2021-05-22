package com.cube.mailcube.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.cube.mailcube.BR
import com.cube.mailcube.extension.observe
import com.cube.mailcube.extension.toast

internal abstract class BaseViewPagerFragment<VM : BaseViewModel, VB : ViewDataBinding> :
    Fragment() {
    abstract val layoutId: Int
    abstract var viewModel: VM?

    lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.let { observe(it.toast) { toast(it) } }
    }
}
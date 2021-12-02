package com.example.graphqlsample.persenter.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseFragment<DataBinding : ViewDataBinding> : Fragment() {

    private  var _dataBinding: DataBinding? = null
    val dataBinding get() = _dataBinding

    abstract fun getLayoutId(): Int
    abstract fun observer()
    abstract fun setupView()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return _dataBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _dataBinding?.apply {
            lifecycleOwner = this@BaseFragment.viewLifecycleOwner
        }
        setupView()
        observer()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _dataBinding = null
    }
}


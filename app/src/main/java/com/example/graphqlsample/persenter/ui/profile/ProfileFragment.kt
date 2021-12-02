package com.example.graphqlsample.persenter.ui.profile

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.graphqlsample.R
import com.example.graphqlsample.persenter.base.BaseFragment
import com.example.graphqlsample.databinding.FragmentProfileBinding
import com.example.graphqlsample.persenter.utils.Result
import com.example.graphqlsample.persenter.utils.extention.load
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val viewModel: ProfileViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun observer() {
        viewModel.getProfile.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Success -> {
                    dataBinding?.imageViewProfileFragmentProfile?.load(result.data.avatarUrl)
                    dataBinding?.profile = result.data
                }
                is Result.Error ->
                    Toast.makeText(requireContext(),
                        result.exception.message.toString(),
                        Toast.LENGTH_LONG).show()

                else -> Unit
            }
        }
    }

    override fun setupView() {}
}
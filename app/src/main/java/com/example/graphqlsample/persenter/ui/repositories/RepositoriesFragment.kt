package com.example.graphqlsample.persenter.ui.repositories

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.graphqlsample.R
import com.example.graphqlsample.databinding.FragmentRepositoriesBinding
import com.example.graphqlsample.domain.model.Repository
import com.example.graphqlsample.persenter.base.BaseFragment
import com.example.graphqlsample.persenter.ui.repositories.adapter.RepositoriesAdapter
import com.example.graphqlsample.persenter.utils.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepositoriesFragment : BaseFragment<FragmentRepositoriesBinding>() {

    private val viewModel: RepositoriesViewModel by viewModels()

    private val repositoriesAdapter: RepositoriesAdapter by lazy {
        RepositoriesAdapter(lifecycleOwner = this.viewLifecycleOwner)
    }

    override fun getLayoutId(): Int = R.layout.fragment_repositories

    override fun setupView() {
       dataBinding?.recyclerViewRepositoriesFragmentRepositories?.adapter = repositoriesAdapter
    }

    override fun observer() {
        viewModel.getRepository.observe(viewLifecycleOwner) {result ->
            when (result) {
                is Result.Success -> repositoriesAdapter.repositories =  result.data as List<Repository>
                is Result.Error -> {
                    Toast.makeText(requireContext(),result.exception.message.toString(), Toast.LENGTH_LONG).show()
                }
                else -> Unit
            }
        }
    }


}
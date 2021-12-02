package com.example.graphqlsample.persenter.ui.repositories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.graphqlsample.domain.model.Repository
import com.example.graphqlsample.databinding.ItemRepositoryBinding


class RepositoriesAdapter(
    private val lifecycleOwner: LifecycleOwner,
) : RecyclerView.Adapter<RepositoriesAdapter.RepositoriesViewHolder>() {

    private val differ = AsyncListDiffer(this, DiffCallback)

    var repositories: List<Repository> = emptyList()
        set(value) {
            field = value
            differ.submitList(repositories)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder =
        RepositoriesViewHolder(
            ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context),parent,false).apply {
                lifecycleOwner = this@RepositoriesAdapter.lifecycleOwner
            }
        )

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) =
        holder.onBind(repositories[position])


    override fun getItemCount(): Int = repositories.size

    inner class RepositoriesViewHolder(
        private val binding: ItemRepositoryBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(repository: Repository) {
            binding.edge = repository
        }
    }
}

object DiffCallback : DiffUtil.ItemCallback<Repository>() {

    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean =
        oldItem == newItem
}
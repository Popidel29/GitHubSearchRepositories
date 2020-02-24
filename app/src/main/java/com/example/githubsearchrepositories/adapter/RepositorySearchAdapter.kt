package com.example.githubsearchrepositories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsearchrepositories.R
import com.example.githubsearchrepositories.model.RepositoryModel
import kotlinx.android.synthetic.main.repository_list.view.*

class RepositorySearchAdapter(val repositoryModel: RepositoryModel) : RecyclerView
.Adapter<RepositorySearchAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.repository_list
                , parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return repositoryModel.items.size
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.repositoryName.text = repositoryModel.items[position].name
    }

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repositoryName = itemView.tvRepositories
    }
}
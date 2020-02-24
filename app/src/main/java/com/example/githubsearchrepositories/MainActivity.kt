package com.example.githubsearchrepositories

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubsearchrepositories.adapter.RepositorySearchAdapter
import com.example.githubsearchrepositories.repository.RepositorySearchImpl
import com.example.githubsearchrepositories.viewmodel.RepositoryViewModel
import com.example.githubsearchrepositories.viewmodel.RepositoryViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val repositoryViewModel = ViewModelProvider(
            this,
            RepositoryViewModelFactory(RepositorySearchImpl())
        ).get(RepositoryViewModel::class.java)

        repositoryViewModel.repositoryLiveDataSuccess.observe(this, Observer { searchUpdate ->
            recyclerViewRepositories.adapter = RepositorySearchAdapter(searchUpdate)
            recyclerViewRepositories.layoutManager = LinearLayoutManager(this)
            showHits.text = getString(R.string.showHits, searchUpdate.totalCount.toString())
        })
        repoSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().isEmpty()) {
                    recyclerViewRepositories.adapter = null
                    showHits.text = getString(R.string.showHits, "0")

                } else {
                    repositoryViewModel.getRepositorySearch(s.toString())
                }
            }
        })
    }
}




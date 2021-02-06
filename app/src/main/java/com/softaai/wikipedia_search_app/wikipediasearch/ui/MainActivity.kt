package com.softaai.wikipedia_search_app.wikipediasearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softaai.wikipedia_search_app.R
import com.softaai.wikipedia_search_app.wikipediasearch.adapter.WikiSearchListAdapter
import com.softaai.wikipedia_search_app.wikipediasearch.viewmodel.WikiSearchViewModel

class MainActivity : AppCompatActivity() {

    private val wikiSearchViewModel : WikiSearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WikiSearchListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        wikiSearchViewModel.fetchWikiSearchPageList()

        wikiSearchViewModel.wikiSearchPageListLiveData.observe(this, Observer { pages ->
            pages.let { adapter.submitList(it) }
        })

    }
}
package com.on.fsp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.on.fsp.R
import com.on.fsp.utils.Status

class EpisodesFragment : Fragment() {

    companion object {
        fun newInstance() = EpisodesFragment()
    }

    private lateinit var viewModel: EpisodesViewModel
    private lateinit var adapter: EpisodesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        println("########## view EpisodesFragment onCreateView")
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        view.apply {
            recyclerView = findViewById(R.id.recyclerView)
            progressBar = findViewById(R.id.progressBar)
            println("########## view EpisodesFragment")
        }

        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EpisodesViewModel::class.java)

        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = EpisodesAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getEpisodes().observe(viewLifecycleOwner) { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    recyclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    resource.data?.let { users -> adapter.addUsers(users) }
                    println("######### Observers SUCCESS")
                }
                Status.ERROR -> {
                    recyclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    Toast.makeText(context, resource.message, Toast.LENGTH_LONG).show()
                    println("######### Observers ERROR")
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                    println("######### Observers LOADING")
                }
            }
        }
    }
}
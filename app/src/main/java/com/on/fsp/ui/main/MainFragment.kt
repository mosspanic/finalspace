package com.on.fsp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import com.on.fsp.R
import com.on.fsp.data.model.User
import com.on.fsp.utils.Status
import com.on.fsp.ui.main.userdetails.UserDetailsFragment

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private val mainAdapter: MainAdapter by lazy { MainAdapter(arrayListOf()) }

    private val userCLickListener by lazy {
        MainAdapter.UserCLickListener { id ->
            val userFragment = UserDetailsFragment()
            val bundle = Bundle()
            bundle.putString(UserDetailsFragment.USER_ID, id)
            userFragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.MainActivity, userFragment, UserDetailsFragment.TAG).addToBackStack("").commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        println("########## view MainFragment onCreateView")
        val view = inflater.inflate(R.layout.main_fragment, container, false)

//скрытие основной картинки
        /*val v:View = inflater.inflate(R.layout.activity_main); println("####### скрытие основы inflater")
        val innerView = v.findViewById<ImageButton>(R.id.mainActivityButton);    println("####### скрытие основы findViewById")
        innerView.setVisibility(View.GONE)*/

        view.apply {
            recyclerView = findViewById(R.id.recyclerView)
            progressBar = findViewById(R.id.progressBar)
            println("########## view MainFragment")
            //val cont = findViewById(R.id.lcontainer)

            //cont.setOnClickListener(View.OnClickListener {                println("##########view")            })
        }

        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        mainAdapter.userCLickListener = userCLickListener
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getUsers().observe(viewLifecycleOwner) { resource ->
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
/*
private fun LayoutInflater.inflate(activityMain: Int): View {//функция для скрытия основной картинки
    println("###t#### скрытие основы")
return inflate(R.layout.activity_main)
}
*/
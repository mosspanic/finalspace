package com.on.fsp.ui.main.userdetails

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.on.fsp.R
import com.on.fsp.data.model.User

class UserDetailsFragment : Fragment(R.layout.user_fragment) {

    private val userId by lazy { arguments?.getString(USER_ID) }
    private val viewModel: UserDetailsViewModel by lazy { ViewModelProvider(this).get(UserDetailsViewModel::class.java) }

    private val userObserver = Observer<User?> {
        it ?: return@Observer
        requireView().findViewById<TextView>(R.id.userName).text = it.name
        requireView().findViewById<TextView>(R.id.userSpecies).text = it.species
        requireView().findViewById<TextView>(R.id.userGender).text = it.id

        val imageViewAvatar = requireView().findViewById<ImageView>(R.id.userAvatar)

        Glide.with(imageViewAvatar.context)
            .load(it.avatar)
            .into(imageViewAvatar)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userId?.let { viewModel.loadUserInfo(it) }
        viewModel.user.observe(viewLifecycleOwner, userObserver)
    }

    companion object {
        const val TAG = "userFragment"
        const val USER_ID = "userId"
    }
}
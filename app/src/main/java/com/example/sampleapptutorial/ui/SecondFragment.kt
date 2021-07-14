package com.example.sampleapptutorial.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.navArgs
import coil.load
import coil.transform.CircleCropTransformation
import com.example.sampleapptutorial.R
import com.example.sampleapptutorial.databinding.FragmentSecondBinding
import com.example.sampleapptutorial.model.User
import com.example.sampleapptutorial.network.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondFragment : Fragment() {

    private val args: SecondFragmentArgs by navArgs()
    private lateinit var binding : FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSecondBinding.inflate(inflater, container, false)

        val api = Retrofit().api

        api.getUser(args.username).enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                binding.bioTextView.text = response.body()?.bio
                binding.usernameTextView.text = response.body()?.name
                binding.companyTextView.text = response.body()?.company
                binding.locationTextView.text = response.body()?.location
                binding.avatarImageView.load(response.body()?.avatar_url) {
                    transformations(CircleCropTransformation())
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("error", "onFailure: ${t.localizedMessage}")
            }
        })

        return binding.root
    }

}
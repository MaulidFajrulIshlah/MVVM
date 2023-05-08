package com.geminiboy.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geminiboy.mvvm.databinding.ActivityMainBinding
import com.geminiboy.mvvm.viewmodel.ViewModelUser

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var useradapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setVmAdapter()
    }

    fun setVmAdapter() {
        val viewModel = ViewModelProvider(this).get(ViewModelUser::class.java)
        viewModel.getliveDataUser().observe(this, Observer {
            useradapter = UserAdapter(it)
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvUser.layoutManager = layoutManager
            binding.rvUser.adapter = UserAdapter(it)
        })
        viewModel.callApiUser()
    }
}
package com.geminiboy.mvvm.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geminiboy.mvvm.databinding.ItemUserBinding
import com.geminiboy.mvvm.model.getAllUserItem

class UserAdapter(var listuser : List<getAllUserItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder (var binding: ItemUserBinding):RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        var view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.tvname.text = listuser[position].name
        holder.binding.tvage.text = listuser[position].age.toString()
        holder.binding.tvaddress.text = listuser[position].address
        holder.binding.tvusername.text = listuser[position].username
        holder.binding.tvpass.text = listuser[position].password
    }

    override fun getItemCount(): Int {
        return listuser.size
    }
}
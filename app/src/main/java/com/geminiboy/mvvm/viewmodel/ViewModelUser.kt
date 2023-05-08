package com.geminiboy.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geminiboy.mvvm.model.getAllUserItem
import com.geminiboy.mvvm.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser : ViewModel() {

    var liveDataUser : MutableLiveData<List<getAllUserItem>> = MutableLiveData()

    fun getliveDataUser() :MutableLiveData<List<getAllUserItem>>{
        return  liveDataUser
    }

    fun callApiUser() {
        ApiClient.instance.getAllUser().enqueue(object : Callback<List<getAllUserItem>>{
            override fun onResponse(
                call: Call<List<getAllUserItem>>,
                response: Response<List<getAllUserItem>>
            ) {
                if (response.isSuccessful) {
                    liveDataUser.postValue(response.body())
                } else {
                    liveDataUser.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<getAllUserItem>>, t: Throwable) {
                liveDataUser.postValue(null)
            }

        })

    }


}
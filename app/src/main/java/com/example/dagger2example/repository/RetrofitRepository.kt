package com.example.dagger2example.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dagger2example.MyRetroApplication
import com.example.dagger2example.model.PostInfo
import com.example.dagger2example.network.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitRepository {
    var postInfoMutableList: MutableLiveData<List<PostInfo>> = MutableLiveData()

    @Inject
    lateinit var retrofit: Retrofit

    init {
        val apiComponent = MyRetroApplication.apiComponent
        apiComponent.inject(this)
    }

    fun fetchPostInfoList(): LiveData<List<PostInfo>> {
        val apiService = retrofit.create(APIService::class.java)
        val postListInfo: Call<List<PostInfo>> = apiService.makeRequest()

        postListInfo.enqueue(object : Callback<List<PostInfo>> {
            override fun onFailure(call: Call<List<PostInfo>>, t: Throwable) {
                Log.v("RetroRepository", "Failed::" + t.message)
            }

            override fun onResponse(
                call: Call<List<PostInfo>>,
                response: Response<List<PostInfo>>
            ) {
                val postInfoList = response.body()
                postInfoMutableList.value = postInfoList
            }
        })
        return postInfoMutableList
    }

}
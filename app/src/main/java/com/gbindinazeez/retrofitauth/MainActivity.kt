package com.gbindinazeez.retrofitauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gbindinazeez.retrofitauth.network.ApiClient
import com.gbindinazeez.retrofitauth.post.PostsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fetchPosts(){

        // Pass the token as parameter
        apiClient.getApiService(this).fetchPosts()
            .enqueue(object : Callback<PostsResponse>{
                override fun onResponse(
                    call: Call<PostsResponse>,
                    response: Response<PostsResponse>
                ) {
                    // Handle function to display posts

                }

                override fun onFailure(call: Call<PostsResponse>, t: Throwable) {
                    // Error fetching posts
                }

            })
    }
}
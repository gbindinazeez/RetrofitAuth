package com.gbindinazeez.retrofitauth.network

import com.gbindinazeez.retrofitauth.LoginRequest
import com.gbindinazeez.retrofitauth.LoginResponse
import com.gbindinazeez.retrofitauth.post.PostsResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST(Constants.LOGIN_URL)
    @FormUrlEncoded
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET(Constants.POSTS_URL)
    fun fetchPosts(@Header("Authorization") token: String): Call<PostsResponse>
}
package com.gbindinazeez.retrofitauth

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status_code")
    var statuscode: Int,

    @SerializedName("auth_token")
    var authToken: String,

    @SerializedName("user")
    var user: User
)

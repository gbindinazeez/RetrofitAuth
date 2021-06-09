package com.gbindinazeez.retrofitauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gbindinazeez.retrofitauth.network.ApiClient
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        apiClient = ApiClient()
        sessionManager = SessionManager(this)

        apiClient.getApiService().login(LoginRequest(email = "s@sample.com", password = "mypassword"))
            .enqueue(object : retrofit2.Callback<LoginResponse>{
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                val loginResponse = response.body()

                    if (loginResponse?.statuscode == 200 && loginResponse.user != null){
                        sessionManager.saveAuthToken(loginResponse.authToken)
                    } else {
                        // Error logging in
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // Error logging in
                }

            })
    }
}
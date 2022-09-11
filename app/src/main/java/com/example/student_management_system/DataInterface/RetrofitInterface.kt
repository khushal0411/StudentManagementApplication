package com.example.student_management_system.DataInterface

import com.example.student_management_system.helper.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitInterface {
    companion object {
        private var retrofitInterface: RetrofitInterface? = null
        fun getInstance(): RetrofitInterface {
            if (retrofitInterface == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.Variables.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitInterface = retrofit.create(RetrofitInterface::class.java)
            }
            return retrofitInterface!!
        }
    }
}
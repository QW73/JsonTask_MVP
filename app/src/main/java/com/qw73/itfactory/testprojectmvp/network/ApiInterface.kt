package com.qw73.itfactory.testprojectmvp.network

import com.qw73.itfactory.testprojectmvp.model.SectionsList
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("05b0db32009fa4e548a3")
    fun getAllSections(): Call<SectionsList>
}
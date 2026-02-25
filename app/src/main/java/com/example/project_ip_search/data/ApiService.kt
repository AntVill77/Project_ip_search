package com.example.project_ip_search.data

import com.example.project_ip_search.model.GamesModel
import com.example.project_ip_search.model.IpModel
import com.example.project_ip_search.util.Constants.Companion.API_KEY
import com.example.project_ip_search.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService{

    @GET(ENDPOINT + API_KEY)
    suspend fun getId(): Response<GamesModel>

    @GET("$ENDPOINT/{id}$API_KEY")
    suspend fun getIpSingle(@Path(value = "id") id: String): Response<IpModel>
}
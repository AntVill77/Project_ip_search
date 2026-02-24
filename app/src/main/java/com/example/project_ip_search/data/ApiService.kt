package com.example.project_ip_search.data

import com.example.project_ip_search.model.IdModel
import com.example.project_ip_search.util.Constants.Companion.API_KEY
import com.example.project_ip_search.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService{

    @GET(ENDPOINT + API_KEY)
    suspend fun getId(): Response<IdModel>
}
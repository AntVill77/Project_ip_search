package com.example.project_ip_search.repository

import android.util.Log
import com.example.project_ip_search.data.ApiService
import com.example.project_ip_search.model.IdModel2
import com.example.project_ip_search.model.IpModel
import javax.inject.Inject

class IdRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getId(): IdModel2? {
        val response = apiService.getId()
        if (response.isSuccessful) {
            //return response.body()?.status as List<IdModel>?
            return response.body()?.area
            Log.d("games2", "response $response")
        } else {
            Log.d("games2", "response ${response.toString()}")
        }
        return null
    }


   /* suspend fun getIpSingle(id: String): IpModel? {
        val response = apiService.getIpSingle(id)

        if(response.isSuccessful){
            return response.body()
        }
        return null
    }*/
    suspend fun getIpSingle(id: String): IpModel? {
        val response = apiService.getIpSingle(id)
        if(response.isSuccessful){
            return response.body()
        }
        return null
    }
}
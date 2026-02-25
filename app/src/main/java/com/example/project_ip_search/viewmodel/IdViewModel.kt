package com.example.project_ip_search.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_ip_search.repository.IdRepository
import com.example.project_ip_search.state.IpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.String

@HiltViewModel
class IdViewModel @Inject constructor(private val repository: IdRepository) : ViewModel() {

    var state by mutableStateOf(IpState())
        private set

    var text by mutableStateOf("")
        private set

    var items = mutableStateListOf(text)

    init {
        //getIpSingle()
    }

    fun getIpSingle(id: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repository.getIpSingle(id)
                state = state.copy(
                    ip = result?.ip ?: "",
                    status = result?.status ?: "",
                    type = result?.type ?: "",
                    postcode = result?.postcode ?: "",
                    location = result?.location ?: state.location,
                    city = result?.city ?: state.city,
                    continent = result?.continent ?: state.continent,
                    country = result?.country ?: state.country

                )
            }
        }
    }

    fun clean(){
        state = state.copy(
            ip =  "",
            status =  "",
            type =  ""
        )
    }
}

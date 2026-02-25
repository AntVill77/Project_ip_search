package com.example.project_ip_search.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_ip_search.model.GamesModel
import com.example.project_ip_search.model.IpModel
import com.example.project_ip_search.repository.IdRepository
import com.example.project_ip_search.state.IpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.String
import kotlin.collections.emptyList

@HiltViewModel
class IdViewModel @Inject constructor(private val repository: IdRepository) : ViewModel() {

    private val _id = MutableStateFlow(IpModel("0","10","0"))
    val id = _id.asStateFlow()

    var state by mutableStateOf(IpState())
        private set

    init {
       //fetchId()
        getIpSingle()
    }

    private fun fetchId() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getId()?.name
               // if (result != null) {
                    //_id.value = ((result ?: emptyList())
                _id.value = (result ?: IpModel("0", "10","0")) as IpModel
              //  }
            }
        }
    }

    fun getIpSingle(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repository.getIpSingle()
                state = state.copy(
                    //ip = ip,
                    ip = result?.ip ?: "",
                    status = result?.status ?: "",
                    type = result?.type ?: ""
                )
            }
        }
    }
   /* fun getIpSingle(ip: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repository.getIpSingle(ip)
                state = state.copy(
                    //ip = ip,
                    ip = result?.ip ?: ip,
                    status = result?.status ?: "",
                    type = result?.type ?: ""
                )
            }
        }
    }*/
}

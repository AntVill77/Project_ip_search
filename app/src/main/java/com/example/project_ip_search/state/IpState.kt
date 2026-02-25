package com.example.project_ip_search.state

import com.example.project_ip_search.model.City
import com.example.project_ip_search.model.Continent
import com.example.project_ip_search.model.Country
import com.example.project_ip_search.model.Flag
import com.example.project_ip_search.model.Languages
import com.example.project_ip_search.model.Location

data class IpState(
    val ip: String = "",
    val postcode: Any = "",
    val status: String = "",
    val type: String = "",
    val location: Location = Location(0.0,0.0),
    val city: City = City(0,"",0),
    val continent: Continent = Continent("",0,""),
    val country: Country = Country("", "", "",
        Flag("", "", ""), 0, false, Languages("", "", ""), "", "", 0, "")
)

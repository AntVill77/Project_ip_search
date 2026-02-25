package com.example.project_ip_search.model

data class IpModel(
    val ip: String,
    val postcode: Any,
    val status: String,
    val type: String,
    val location: Location,
    val city: City,
    val continent: Continent,
    val country: Country,
)
data class GamesModel(
    val area: IdModel2,
    val asn: Asn,
    val city: City,
    val continent: Continent,
    val country: Country,
    val currency: Currency,
    val ip: String,
    val location: Location,
    val postcode: Any,
    val security: Security,
    val status: String,
    val time: Time,
    val type: String
)

data class IdModel2(
    val code: String,
    val geonameid: Int,
    val name: String
)

data class Asn(
    val number: Int,
    val organisation: String
)

data class City(
    val geonameid: Int,
    val name: String,
    val population: Int
)

data class Continent(
    val code: String,
    val geonameid: Int,
    val name: String
)

data class Country(
    val area_size: String,
    val capital: String,
    val code: String,
    val flag: Flag,
    val geonameid: Int,
    val is_in_eu: Boolean,
    val languages: Languages,
    val name: String,
    val phone_code: String,
    val population: Int,
    val tld: String
)

data class Currency(
    val code: String,
    val name: String
)

data class Flag(
    val emoji: String,
    val file: String,
    val unicode: String
)

data class Languages(
    val el: String,
    val en: String,
    val tr: String
)

data class Location(
    val latitude: Double,
    val longitude: Double
)

data class Security(
    val is_crawler: Boolean,
    val is_proxy: Boolean,
    val is_threat: Boolean,
    val is_tor: Boolean
)

data class Time(
    val code: String,
    val gmt_offset: Int,
    val is_daylight_saving: Boolean,
    val timezone: String
)



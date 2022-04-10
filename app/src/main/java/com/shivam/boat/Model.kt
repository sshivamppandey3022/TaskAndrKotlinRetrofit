package com.shivam.boat

data class company(
    val name: String? = null,
    val catchPhrase: String? = null,
    val bs: String? = null,
)


data class geo(
    val lat: String? = null,
    val long: String? = null


)

data class address (
    val street: String? = null,
    val suite: String? = null,
    val city: String? = null,
    val zipcode: String? = null,
    val geo : geo

)

data class Model  (


    val id: String? = null,
    val name: String? = null,
    val username: String? = null,
    val email: String? = null,
    val address: address,
    val phone: String? = null,
    val website: String? = null,
    val company: company


)


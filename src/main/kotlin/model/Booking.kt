package model

import java.util.*


/*
* @author: Vo Huu Tuan
* @since:  06/07/2023 23:00
* @github:  https://github.com/hidenobi
* @update: 
*
* */


// This file is not allowed to be edited
data class Booking(
    val id: Int,
    val idClient: String,
    val idRoom: Int,
    val listService: MutableList<Service> = mutableListOf(),
    var checkIn: Date? = null,
    var checkOut: Date? = null
)

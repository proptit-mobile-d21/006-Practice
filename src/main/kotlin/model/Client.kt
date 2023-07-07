package model


/*
* @author: Vo Huu Tuan
* @since:  06/07/2023 20:45
* @github:  https://github.com/hidenobi
* @update: 
*
* */


// This file is not allowed to be edited
data class Client(
    val idCard: String,
    val name: String,
    val address: String,
    val phoneNumber: String,
    val email: String?,
    val note: String?
)

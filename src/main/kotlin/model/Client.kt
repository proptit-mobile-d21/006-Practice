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
    var idCard: String,
    var name: String,
    var address: String,
    var phoneNumber: String,
    var email: String?,
    var note: String?
)

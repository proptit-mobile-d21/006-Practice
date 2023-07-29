package model

import other.RoomType


/*
* @author: Vo Huu Tuan
* @since:  06/07/2023 20:38
* @github:  https://github.com/hidenobi
* @update: 
*
* */


// This file is not allowed to be edited
data class Room(var id: Int, var roomType: RoomType, var price: Long, var roomNumber: String, var note: String? = null)

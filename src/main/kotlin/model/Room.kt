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
data class Room(val id: Int, val roomType: RoomType, val price: Long, val roomNumber: String, val note: String? = null)

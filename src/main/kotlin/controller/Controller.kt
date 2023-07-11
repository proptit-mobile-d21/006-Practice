package controller

import data.AllDataForExam
import model.Room

class Controller(private val roomManagement: RoomManagement) {
    private lateinit var roomList: List<Room>

    fun init(){
        roomList = roomManagement.initList(AllDataForExam.roomList)
    }

    fun showRoomList(): List<Room>{
        return roomManagement.showList(roomList)
    }
}
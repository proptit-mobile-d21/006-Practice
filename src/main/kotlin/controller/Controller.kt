package controller

import data.AllDataForExam
import model.Client
import model.Room
import model.Service

class Controller(private val roomManagement: RoomManagement) {
    private lateinit var roomList: List<Room>
    private lateinit var clientList: List<Client>
    private lateinit var serviceList: List<Service>


    fun init(){
        roomList = roomManagement.initList(AllDataForExam.roomList)
        clientList = roomManagement.initList(AllDataForExam.clientList)
        serviceList = roomManagement.initList(AllDataForExam.serviceList)
    }

    fun showRoomList(): List<Room>{
        return roomManagement.showList(roomList)
    }

    fun showClientList(): List<Client>{
        return roomManagement.showList(clientList)
    }
    fun showServiceList(): List<Service>{
        return roomManagement.showList(serviceList)
    }
}
package controller

import data.AllDataForExam
import model.Client
import model.Room
import model.Service

class Controller(private val roomManagement: RoomManagement) {
    private lateinit var roomList: MutableList<Room>
    private lateinit var clientList: MutableList<Client>
    private lateinit var serviceList: MutableList<Service>


    fun init(){
        roomList = roomManagement.initList(AllDataForExam.roomList).toMutableList()
        clientList = roomManagement.initList(AllDataForExam.clientList).toMutableList()
        serviceList = roomManagement.initList(AllDataForExam.serviceList).toMutableList()
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

    fun sortRoomList(opt: Int) {
        when (opt) {
            1 -> {
                roomList.sortBy { it.roomNumber }
            }
            2 -> {
                roomList.sortBy { it.roomType }
            }
            3 -> {
                //roomList.sortedBy { it.price }
                roomList.sortBy { it.price }
            }

        }
    }

    fun sortClientList(opt: Int) {
        when (opt) {
            1 -> {
                clientList.sortBy { it.name }
            }
            2 -> {
                clientList.sortBy { it.idCard }
            }
            3 -> {
                clientList.sortBy { it.address }
            }

        }
    }

    fun sortServiceList(opt: Int){
        when (opt) {
            1 -> {
                serviceList.sortBy { it.name }
            }
            2 -> {
                serviceList.sortBy { it.id }
            }
            3 -> {
                serviceList.sortBy { it.price }

            }

        }
    }
}
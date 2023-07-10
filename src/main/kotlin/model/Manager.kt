package model

import data.AllDataForExam

class Manager {
    private var roomList = mutableListOf<Room>()
    private var clientList = mutableListOf<Client>()
    private var serviceList = mutableListOf<Service>()
    private var tempRoomList = mutableListOf<Room>()

    init {
        roomList = AllDataForExam.roomList.toMutableList()
        clientList = AllDataForExam.clientList.toMutableList()
        serviceList = AllDataForExam.serviceList.toMutableList()
    }

    // Sắp xếp phòng
    val showByRoomType: () -> Unit = {
        val sortedList = roomList.sortedBy { it.roomType }
        sortedList.forEach { println(it) }
    }
    val showByPrice: () -> Unit = {
        val sortedList = roomList.sortedBy { it.price }
        sortedList.forEach { println(it) }
    }
    val showByRoomID: () -> Unit = {
        roomList.forEach { println(it) }
    }

    // Sắp xếp khách hàng
    val showByClientName: () -> Unit = {
        val sortedList = clientList.sortedBy { it.name }
        sortedList.forEach { println(it) }
    }
    val showByClientID: () -> Unit = {
        clientList.forEach { println(it) }
    }

    // Sắp xếp dịch vụ
    val showByServiceName: () -> Unit = {
        val sortedList = serviceList.sortedBy { it.name }
        sortedList.forEach { println(it) }
    }
    val showByServicePrice: () -> Unit = {
        val sortedList = serviceList.sortedBy { it.price }
        sortedList.forEach { println(it) }
    }
    val showByServiceID: () -> Unit = {
        serviceList.forEach { println(it) }
    }

    // Tìm kiếm phòng
    val findByRoomID: (Int) -> Unit = {id ->
        roomList.filter { it.id.equals(id) }.forEach{ println(it) }
    }

    fun editRoom(num: Int, id: Int){
        when(num){
            1 -> {
                print("Enter New ID: ")
                val inputID = readln()!!.toInt()
                roomList.forEachIndexed { index, it ->
                    if(it.id.equals(id)){
                        val newID = inputID
                        val newRoomType = it.roomType
                        val newPrice = it.price
                        val newRoomNumber = it.roomNumber
                        val newNote = it.note
                        val newRoom = Room(newID, newRoomType, newPrice, newRoomNumber, newNote)
                        tempRoomList.add(newRoom)
                    }
                }
                roomList.addAll(tempRoomList)
            }
        }
    }



}

package model

import data.AllDataForExam

class Manager {

    // Init
    private val bookingList: MutableList<Booking> = mutableListOf()
    private val clientList: MutableList<Client> = AllDataForExam.clientList.toMutableList()
    private val roomList: MutableList<Room> = AllDataForExam.roomList.toMutableList()
    private val serviceList: MutableList<Service> = AllDataForExam.serviceList.toMutableList()

    // Choice 1
    private fun <T, R : Comparable<R>> sortByThenPrint(list: MutableList<T>, selector: (T) -> R?) {
        list.sortBy(selector)
        for (it in list)
            println(it)
    }

    // Room
    fun showRoomById() {
        sortByThenPrint(roomList) { it.id }
    }

    fun showRoomByType() {
        sortByThenPrint(roomList) { it.roomType }
    }

    fun showRoomByPrice() {
        sortByThenPrint(roomList) { it.price }
    }

    fun showRoomByNumber() {
        sortByThenPrint(roomList) { it.roomNumber }
    }

    // Client
    fun showClientById() {
        sortByThenPrint(clientList) { it.idCard }
    }

    fun showClientByName() {
        sortByThenPrint(clientList) { it.name }
    }

    fun showClientByAddress() {
        sortByThenPrint(clientList) { it.address }
    }

    fun showClientByPhoneNumber() {
        sortByThenPrint(clientList) { it.phoneNumber }
    }

    // Service
    fun showServiceById() {
        sortByThenPrint(serviceList) { it.id }
    }

    fun showServiceByName() {
        sortByThenPrint(serviceList) { it.name }
    }

    fun showServiceByPrice() {
        sortByThenPrint(serviceList) { it.price }
    }
}
package model

import data.AllDataForExam

object Manager {
    private var listClient = mutableListOf<Client>()
    private var listRoom = mutableListOf<Room>()
    private var listBooking = mutableListOf<Booking>()
    private var listService = mutableListOf<Service>()
    enum class ClientSort{
        ID_CARD, NAME, ADDRESS, PHONE_NUMBER, EMAIL
    }
    enum class RoomSort{
        ID, ROOM_TYPE, PRICE, ROOM_NUMBER
    }
    enum class ServiceSort{
        ID, NAME, PRICE
    }
    init {
        listClient = AllDataForExam.clientList.toMutableList()
        listRoom = AllDataForExam.roomList.toMutableList()
        listService = AllDataForExam.serviceList.toMutableList()
    }
    private fun <T> printList(list : MutableList<T>){
        list.forEach {
            println(it)
        }
    }
    fun printListClient() {
        printList(listClient)
    }
    fun printListRoom() {
        printList(listRoom)
    }
     fun printListService() {
        printList(listService)
    }

    fun sortClient(sort: ClientSort){
        when(sort){
            ClientSort.ID_CARD -> listClient.sortBy { it.idCard }
            ClientSort.NAME -> listClient.sortBy { it.name }
            ClientSort.ADDRESS -> listClient.sortBy { it.address }
            ClientSort.PHONE_NUMBER -> listClient.sortBy { it.phoneNumber }
            ClientSort.EMAIL -> listClient.sortBy { it.email }
        }
    }
    fun sortRoom(sort : RoomSort){
        when(sort){
            RoomSort.ID -> listRoom.sortBy { it.id }
            RoomSort.ROOM_TYPE -> listRoom.sortBy { it.roomType }
            RoomSort.PRICE -> listRoom.sortBy { it.price }
            RoomSort.ROOM_NUMBER -> listRoom.sortBy { it.roomNumber }
        }
    }
    fun sortService(sort : ServiceSort){
        when(sort){
            ServiceSort.ID -> listService.sortBy { it.id }
            ServiceSort.NAME -> listService.sortBy { it.name }
            ServiceSort.PRICE -> listService.sortBy { it.price }
        }
    }


}
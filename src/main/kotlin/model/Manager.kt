package model

import data.AllDataForExam

object Manager {
    private var listClient = mutableListOf<Client>()
    private var listRoom = mutableListOf<Room>()
    private var listBooking = mutableListOf<Booking>()
    private var listService = mutableListOf<Service>()
    enum class SortField {
        ID, NAME, ADDRESS, PHONE_NUMBER, EMAIL, TYPE, PRICE, ROOM_NUMBER
    }
//    enum class ClientSort{
//        ID_CARD, NAME, ADDRESS, PHONE_NUMBER, EMAIL
//    }
//    enum class RoomSort{
//        ID, ROOM_TYPE, PRICE, ROOM_NUMBER
//    }
//    enum class ServiceSort{
//        ID, NAME, PRICE
//    }
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

    private fun <T , R : Comparable<R>> sortList(list: MutableList<T>, sortField: SortField, selector : (T) -> R?){
        list.sortBy{selector(it)}
    }
    fun sortClient(sortField: SortField) {
        sortList(listClient, sortField) { client ->
            when (sortField) {
                SortField.ID -> client.idCard
                SortField.NAME -> client.name
                SortField.ADDRESS -> client.address
                SortField.PHONE_NUMBER -> client.phoneNumber
                SortField.EMAIL -> client.email
                else -> {
                    null
                }
            }
        }
    }
    fun sortRoom(sortField: SortField){
        sortList(listRoom, sortField){room ->
            when(sortField){
                SortField.ID -> room.id.toString()
                SortField.TYPE -> room.roomType.toString()
                SortField.PRICE -> room.price.toString()
                SortField.ROOM_NUMBER -> room.roomNumber
                else -> {
                    null
                }
            }
        }
    }
    fun sortService(sortField : SortField){
        sortList(listService, sortField){service ->
            when(sortField){
                SortField.ID -> service.id.toString()
                SortField.NAME -> service.name
                SortField.PRICE -> service.price.toString()
                else -> {
                    null
                }
            }
        }
    }


}
package model

import data.AllDataForExam
import other.RoomType

object Manager {
    private var listClient = mutableListOf<Client>()
    private var listRoom = mutableListOf<Room>()
    private var listBooking = mutableListOf<Booking>()
    private var listService = mutableListOf<Service>()
    enum class SortField {
        ID, NAME, ADDRESS, PHONE_NUMBER, EMAIL, TYPE, PRICE, ROOM_NUMBER, NOTE
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

    private fun <T , R : Comparable<R>> sortList(list: MutableList<T>,  selector : (T) -> R?){
        list.sortBy{selector(it)}
    }
    fun sortClient(sortField: SortField) {
        sortList(listClient) { client ->
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
        sortList(listRoom){room ->
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
        sortList(listService){service ->
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

   private fun <T> List<T>.customFilter(filterFunction : (T) -> Boolean) : List<T>{
       val list = mutableListOf<T>()
        for(it in this){
            if(filterFunction(it)){
                list.add(it)
            }
        }
       return list
   }
    fun searchClient(searchField: SortField, data : String) : List<String>{
        val list = listClient.customFilter { client ->
            when(searchField){
                SortField.ID -> client.idCard.contains(data)
                SortField.NAME -> client.name.contains(data)
                SortField.ADDRESS -> client.address.contains(data)
                SortField.PHONE_NUMBER -> client.phoneNumber.contains(data)
                SortField.EMAIL -> client.email?.contains(data) ?: true
                else -> true
            }
        }.toMutableList()
        printList(list)
        return list.map { it.idCard }
    }
    fun searchRoom(searchField: SortField, data: String) : List<Int>{
        val list = listRoom.customFilter { room ->
            when(searchField){
                SortField.ID -> room.id.toString().contains(data)
                SortField.TYPE -> room.roomType.toString().contains(data)
                SortField.PRICE -> room.price.toString().contains(data)
                SortField.ROOM_NUMBER -> room.roomNumber.contains(data)
                else -> {
                    true
                }
            }
        }.toMutableList()
        printList(list)
        return list.map { it.id }
    }
    fun searchService(searchField: SortField, data : String) : List<Int>{
        val list = listService.customFilter { service: Service ->
            when(searchField){
                SortField.ID -> service.id.toString().contains(data)
                SortField.NAME -> service.name.contains(data)
                SortField.PRICE -> service.price.toString().contains(data)
                else -> {
                    true
                }
            }
        }.toMutableList()
        printList(list)
        return list.map { it.id }
    }
    fun editClient(id: String, data: String, field: SortField) {
        val index = listClient.indexOfFirst { it.idCard == id }
        if (index != -1) {
            val oldClient = listClient[index]
            val newClient = when (field) {
                SortField.NAME -> oldClient.copy(name = data)
                SortField.EMAIL -> oldClient.copy(email = data)
                SortField.ADDRESS -> oldClient.copy(address = data)
                SortField.PHONE_NUMBER -> oldClient.copy(phoneNumber = data)
                else -> oldClient.copy()
            }
            listClient[index] = newClient
        }
    }
    fun editRoom(id: Int, data: String, field: SortField) {
        val index = listRoom.indexOfFirst { it.id == id }
        if (index != -1) {
            val oldRoom = listRoom[index]
            val newRoom = when (field) {
                SortField.TYPE -> oldRoom.copy(roomType = RoomType.valueOf(data))
                SortField.PRICE -> oldRoom.copy(price = data.toLong())
                SortField.ROOM_NUMBER -> oldRoom.copy(roomNumber =  data)
                SortField.NOTE -> oldRoom.copy(note = data)
                else -> oldRoom.copy()
            }
            listRoom[index] = newRoom
        }
    }

    fun editService(id: Int, data: String, field: SortField) {
        val index = listService.indexOfFirst { it.id == id }
        if (index != -1) {
            val oldService = listService[index]
            val newService = when (field) {
                SortField.PRICE -> oldService.copy(price = data.toLong())
                SortField.NAME -> oldService.copy(name = data)
                else -> oldService.copy()
            }
            listService[index] = newService
        }
    }

}
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
    fun searchClient(searchField: SortField, data : String){
        printList(listClient.customFilter { client ->
            when(searchField){
                SortField.ID -> client.idCard.contains(data)
                SortField.NAME -> client.name.contains(data)
                SortField.ADDRESS -> client.address.contains(data)
                SortField.PHONE_NUMBER -> client.phoneNumber.contains(data)
                SortField.EMAIL -> client.email?.contains(data) ?: true
                else -> true
            }
        }.toMutableList())
    }
    fun searchRoom(searchField: SortField, data: String){
        printList(listRoom.customFilter { room ->
            when(searchField){
                SortField.ID -> room.id.toString().contains(data)
                SortField.TYPE -> room.roomType.toString().contains(data)
                SortField.PRICE -> room.price.toString().contains(data)
                SortField.ROOM_NUMBER -> room.roomNumber.contains(data)
                else -> {
                    true
                }
            }
        }.toMutableList())
    }
    fun searchService(searchField: SortField, data : String){
        printList(listService.customFilter { service: Service ->
            when(searchField){
                SortField.ID -> service.id.toString().contains(data)
                SortField.NAME -> service.name.contains(data)
                SortField.PRICE -> service.price.toString().contains(data)
                else -> {
                    true
                }
            }
        }.toMutableList())
    }
}
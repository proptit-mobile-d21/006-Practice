package controller

import data.AllDataForExam
import model.Booking
import model.Client
import model.Room
import model.Service

class Controller(private val roomManagement: RoomManagement) {
    private lateinit var roomList: MutableList<Room>
    private lateinit var clientList: MutableList<Client>
    private lateinit var serviceList: MutableList<Service>
    private lateinit var bookingList: MutableList<Booking>


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

    fun searchRoom(opt: Int, search: String) : List<Room> {
        when (opt) {
            1 -> {
                return roomList.filter { it.id == search.toInt() }
            }
            2 -> {
                return roomList.filter { it.roomType.toString() == search }
            }
            3 -> {
                return roomList.filter { it.price == search.toLong() }
            }
            4 -> {
                return roomList.filter { it.roomNumber == search }
            }
            else -> {
                return emptyList()
            }
        }
    }

    fun searchClient(opt: Int, search: String) : List<Client> {
        when (opt) {
            1 -> {
                return clientList.filter { it.idCard == search }
            }
            2 -> {
                return clientList.filter { it.name == search }
            }
            3 -> {
                return clientList.filter { it.address == search }
            }
            4 -> {
                return clientList.filter { it.phoneNumber == search }
            }
            5 -> {
                return clientList.filter { it.email == search }
            }
            else -> {
                return emptyList()
            }
        }
    }

    fun searchService(opt: Int, search: String) : List<Service> {
        when (opt) {
            1 -> {
                return serviceList.filter { it.id == search.toInt() }
            }
            2 -> {
                return serviceList.filter { it.name == search }
            }
            3 -> {
                return serviceList.filter { it.price == search.toLong() }
            }
            else -> {
                return emptyList()
            }
        }
    }

    fun addNewClient(name: String, address: String, phoneNumber: String, email: String?, note: String?){
        val idCard = (clientList.size + 1).toString()
        clientList.add(Client(idCard, name, address, phoneNumber, email, note))
    }
}
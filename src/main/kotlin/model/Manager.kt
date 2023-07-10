package model

import data.AllDataForExam
import other.RoomType
import java.util.*

class Manager {
    private val roomList = mutableListOf<Room>()
    private val clientList = mutableListOf<Client>()
    private val serviceList = mutableListOf<Service>()
    private val bookingList = mutableListOf<Booking>()

    private val tempRoomList = mutableListOf<Room>()
    private val tempClientList = mutableListOf<Client>()
    private val tempServiceList = mutableListOf<Service>()
    init {
        roomList.addAll(AllDataForExam.roomList)
        clientList.addAll(AllDataForExam.clientList)
        serviceList.addAll(AllDataForExam.serviceList)
    }

// Dịch vụ 1
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
        val sortedList = roomList.sortedBy { it.id }
        sortedList.forEach { println(it) }
    }
    // Sắp xếp khách hàng
    val showByClientName: () -> Unit = {
        val sortedList = clientList.sortedBy { it.name }
        sortedList.forEach { println(it) }
    }
    val showByClientID: () -> Unit = {
        val sortedList = clientList.sortedBy { it.idCard }
        sortedList.forEach { println(it) }
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
        val sortedList = serviceList.sortedBy { it.id }
        sortedList.forEach { println(it) }
    }

// Dịch vụ 2
    // Tìm kiếm phòng
    val findByRoomID: (Int) -> Unit = {id ->
        roomList.filter { it.id.equals(id) }.forEach{ println(it) }
    }
    // Sửa phòng
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
                    else{
                        tempRoomList.add(it)
                    }
                }
                roomList.clear()
                roomList.addAll(tempRoomList)
            }
            2 -> {
                println("1. SINGLE_ROOM")
                println("2. DOUBLE_ROOM")
                println("3. VIP_ROOM")
                print("Enter New Room Type: ")
                val inputRoomType = readln()!!.toInt()
                roomList.forEachIndexed { index, it ->
                    if(it.id.equals(id)){
                        val newID = it.id
                        var newRoomType = RoomType.SINGLE_ROOM
                        if(inputRoomType == 1){
                            newRoomType = RoomType.SINGLE_ROOM
                        }else if(inputRoomType == 2){
                            newRoomType = RoomType.DOUBLE_ROOM
                        }
                        else if(inputRoomType == 3){
                            newRoomType = RoomType.VIP_ROOM
                        }
                        val newPrice = it.price
                        val newRoomNumber = it.roomNumber
                        val newNote = it.note
                        val newRoom = Room(newID, newRoomType, newPrice, newRoomNumber, newNote)
                        tempRoomList.add(newRoom)
                    }
                    else{
                        tempRoomList.add(it)
                    }
                }
                roomList.clear()
                roomList.addAll(tempRoomList)
            }
            3 -> {
                print("Enter New Price: ")
                val inputPrice = readln()!!.toLong()
                roomList.forEachIndexed { index, it ->
                    if(it.id.equals(id)){
                        val newID = it.id
                        val newRoomType = it.roomType
                        val newPrice = inputPrice
                        val newRoomNumber = it.roomNumber
                        val newNote = it.note
                        val newRoom = Room(newID, newRoomType, newPrice, newRoomNumber, newNote)
                        tempRoomList.add(newRoom)
                    }
                    else{
                        tempRoomList.add(it)
                    }
                }
                roomList.clear()
                roomList.addAll(tempRoomList)
            }
            4 -> {
                print("Enter New Room Number: ")
                val inputRoomNumber = readln()!!
                roomList.forEachIndexed { index, it ->
                    if(it.id.equals(id)){
                        val newID = it.id
                        val newRoomType = it.roomType
                        val newPrice = it.price
                        val newRoomNumber = inputRoomNumber
                        val newNote = it.note
                        val newRoom = Room(newID, newRoomType, newPrice, newRoomNumber, newNote)
                        tempRoomList.add(newRoom)
                    }
                    else{
                        tempRoomList.add(it)
                    }
                }
                roomList.clear()
                roomList.addAll(tempRoomList)
            }
            5 -> {
                print("Enter New Note: ")
                val inputNote = readln()!!
                roomList.forEachIndexed { index, it ->
                    if(it.id.equals(id)){
                        val newID = it.id
                        val newRoomType = it.roomType
                        val newPrice = it.price
                        val newRoomNumber = it.roomNumber
                        val newNote = inputNote
                        val newRoom = Room(newID, newRoomType, newPrice, newRoomNumber, newNote)
                        tempRoomList.add(newRoom)
                    }
                    else{
                        tempRoomList.add(it)
                    }
                }
                roomList.clear()
                roomList.addAll(tempRoomList)
            }
        }
    }
    // Tìm kiếm khách hàng
    val findByClientID: (String) -> Unit = {id ->
        clientList.filter { it.idCard.equals(id) }.forEach{ println(it) }
    }
    // Sửa khách hàng
    fun editClient(num: Int, id:String){
        when(num){
            1 -> {
                print("Enter New ID: ")
                val inputID = readln()!!
                clientList.forEachIndexed { index, it ->
                    if(it.idCard.equals(id)){
                        val newID = inputID
                        val newName = it.name
                        val newAddress = it.address
                        val newPhoneNumber = it.phoneNumber
                        val newEmail = it.email
                        val newNote = it.note
                        val newClient = Client(newID, newName, newAddress, newPhoneNumber, newEmail, newNote)
                        tempClientList.add(newClient)
                    }
                    else{
                        tempClientList.add(it)
                    }
                }
                clientList.clear()
                clientList.addAll(tempClientList)
            }
            2 -> {
                print("Enter New Name: ")
                val inputName = readln()!!
                clientList.forEachIndexed { index, it ->
                    if(it.idCard.equals(id)){
                        val newID = it.idCard
                        val newName = inputName
                        val newAddress = it.address
                        val newPhoneNumber = it.phoneNumber
                        val newEmail = it.email
                        val newNote = it.note
                        val newClient = Client(newID, newName, newAddress, newPhoneNumber, newEmail, newNote)
                        tempClientList.add(newClient)
                    }
                    else{
                        tempClientList.add(it)
                    }
                }
                clientList.clear()
                clientList.addAll(tempClientList)
            }
            3 -> {
                print("Enter New Address: ")
                val inputAddress = readln()!!
                clientList.forEachIndexed { index, it ->
                    if(it.idCard.equals(id)){
                        val newID = it.idCard
                        val newName = it.name
                        val newAddress = inputAddress
                        val newPhoneNumber = it.phoneNumber
                        val newEmail = it.email
                        val newNote = it.note
                        val newClient = Client(newID, newName, newAddress, newPhoneNumber, newEmail, newNote)
                        tempClientList.add(newClient)
                    }
                    else{
                        tempClientList.add(it)
                    }
                }
                clientList.clear()
                clientList.addAll(tempClientList)
            }
            4 -> {
                print("Enter New Phone Number: ")
                val inputPhoneNumber = readln()!!
                clientList.forEachIndexed { index, it ->
                    if(it.idCard.equals(id)){
                        val newID = it.idCard
                        val newName = it.name
                        val newAddress = it.address
                        val newPhoneNumber = inputPhoneNumber
                        val newEmail = it.email
                        val newNote = it.note
                        val newClient = Client(newID, newName, newAddress, newPhoneNumber, newEmail, newNote)
                        tempClientList.add(newClient)
                    }
                    else{
                        tempClientList.add(it)
                    }
                }
                clientList.clear()
                clientList.addAll(tempClientList)
            }
            5 -> {
                print("Enter New Email: ")
                val inputEmail = readln()!!
                clientList.forEachIndexed { index, it ->
                    if(it.idCard.equals(id)){
                        val newID = it.idCard
                        val newName = it.name
                        val newAddress = it.address
                        val newPhoneNumber = it.phoneNumber
                        val newEmail = inputEmail
                        val newNote = it.note
                        val newClient = Client(newID, newName, newAddress, newPhoneNumber, newEmail, newNote)
                        tempClientList.add(newClient)
                    }
                    else{
                        tempClientList.add(it)
                    }
                }
                clientList.clear()
                clientList.addAll(tempClientList)
            }
            6 -> {
                print("Enter New Note: ")
                val inputNote = readln()!!
                clientList.forEachIndexed { index, it ->
                    if(it.idCard.equals(id)){
                        val newID = it.idCard
                        val newName = it.name
                        val newAddress = it.address
                        val newPhoneNumber = it.phoneNumber
                        val newEmail = it.email
                        val newNote = inputNote
                        val newClient = Client(newID, newName, newAddress, newPhoneNumber, newEmail, newNote)
                        tempClientList.add(newClient)
                    }
                    else{
                        tempClientList.add(it)
                    }
                }
                clientList.clear()
                clientList.addAll(tempClientList)
            }
        }
    }
    // Tìm kiếm dịch vụ
    val findByServiceID: (Int) -> Unit = {id ->
        serviceList.filter { it.id.equals(id) }.forEach{ println(it) }
    }
    // Sửa dịch vụ
    fun editService(num: Int, id:Int){
        when(num){
            1 -> {
                print("Enter New ID: ")
                val inputID = readln()!!.toInt()
                serviceList.forEachIndexed { index, it ->
                    if(it.id.equals(id)){
                        val newID = inputID
                        val newName = it.name
                        val newPrice = it.price
                        val newService = Service(newID, newName, newPrice)
                        tempServiceList.add(newService)
                    }
                    else{
                        tempServiceList.add(it)
                    }
                }
                serviceList.clear()
                serviceList.addAll(tempServiceList)
            }
            2 -> {
                print("Enter New Name: ")
                val inputName = readln()!!
                serviceList.forEachIndexed { index, it ->
                    if(it.id.equals(id)){
                        val newID = it.id
                        val newName = inputName
                        val newPrice = it.price
                        val newService = Service(newID, newName, newPrice)
                        tempServiceList.add(newService)
                    }
                    else{
                        tempServiceList.add(it)
                    }
                }
                serviceList.clear()
                serviceList.addAll(tempServiceList)
            }
            3 -> {
                print("Enter New Price: ")
                val inputPrice = readln()!!.toLong()
                serviceList.forEachIndexed { index, it ->
                    if(it.id.equals(id)){
                        val newID = it.id
                        val newName = it.name
                        val newPrice = inputPrice
                        val newService = Service(newID, newName, newPrice)
                        tempServiceList.add(newService)
                    }
                    else{
                        tempServiceList.add(it)
                    }
                }
                serviceList.clear()
                serviceList.addAll(tempServiceList)
            }
        }
    }

// Dịch vụ 3
    // Tìm kiếm tên khách hàng
    val checkByClientName: (String) -> Int = { name ->
        clientList.count { it.name == name }
    }
    val findByClientName: (String) -> Unit = {name ->
        clientList.filter { it.name.equals(name) }.forEach{ println(it) }
    }
    fun checkByServiceID(id: Int, list: MutableList<Service>) {
        serviceList.filter { it.id.equals(id) }
            .forEach { list.add(it) }
    }
    fun addBooking(id: Int,
                   idClient: String,
                   idRoom: Int,
                   listService: MutableList<Service> = mutableListOf(),
                   checkIn: Date?,
                   checkOut: Date?)
    {
        val booking = Booking(id, idClient, idRoom, listService, checkIn, checkOut)
        bookingList.add(booking)
    }
    val showBooking: () -> Unit = {
        bookingList.forEach { println(it) }
    }
}



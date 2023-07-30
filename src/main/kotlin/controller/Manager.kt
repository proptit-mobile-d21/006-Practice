package controller

import data.AllDataForExam
import model.Room
import model.Client
import model.Service
import view.Table

object Manager {
    private var rooms = mutableListOf<Room>()
    private var clients = mutableListOf<Client>()
    private var services = mutableListOf<Service>()
    val roomFields = listOf<Field>(Field.ID, Field.TYPE, Field.PRICE, Field.ROOM_NUMBER, Field.NOTE)
    val clientFields =
        listOf<Field>(Field.ID, Field.NAME, Field.ADDRESS, Field.PHONE_NUMBER, Field.EMAIL, Field.NOTE)
    val serviceFields = listOf<Field>(Field.ID, Field.NAME, Field.PRICE)

    init {
        rooms = AllDataForExam.roomList.toMutableList()
        clients = AllDataForExam.clientList.toMutableList()
        services = AllDataForExam.serviceList.toMutableList()
    }

    enum class Type {
        ROOM, CLIENT, SERVICE
    }

    enum class Field(private val keyword: String) {
        ID("ID"),
        TYPE("Loại phòng"),
        PRICE("Giá"),
        ROOM_NUMBER("Số phòng"),
        NOTE("Ghi chú"),
        NAME("Tên"),
        ADDRESS("Địa chỉ"),
        PHONE_NUMBER("SĐT"),
        EMAIL("Email");

        override fun toString(): String {
            return keyword
        }
    }

    fun printRoomList() {
        val table = Table("Danh sách các phòng", roomFields)
        rooms.forEach {
            table.addRow(
                listOf(
                    it.id,
                    it.roomType,
                    it.price,
                    it.roomNumber,
                    it.note
                )
            )
        }
        table.print()
    }

    fun printClientList() {
        val table = Table("Danh sách các khách", clientFields)
        clients.forEach {
            table.addRow(
                listOf(
                    it.idCard,
                    it.name,
                    it.address,
                    it.phoneNumber,
                    it.email,
                    it.note
                )
            )
        }
        table.print()
    }

    fun printServiceList() {
        val table = Table("Danh sách các dịch vụ", serviceFields)
        services.forEach {
            table.addRow(
                listOf(
                    it.id,
                    it.name,
                    it.price
                )
            )
        }
        table.print()
    }

    private fun <T, R : Comparable<R>> sortList(list: MutableList<T>, selector: (T) -> R?) {
        list.sortBy { selector(it) }
    }

    fun sortRoomList(field: Field) {
        when (field) {
            Field.ID -> sortList(rooms) { it.id }
            Field.TYPE -> sortList(rooms) { it.roomType }
            Field.PRICE -> sortList(rooms) { it.price }
            Field.ROOM_NUMBER -> sortList(rooms) { it.roomNumber }
            Field.NOTE -> sortList(rooms) { it.note }
            else -> {}
        }
    }

    fun sortClientList(field: Field) {
        when (field) {
            Field.ID -> sortList(clients) { it.idCard }
            Field.NAME -> sortList(clients) { it.name }
            Field.ADDRESS -> sortList(clients) { it.address }
            Field.PHONE_NUMBER -> sortList(clients) { it.phoneNumber }
            Field.EMAIL -> sortList(clients) { it.email }
            Field.NOTE -> sortList(clients) { it.note }
            else -> {}
        }
    }

    fun sortServiceList(field: Field) {
        when (field) {
            Field.ID -> sortList(services) { it.id }
            Field.NAME -> sortList(services) { it.name }
            Field.ADDRESS -> sortList(services) { it.price }
            else -> {}
        }
    }
}
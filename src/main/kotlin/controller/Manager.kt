package controller

import data.AllDataForExam
import utils.lcTable.Table

object Manager {
    private val roomList = AllDataForExam.roomList
    private val clientList = AllDataForExam.clientList
    private val serviceList = AllDataForExam.serviceList

    fun getRoomTable() : Table {
        val table = Table(listOf("ID", "Loại phòng", "Giá", "Số phòng", "Note"))
        roomList.forEach { table.addRow(listOf(
            it.id,
            it.roomType,
            it.price,
            it.roomNumber,
            it.note
        )) }
        return table
    }

    fun getClientTable() : Table {
        val table = Table(listOf("ID", "Tên", "Địa chỉ", "SĐT", "Email", "Note"))
        clientList.forEach { table.addRow(listOf(
            it.idCard,
            it.name,
            it.address,
            it.phoneNumber,
            it.email,
            it.note
        )) }
        return table
    }

    fun getServiceTable() : Table {
        val table = Table(listOf("ID", "Tên dịch vụ", "Giá"))
        serviceList.forEach { table.addRow(listOf(
            it.id,
            it.name,
            it.price
        )) }
        return table
    }
}
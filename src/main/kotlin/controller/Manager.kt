package controller

import data.AllDataForExam
import model.Client
import model.Room
import model.Service
import utils.lcTable.ListTable

object Manager {

    val roomList: ListTable<Room> = ListTable(
        AllDataForExam.roomList,
        listOf("ID", "Loại phòng", "Giá", "Số phòng", "Note")
    ) { listOf(it.id, it.roomType, it.price, it.roomNumber, it.note) }

    val clientList: ListTable<Client> = ListTable(
        AllDataForExam.clientList,
        listOf("ID", "Tên", "Địa chỉ", "SĐT", "Email", "Note")
    ) { listOf(it.idCard, it.name, it.address, it.phoneNumber, it.email, it.note) }

    val serviceList: ListTable<Service> = ListTable(
        AllDataForExam.serviceList,
        listOf("ID", "Tên dịch vụ", "Giá")
    ) { listOf(it.id, it.name, it.price) }

}
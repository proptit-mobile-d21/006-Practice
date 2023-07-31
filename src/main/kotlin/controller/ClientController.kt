package controller

import data.AllDataForExam
import utils.lcTable.ListTable

class ClientController {
    val list = ListTable(
        AllDataForExam.clientList,
        listOf("ID", "Tên", "Địa chỉ", "SĐT", "Email", "Note")
    ) { listOf(it.idCard, it.name, it.address, it.phoneNumber, it.email, it.note) }
}
package controller

import data.AllDataForExam
import utils.lcTable.ListTable

class ServiceController {
    val list = ListTable(
        AllDataForExam.serviceList,
        listOf("ID", "Tên dịch vụ", "Giá")
    ) { listOf(it.id, it.name, it.price) }
}
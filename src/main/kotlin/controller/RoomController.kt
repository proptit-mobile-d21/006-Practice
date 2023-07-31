package controller

import data.AllDataForExam
import utils.lcTable.ListTable

class RoomController {
    val list = ListTable(
        AllDataForExam.roomList,
        listOf("ID", "Loại phòng", "Giá", "Số phòng", "Note")
    ) { listOf(it.id, it.roomType, it.price, it.roomNumber, it.note) }
}
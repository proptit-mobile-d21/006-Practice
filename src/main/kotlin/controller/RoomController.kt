package controller

import data.AllDataForExam
import model.Room
import view.Table

object RoomController : IController<Room, RoomController.Field> {
    enum class Field(private val keyword: String) {
        ID("ID"),
        TYPE("Loại phòng"),
        PRICE("Giá"),
        ROOM_NUMBER("Số phòng"),
        NOTE("Ghi chú");

        override fun toString(): String {
            return keyword
        }
    }

    override val listItem: MutableList<Room>
        get() = AllDataForExam.roomList as MutableList<Room>

    override fun sortList(listItem: MutableList<Room>, field: Field) {
        when (field) {
            Field.ID -> listItem.sortBy { it.id }
            Field.TYPE -> listItem.sortBy { it.roomType }
            Field.PRICE -> listItem.sortBy { it.price }
            Field.ROOM_NUMBER -> listItem.sortBy { it.roomNumber }
            Field.NOTE -> listItem.sortBy { it.note }
        }
    }

    override fun printList(listItem: MutableList<Room>) {
        val table =
            Table(
                "Danh sách các khách",
                listOf(Field.ID, Field.TYPE, Field.PRICE, Field.ROOM_NUMBER, Field.NOTE)
            )
        listItem.forEach {
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
}
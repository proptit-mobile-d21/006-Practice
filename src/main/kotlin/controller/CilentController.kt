package controller

import data.AllDataForExam
import model.Client
import model.Room
import view.Table

object ClientController : IController<Client, ClientController.Field> {
    enum class Field(private val keyword: String) {
        ID("ID"),
        NAME("Tên"),
        ADDRESS("Địa chỉ"),
        PHONE_NUMBER("SĐT"),
        EMAIL("Email"),
        NOTE("Ghi chú");

        override fun toString(): String {
            return keyword
        }
    }

    override val listItem: MutableList<Client>
        get() = AllDataForExam.clientList as MutableList<Client>

    override fun sortList(listItem: MutableList<Client>, field: Field) {
        when (field) {
            Field.ID -> listItem.sortBy { it.idCard }
            Field.NAME -> listItem.sortBy { it.name }
            Field.ADDRESS -> listItem.sortBy { it.address }
            Field.PHONE_NUMBER -> listItem.sortBy { it.phoneNumber }
            Field.EMAIL -> listItem.sortBy { it.email }
            Field.NOTE -> listItem.sortBy { it.note }
        }
    }

    override fun printList(listItem: MutableList<Client>) {
        val table =
            Table(
                "Danh sách các khách",
                listOf(Field.ID, Field.NAME, Field.ADDRESS, Field.PHONE_NUMBER, Field.EMAIL, Field.NOTE)
            )
        listItem.forEach {
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
}
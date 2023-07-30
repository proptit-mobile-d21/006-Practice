package controller

import data.AllDataForExam
import model.Room
import model.Service
import view.Table

object ServiceController : IController<Service, ServiceController.Field> {
    enum class Field(private val keyword: String) {
        ID("ID"),
        NAME("Tên"),
        PRICE("Giá");

        override fun toString(): String {
            return keyword
        }
    }

    override val listItem: MutableList<Service>
        get() = AllDataForExam.serviceList as MutableList<Service>

    override fun sortList(listItem: MutableList<Service>, field: Field) {
        when (field) {
            Field.ID -> listItem.sortBy { it.id }
            Field.NAME -> listItem.sortBy { it.name }
            Field.PRICE -> listItem.sortBy { it.price }
        }
    }

    override fun printList(listItem: MutableList<Service>) {
        val table =
            Table(
                "Danh sách các khách",
                listOf(Field.ID, Field.NAME, Field.PRICE)
            )
        listItem.forEach {
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
}
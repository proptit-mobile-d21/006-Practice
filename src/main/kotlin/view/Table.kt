package view

import kotlin.math.max

class Table(private val title: String, private val fields: List<Any?>) {
    private val rows = mutableListOf<List<Any?>>()
    private val widthColumn = mutableListOf<Int>()
    private val defaultWidth = 3

    init {
        rows.add(fields)
        fields.forEach {
            widthColumn.add(it.toString().length + defaultWidth)
        }
    }

    private fun updateWidthColumn(data: List<Any?>) {
        data.forEachIndexed { index, s ->
            widthColumn[index] = max(widthColumn[index], (s?.toString()?.length ?: 0) + defaultWidth)
        }
    }

    fun addRow(data: List<Any?>) {
        rows.add(data)
        updateWidthColumn(data)
    }

    fun print() {
        println("---$title---")
        rows.forEachIndexed { i, _ ->
            rows[i].forEachIndexed { j, s ->
                print("|" + (s?.toString() ?: "") + " ".repeat(widthColumn[j] - (s?.toString()?.length ?: 0)))
            }
            println("|")
            if (i == 0) println("-".repeat(widthColumn.sum() + widthColumn.size + 1))
        }
    }
}
package utils.lcTable

import kotlin.math.max

class Table(val header: Collection<String>) {
    private val rows: MutableList<Collection<Any?>> = mutableListOf()
    private val pads: MutableList<Int> = mutableListOf()

    init {
        header.forEach {
            pads.add(it.length + 3)
        }
    }

    private fun correctPadding(row: Collection<Any?>) {
        row.forEachIndexed { index, any ->  
            pads[index] = max(pads[index], any.toString().length + 3)
        }
    }

    fun addRow(row: Collection<Any?>) {
        rows.add(row)
        correctPadding(row)
    }

    fun print() {
        var maxLength = 0
        header.forEachIndexed { index, s ->
            maxLength += pads[index]
            print(s.padEnd(pads[index]))
        }
        print("\n")
        println("-".repeat(maxLength))
        rows.forEach { row ->
            row.forEachIndexed { index, it ->
                var content = ""
                if (it != null) content = it.toString()
                print(content.padEnd(pads[index]))
            }
            print("\n")
        }
    }
}
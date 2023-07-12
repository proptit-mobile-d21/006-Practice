package utils.lcConsole

import utils.lcTable.ListTable
import utils.lcTable.Table

class TablePicker<T>(
    private val list: ListTable<T>,
    title: String, root: Page,
    private val objectFilter: (T, keyword: String)->Boolean,
    private val callback:(T)->Unit) :
    Page(title, root, root.scanner) {

    private lateinit var table : Table

    var tableFilter: (T)->Boolean = {true}
        set(value) {
            field = value
            table = list.getTable(value)
        }

    init {
        tableFilter = {true}
    }

    override fun content() {
        table.print()
    }

    override fun execute(input: String) {
        Display.back()
        callback.invoke(list.getObject{objectFilter(it, input)})
    }
}
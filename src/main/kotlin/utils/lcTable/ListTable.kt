package utils.lcTable

class ListTable<T>(
    private val list: List<T> = listOf(),
    private val header: Collection<String>,
    val objToRow: (T)->Collection<Any?>) :
    List<T> by list  {
    class NoMatchingResult(msg: String) : Exception(msg)

    fun getTable(filter: (T) -> Boolean = {true}) : Table {
        val table = Table(header)
        forEach { if (filter(it)) table.addRow(objToRow(it)) }
        return table
    }

    fun getObject(filter:(T)->Boolean) : T {
        forEach { if (filter(it)) return it }
        throw NoMatchingResult("Không tìm thấy!")
    }
}
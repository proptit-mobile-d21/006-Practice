package other

interface CRUD<T> {
    fun getAllData(): List<T>
    fun addData()
    fun searchData(): T?
    fun updateData(item: T)
    fun deleteData(item: T)
    fun showAllData()
}
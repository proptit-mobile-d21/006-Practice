package controller

interface Controller<T> {
    val listItem: MutableList<T>
    fun addItem(item: T)
    fun updateItem(item: T)
    fun showItemList(listItem: MutableList<T>)
    fun findItemByProperty(type: Any, value: Any):T?
    fun updateItemByProperty(oldItem: T, type: Any, value: Any)

}
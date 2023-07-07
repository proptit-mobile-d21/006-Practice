package controller


/*
* @author: Vo Huu Tuan
* @since:  07/07/2023 09:26
* @github:  https://github.com/hidenobi
* @update: 
*
* */



interface Controller<T> {
    val listItem: MutableList<T>
    fun addItem(item: T)
    fun updateItem(item: T)
    fun printList(listItem: MutableList<T>)

    fun findItemByProperty(type: Any, value: Any): T?

    fun updateItemByProperty(oldItem: T, type: Any, value: Any)
}
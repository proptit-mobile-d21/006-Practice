package controller

interface IController<T, X> {
    val listItem: MutableList<T>
    fun printList(listItem: MutableList<T>)
    fun sortList(listItem: MutableList<T>, field: X)
}
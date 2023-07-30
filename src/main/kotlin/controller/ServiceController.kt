package controller

import data.AllDataForExam
import model.Service
import other.ServiceProperty
import java.lang.Exception

class ServiceController : Controller<Service> {
    private val notificationService = NotificationController()
    override val listItem: MutableList<Service>
        get() = AllDataForExam.serviceList as MutableList<Service>

    override fun findItemByProperty(type: Any, value: Any): Service? {
        return try {
            when (type as ServiceProperty) {
                ServiceProperty.ID -> listItem.find { it.id == value }
                ServiceProperty.NAME -> listItem.find { it.name == value }
                ServiceProperty.PRICE -> listItem.find { it.price == value }
            }
        } catch (e: Exception) {
            notificationService.onError("Find service")
            null
        }
    }

    override fun updateItemByProperty(oldItem: Service, type: Any, value: Any) {
        val newItem =
            when (type as ServiceProperty) {
                ServiceProperty.ID -> oldItem.copy(id = value as Int)
                ServiceProperty.NAME -> oldItem.copy(name = value as String)
                ServiceProperty.PRICE -> oldItem.copy(price = value as Long)
            }
        updateItem(newItem)
    }

    override fun showItemList(listItem: MutableList<Service>) {
        try {
            listItem.forEach { println(it) }
            notificationService.onSuccess("Show service list")
        } catch (e: Exception) {
            notificationService.onError("Show service list")
        }
    }

    override fun updateItem(item: Service) {
        try {
            val index = listItem.indexOfFirst { it.id == item.id }
            listItem[index] = item
            notificationService.onSuccess("Update service")
        } catch (e: Exception) {
            notificationService.onError("Update service")
        }
    }

    override fun addItem(item: Service) {
        try {
            val isServiceExist = listItem.contains(item)
            if (isServiceExist) {
                listItem.add(item)
                notificationService.onSuccess("Add service")
            } else {
                println("This service has already existed!")
            }
        } catch (e: Exception) {
            notificationService.onError("Add service")
        }
    }

    fun printListItem(){
        showItemList(listItem)
    }

    fun sortByServiceName(){
        val sortList = listItem
        sortList.sortBy { it.name }
        showItemList(sortList)
    }
}
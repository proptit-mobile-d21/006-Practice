package controller

import data.AllDataForExam
import model.Service
import other.ServiceField


/*
* @author: Vo Huu Tuan
* @since:  07/07/2023 11:23
* @github:  https://github.com/hidenobi
* @update: 
*
* */



class ServiceController : Controller<Service> {

    private val notificationService = ControllerNotificationCallback()

    override val listItem: MutableList<Service>
        get() = AllDataForExam.serviceList as MutableList<Service>

    override fun findItemByProperty(type: Any, value: Any): Service? {
        return try {
            when (type as ServiceField) {
                ServiceField.ID -> {
                    listItem.find {
                        it.id == (value as Int)
                    }
                }

                ServiceField.NAME -> {
                    listItem.find {
                        it.name == (value as String)
                    }
                }

                ServiceField.PRICE -> {
                    listItem.find {
                        it.price == (value as Long)
                    }
                }
            }
        } catch (e: Exception) {
            notificationService.onError("find service")
            null
        }
    }

    override fun updateItemByProperty(oldItem: Service, type: Any, value: Any) {
        val newItem = when (type as ServiceField) {
            ServiceField.ID -> {
                oldItem.copy(id = (value as Int))
            }

            ServiceField.NAME -> {
                oldItem.copy(name = (value as String))
            }

            ServiceField.PRICE -> {
                oldItem.copy(price = (value as Long))
            }
        }
        updateItem(newItem)
    }

    override fun printList(listItem: MutableList<Service>) {
        try {
            listItem.forEach {
                println(it)
            }
            notificationService.onSuccess("Print list client")
        } catch (e: Exception) {
            notificationService.onError("Print list client")
        }
    }

    override fun updateItem(item: Service) {
        try {
            val index = listItem.indexOfFirst {
                it.id == item.id
            }
            listItem[index] = item
            notificationService.onSuccess("Update client")

        } catch (e: Exception) {
            notificationService.onError("Update client")
        }
    }

    override fun addItem(item: Service) {
        try {
            val isExits = listItem.find {
                it == item
            } == null
            if (isExits) {
                listItem.add(item)
                notificationService.onSuccess("Add client")
            } else {
                throw Exception()
            }
        } catch (e: Exception) {
            notificationService.onError("Add client")
        }
    }

    fun printListItem() {
        printList(this.listItem)
    }

    fun sortByName() {
        val sortList = listItem
        sortList.sortBy { it.name }
        printList(sortList)
    }
}
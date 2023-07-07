package controller

import data.AllDataForExam
import model.Client
import other.ClientField


/*
* @author: Vo Huu Tuan
* @since:  07/07/2023 09:29
* @github:  https://github.com/hidenobi
* @update: 
*
* */



class ClientController : Controller<Client> {

    private val notificationClient = ControllerNotificationCallback()

    override val listItem: MutableList<Client>
        get() = AllDataForExam.clientList as MutableList<Client>

    override fun findItemByProperty(type: Any, value: Any): Client? {
        return try {
            when (type as ClientField) {
                ClientField.ID_CARD -> {
                    listItem.find {
                        it.idCard == (value as String)
                    }
                }

                ClientField.NAME -> {
                    listItem.find {
                        it.name == (value as String)
                    }
                }

                ClientField.ADDRESS -> {
                    listItem.find {
                        it.address == (value as String)
                    }
                }

                ClientField.PHONE_NUMBER -> {
                    listItem.find {
                        it.phoneNumber == (value as String)
                    }
                }

                ClientField.EMAIL -> {
                    listItem.find {
                        it.email == (value as String)
                    }
                }

                ClientField.NOTE -> {
                    listItem.find {
                        it.note == (value as String)
                    }
                }
            }
        } catch (e: Exception) {
            notificationClient.onError("find client")
            null
        }
    }

    override fun updateItemByProperty(oldItem: Client, type: Any, value: Any) {
        val newItem =
            when (type as ClientField) {
                ClientField.ID_CARD -> oldItem.copy(idCard = (value as String))
                ClientField.NAME -> oldItem.copy(name = (value as String))
                ClientField.ADDRESS -> oldItem.copy(address = (value as String))
                ClientField.PHONE_NUMBER -> oldItem.copy(phoneNumber = (value as String))
                ClientField.EMAIL -> oldItem.copy(email = (value as String))
                ClientField.NOTE -> oldItem.copy(note = (value as String))
            }
        updateItem(newItem)
    }

    override fun addItem(item: Client) {
        try {
            val isExits = listItem.find {
                it == item
            } == null
            if (isExits) {
                listItem.add(item)
                notificationClient.onSuccess("Add client")
            } else {
                throw Exception()
            }
        } catch (e: Exception) {
            notificationClient.onError("Add client")
        }
    }

    override fun updateItem(item: Client) {
        try {
            val index = listItem.indexOfFirst {
                it.idCard == item.idCard
            }
            listItem[index] = item
            notificationClient.onSuccess("Update client")

        } catch (e: Exception) {
            notificationClient.onError("Update client")
        }
    }

    override fun printList(listItem: MutableList<Client>) {
        try {
            listItem.forEach {
                println(it)
            }
            notificationClient.onSuccess("Print list client")
        } catch (e: Exception) {
            notificationClient.onError("Print list client")
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
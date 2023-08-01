package controller

import data.AllDataForExam
import model.Client
import other.ClientProperty
import java.lang.Exception

class ClientController: Controller<Client> {
    private val notificationClient = NotificationController()

    override val listItem: MutableList<Client>
        get() = AllDataForExam.clientList as MutableList<Client>

    override fun findItemByProperty(type: Any, value: Any): Client? {
        return try {
            when(type as ClientProperty){
                ClientProperty.ID_CARD ->{
                    listItem.find {
                        it.idCard == value
                    }
                }
                ClientProperty.NAME -> {
                    listItem.find {
                        it.name == value
                    }
                }
                ClientProperty.ADDRESS -> {
                    listItem.find {
                        it.address == value
                    }
                }
                ClientProperty.PHONE_NUMBER -> {
                    listItem.find {
                        it.phoneNumber == value
                    }
                }
                ClientProperty.EMAIL -> {
                    listItem.find {
                        it.email == value
                    }
                }
                ClientProperty.NOTE -> {
                    listItem.find {
                        it.note == value
                    }
                }
            }

        } catch (e: Exception){
            notificationClient.onError("Find client")
            null
        }

    }

    override fun updateItemByProperty(oldItem: Client, type: Any, value: Any) {
        val newItem =
            when(type as ClientProperty){
                ClientProperty.ID_CARD -> oldItem.copy(idCard = value as String)
                ClientProperty.NAME -> oldItem.copy(name = value as String)
                ClientProperty.ADDRESS -> oldItem.copy(address = value as String)
                ClientProperty.PHONE_NUMBER -> oldItem.copy(phoneNumber = value as String)
                ClientProperty.EMAIL -> oldItem.copy(email = value as String)
                ClientProperty.NOTE -> oldItem.copy(note = value as String)
            }
        updateItem(newItem)
    }

    override fun showItemList(listItem: MutableList<Client>) {
        try {
            listItem.forEach {
                println(it)
            }
            notificationClient.onSuccess("Show client list")
        } catch (e: Exception) {
            notificationClient.onError("Show client list")
        }
    }

    override fun updateItem(item: Client) {
        try {
            val index = listItem.indexOfFirst { it.idCard == item.idCard }
            listItem[index] = item
            notificationClient.onSuccess("Update client")
        } catch(e: Exception){
            notificationClient.onError("Update client")
        }
    }

    override fun addItem(item: Client) {
        try{
            val isItemExist = !listItem.contains(item)
            if(isItemExist){
                listItem.add(item)
                notificationClient.onSuccess("Add client")
            } else{
                println("The client has already existed")
            }

        }catch (e:Exception){
            notificationClient.onError("Add client")
        }
    }
    fun printListItem() {
        showItemList(this.listItem)
    }

    fun sortByName() {
        val sortList = listItem
        sortList.sortBy { it.name }
        showItemList(sortList)
    }
}
package controller

import data.AllDataForExam
import model.Room
import other.RoomField
import other.RoomType


/*
* @author: Vo Huu Tuan
* @since:  07/07/2023 11:06
* @github:  https://github.com/hidenobi
* @update: 
*
* */



class RoomController : Controller<Room> {

    private val notificationRoom = ControllerNotificationCallback()

    override val listItem: MutableList<Room>
        get() = AllDataForExam.roomList as MutableList<Room>

    override fun findItemByProperty(type: Any, value: Any): Room? {
        return try {
            when (type as RoomField) {
                RoomField.ID -> {
                    listItem.find {
                        it.id == (value as Int)
                    }
                }

                RoomField.ROOM_TYPE -> {
                    listItem.find {
                        it.roomType == (value as RoomType)
                    }
                }

                RoomField.PRICE -> {
                    listItem.find {
                        it.price == (value as Long)
                    }
                }

                RoomField.ROOM_NUMBER -> {
                    listItem.find {
                        it.roomNumber == (value as String)
                    }
                }

                RoomField.NOTE -> {
                    listItem.find {
                        it.note == (value as String)
                    }
                }
            }
        } catch (e: Exception) {
            notificationRoom.onError("Find room")
            null
        }
    }

    override fun updateItemByProperty(oldItem: Room, type: Any, value: Any) {
        val newItem =
            when (type as RoomField) {
                RoomField.ID -> {
                    oldItem.copy(id = (value as Int))
                }

                RoomField.ROOM_TYPE -> {
                    oldItem.copy(roomType = (value as RoomType))
                }

                RoomField.PRICE -> {
                    oldItem.copy(price = value as Long)
                }

                RoomField.ROOM_NUMBER -> {
                    oldItem.copy(roomNumber = (value as String))
                }

                RoomField.NOTE -> {
                    oldItem.copy(note = (value as String))
                }
            }
        updateItem(newItem)
    }

    override fun printList(listItem: MutableList<Room>) {
        try {
            listItem.forEach {
                println(it)
            }
            notificationRoom.onSuccess("Print list room")
        } catch (e: Exception) {
            notificationRoom.onError("Print list room")
        }
    }

    override fun updateItem(item: Room) {
        try {
            val index = listItem.indexOfFirst {
                it.id == item.id
            }
            listItem[index] = item
            notificationRoom.onSuccess("Update room")

        } catch (e: Exception) {
            notificationRoom.onError("Update room")
        }
    }

    override fun addItem(item: Room) {
        try {
            val isExits = listItem.find {
                it == item
            } == null
            if (isExits) {
                listItem.add(item)
                notificationRoom.onSuccess("Add client")
            } else {
                throw Exception()
            }
        } catch (e: Exception) {
            notificationRoom.onError("Add client")
        }
    }

    fun printListItem() {
        printList(this.listItem)
    }

    fun sortByRoomNumber() {
        val sortList = listItem
        sortList.sortBy { it.roomNumber }
        printList(sortList)
    }
}
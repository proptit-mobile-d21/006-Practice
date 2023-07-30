package controller

import data.AllDataForExam
import model.Room
import other.RoomProperty
import other.RoomType
import java.lang.Exception

class RoomController : Controller<Room> {
    private val notificationRoom = NotificationController()
    override val listItem: MutableList<Room>
        get() = AllDataForExam.roomList as MutableList<Room>

    override fun findItemByProperty(type: Any, value: Any): Room? {
        return try {
            when (type as RoomProperty) {
                RoomProperty.ID -> listItem.find { it.id == value }
                RoomProperty.ROOM_TYPE -> listItem.find { it.roomType == value }
                RoomProperty.PRICE -> listItem.find { it.price == value }
                RoomProperty.ROOM_NUMBER -> listItem.find { it.roomNumber == value }
                RoomProperty.NOTE -> listItem.find { it.note == value }
            }

        } catch (e: Exception) {
            notificationRoom.onError("Find room")
            null
        }
    }

    override fun updateItemByProperty(oldItem: Room, type: Any, value: Any) {
        val newItem =
            when(type as RoomProperty){
                RoomProperty.ID -> oldItem.copy(id = value as Int)
                RoomProperty.ROOM_TYPE -> oldItem.copy(roomType = value as RoomType)
                RoomProperty.PRICE -> oldItem.copy(price = value as Long)
                RoomProperty.ROOM_NUMBER -> oldItem.copy(roomNumber = value as String)
                RoomProperty.NOTE -> oldItem.copy(note = value as String)
            }
        updateItem(newItem)
    }

    override fun showItemList(listItem: MutableList<Room>) {
        try {
            listItem.forEach{println(it)}
            notificationRoom.onSuccess("Show room list")
        }catch (e:Exception){
            notificationRoom.onError("Show room list")
        }
    }

    override fun updateItem(item: Room) {
        try{
            val index = listItem.indexOfFirst { it.id == item.id }
            listItem[index] = item
            notificationRoom.onSuccess("Update room")
        } catch (e: Exception){
            notificationRoom.onError("Update room")
        }
    }

    override fun addItem(item: Room) {
        try{
            val isRoomExist = !listItem.contains(item)
            if (isRoomExist)
            {
                listItem.add(item)
                notificationRoom.onSuccess("Add room")
            } else{
                println("This room has already existed")
            }
        } catch (e:Exception){
            notificationRoom.onError("Add room")
        }
    }

    fun printListItem(){
        showItemList(listItem)
    }

    fun sortByRoomNumber(){
        val sortList = listItem
        sortList.sortBy { it.roomNumber }
        showItemList(sortList)
    }
}
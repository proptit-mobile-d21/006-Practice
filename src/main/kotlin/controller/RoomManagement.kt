package controller

import model.Room
import model.Booking
import model.Client
import model.Service
import kotlin.reflect.KClass

class RoomManagement {
    fun <T> showList(item: List<T>) : List<T>{
       return item.toList()
    }

    fun <T> initList(list: List<T>) : List<T>{
        return list.toList()
    }
}
package controller

import model.Room
import model.Booking
import model.Client
import model.Service
import kotlin.reflect.KClass

class RoomManagement {
    fun <T> showList(item: MutableList<T>) : List<T>{
       return item.toList()
    }

    fun <T> initList(list: List<T>) : MutableList<T>{
        return list.toMutableList()
    }

}
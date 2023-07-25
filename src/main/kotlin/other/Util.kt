package other

import model.Client
import model.Room
import model.Service

class Util {
    fun <T> displayList(list: List<T>, opt: Int){
        when(opt){
             1 ->{
                 for(it in list as List<Room>){
                     println("ID: ${it.id} --- Room Type: ${it.roomType} --- Price: ${it.price} --- Room Number: ${it.roomNumber}")
                 }
            }
            2 ->{
                for(it in list as List<Client>){
                    println("ID: ${it.idCard} --- Name: ${it.name} --- Address: ${it.address} --- Phone Number: ${it.phoneNumber} --- Email: ${it.email} --- Note: ${it.note}")
                }
            }
            3 ->{
                for(it in list as List<Service>){
                    println("ID: ${it.id} --- Name: ${it.name} --- Price: ${it.price}")
                }
            }
        }
    }
}
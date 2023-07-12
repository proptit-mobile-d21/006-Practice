package model

import data.AllDataForExam
import other.RoomType

class Manager {
    private var roomList = mutableListOf<Room>()
    private var clientList = mutableListOf<Client>()
    private var serviceList = mutableListOf<Service>()
    init{
        roomList = AllDataForExam.roomList.toMutableList()
        clientList = AllDataForExam.clientList.toMutableList()
        serviceList = AllDataForExam.serviceList.toMutableList()
    }
     fun<T> printList(list: MutableList<T>){
        list.forEach { println(it) }
    }

     fun printList(){
         println("a:In danh sach phong")
         println("b:In danh danh khach hang")
         println("c:In danh sach dich vu")
        when(readln()){
            "a"->{
                printList(roomList)
                println("1.Sap xep theo gia phong")
                println("2.Sap xep theo loai phong")
                var sortChoice = readln().toInt()
                when(sortChoice){
                    1 -> {
                        val priceChoice: ()->Unit = {
                            roomList.sortBy { it.id}
                            roomList.forEach{ println(it) }
                        }
                        priceChoice()
                    }
                    2-> {
                        val typeChoice: ()->Unit = {
                            roomList.sortBy { it.roomType}
                            roomList.forEach{ println(it) }
                        }
                        typeChoice()
                    }
                }

            }
            "b"->{
                printList(clientList)
                println("1.Sap xep theo ten KH")
                println("2.Khong sap xep")
                var sortedChoice = readln().toInt()
                when(sortedChoice){
                    1-> {
                        val nameChoice: ()->Unit = {
                            clientList.sortBy { it.name}
                            clientList.forEach{ println(it) }
                        }
                        nameChoice()
                    }
                }
            }
            "c"->{
                printList(serviceList)
                println("1.Sap xep theo gia dich vu")
                println("2.Khong sap xep")
                var sortedChoice = readln().toInt()
                when(sortedChoice){
                    1-> {
                        val priceChoice: ()->Unit = {
                            serviceList.sortBy { it.price}
                            serviceList.forEach{ println(it) }
                        }
                        priceChoice()
                    }
                }
            }
        }
    }
    fun finding(){
        println("a:Tim theo ma phong")
        println("b:Tim theo ma khach hang")
        println("c:Tim theo ma dich vu")
        var choose = readln()
        when(choose){
            "a"-> {
                val idRoom: (Int) -> Unit = {idRoom->
                    roomList.filter { it.id == idRoom }.forEach{ println(it) }
                }
                var id = readln().toInt()
                idRoom(id)
                println("1.Thay doi so phong")
                println("2.Thay doi loai phong")
                println("3.Khong thay doi")
                var change  = readln().toInt()
                val index = roomList.indexOfFirst { it.id == id }
                when(change){
                    1->{
                        val editNum:(String)->Unit ={num->
                            roomList[index].copy(roomNumber = num)
                            println( roomList[index])
                        }
                        var edit = readln()
                        editNum(edit)

                    }
                    2->{
                        val editType: (RoomType)->Unit={type->
                            roomList[index].copy(roomType = type)
                            println( roomList[index])
                        }
                        var edit = readln()
                        editType(RoomType.valueOf(edit))

                    }
                }
            }
            "b"-> {
                val idClient: (String) -> Unit = {idClient->
                    clientList.filter { it.idCard == idClient }.forEach{ println(it) }
                }
                var id = readln()
                idClient(id)
            }
            "c"-> {
                val idService: (Int) -> Unit = {idService->
                   serviceList.filter { it.id == idService }.forEach{ println(it) }
                }
                var id = readln().toInt()
                idService(id)
            }
        }
    }

}
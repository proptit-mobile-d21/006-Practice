package view

import model.Manager
import java.util.*


/*
* @author: Vo Huu Tuan
* @since:  06/07/2023 23:22
* @github:  https://github.com/hidenobi
* @update: 
*
* */



class Menu {
    private val scanner = Scanner(System.`in`)
    private fun printList(){
        println("\t a. Danh sách khách hàng")
        println("\t b. Danh sách phòng")
        println("\t c. Danh sách dịch vụ")
        when(readlnOrNull()) {
            "a" -> {
                Manager.printListClient()
                sortClient()
            }
            "b" -> {
                Manager.printListRoom()
                sortRoom()
            }
            "c" -> {
                Manager.printListService()
                sortService()
            }
            else -> println("Nhập sai")
        }
    }
    private fun sortClient(){
        println("Sắp xếp danh sách theo: \t1.ID\t2.Name\t3.Address\t4.Phone\t5.Email")
        when(readlnOrNull()){
            "1" -> Manager.sortClient(Manager.ClientSort.ID_CARD)
            "2" -> Manager.sortClient(Manager.ClientSort.NAME)
            "3" -> Manager.sortClient(Manager.ClientSort.ADDRESS)
            "4" -> Manager.sortClient(Manager.ClientSort.PHONE_NUMBER)
            "5" -> Manager.sortClient(Manager.ClientSort.EMAIL)
            else -> println("Nhập sai")
        }
        Manager.printListClient()
    }
    private fun sortRoom(){
        println("Sắp xếp danh sách theo: \t1.ID\t2.Room Type\t3.Price\t4.Room Number")
        when(readlnOrNull()){
            "1" -> Manager.sortRoom(Manager.RoomSort.ID)
            "2" -> Manager.sortRoom(Manager.RoomSort.ROOM_TYPE)
            "3" -> Manager.sortRoom(Manager.RoomSort.PRICE)
            "4" -> Manager.sortRoom(Manager.RoomSort.ROOM_NUMBER)
            else -> println("Nhập sai")
        }
    }
    private fun sortService(){
        println("Sắp xếp danh sách theo: \t1.ID\t2.Name\t3.Price")
        when(readlnOrNull()){
            "1" -> Manager.sortService(Manager.ServiceSort.ID)
            "2" -> Manager.sortService(Manager.ServiceSort.NAME)
            "3" -> Manager.sortService(Manager.ServiceSort.PRICE)
            else -> println("Nhập sai")
        }
    }
    fun run() {
        while (true) {
            println("Menu")
            println("1. Danh sách các đối tượng")
            println("2. Tìm kiếm và thay đổi thông tin đối tượng")
            println("3. Đặt phòng")
            when (scanner.nextInt()) {
                1 -> {
                    printList()
                }

                2 -> {
//                    TODO: search and update data
                }

                3 -> {
//                    TODO: booking
                }

                0 -> {
//                    TODO: back to menu
                }

                else -> {
                    return
                }
            }
        }
    }
}
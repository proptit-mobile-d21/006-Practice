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
    private fun choice() : String{
        println("\t a. Danh sách khách hàng")
        println("\t b. Danh sách phòng")
        println("\t c. Danh sách dịch vụ")
        return scanner.next()
    }
    private fun printList(){

        when(choice()){
            "a" -> {
                println("-----Danh sach khach hang-----")
                Manager.printListClient()
                sortClient()
            }
            "b" -> {
                println("-----Danh sach phong-----")
                Manager.printListRoom()
                sortRoom()
            }
            "c" -> {
                println("-----Danh sach dich vu-----")
                Manager.printListService()
                sortService()
            }
            else -> println("Nhập sai")
        }

    }
    private fun sortClient(){
        println("Sắp xếp danh sách theo: \t1.ID\t2.Name\t3.Address\t4.Phone\t5.Email")
        when(readlnOrNull()){
            "1" -> Manager.sortClient(Manager.SortField.ID)
            "2" -> Manager.sortClient(Manager.SortField.NAME)
            "3" -> Manager.sortClient(Manager.SortField.ADDRESS)
            "4" -> Manager.sortClient(Manager.SortField.PHONE_NUMBER)
            "5" -> Manager.sortClient(Manager.SortField.EMAIL)
            else -> println("Nhập sai")
        }
        Manager.printListClient()
    }
    private fun sortRoom(){
        println("Sắp xếp danh sách theo: \t1.ID\t2.Room Type\t3.Price\t4.Room Number")
        when(readlnOrNull()){
            "1" -> Manager.sortRoom(Manager.SortField.ID)
            "2" -> Manager.sortRoom(Manager.SortField.TYPE)
            "3" -> Manager.sortRoom(Manager.SortField.PRICE)
            "4" -> Manager.sortRoom(Manager.SortField.ROOM_NUMBER)
            else -> println("Nhập sai")
        }
        Manager.printListRoom()
    }
    private fun sortService(){
        println("Sắp xếp danh sách theo: \t1.ID\t2.Name\t3.Price")
        when(readlnOrNull()){
            "1" -> Manager.sortService(Manager.SortField.ID)
            "2" -> Manager.sortService(Manager.SortField.NAME)
            "3" -> Manager.sortService(Manager.SortField.PRICE)
            else -> println("Nhập sai")
        }
        Manager.printListService()
    }
    private fun searchAndEdit(){
        when(choice()){
            "a" -> {
                println("-----Danh sach khach hang-----")
                searchClient()
            }
            "b" -> {
                println("-----Danh sach phong-----")
                searchRoom()
            }
            "c" -> {
                println("-----Danh sach dich vu-----")
                searchService()
            }
            else -> {
                println("Nhập sai")

            }
        }
    }
    private fun searchClient(){
        println("Tìm kiếm theo: \t1.ID\t2.Name\t3.Address\t4.Phone\t5.Email")
        val choice = scanner.next()
        println("Nhập dữ liệu cần tìm: ")
        val data = scanner.next()
        when(choice){
            "1" -> Manager.searchClient(Manager.SortField.ID, data)
            "2" -> Manager.searchClient(Manager.SortField.NAME, data)
            "3" -> Manager.searchClient(Manager.SortField.ADDRESS, data)
            "4" -> Manager.searchClient(Manager.SortField.PHONE_NUMBER, data)
            "5" -> Manager.searchClient(Manager.SortField.EMAIL, data)
            else -> println("Nhập sai")
        }

    }
    private fun searchRoom(){
        println("Tìm kiếm theo: \t1.ID\t2.Room Type\t3.Price\t4.Room Number")
        val choice = scanner.next()
        println("Nhập dữ liệu cần tìm: ")
        val data = scanner.next()
        when(choice){
            "1" -> Manager.searchRoom(Manager.SortField.ID, data)
            "2" -> Manager.searchRoom(Manager.SortField.TYPE, data)
            "3" -> Manager.searchRoom(Manager.SortField.PRICE, data)
            "4" -> Manager.searchRoom(Manager.SortField.ROOM_NUMBER, data)
            else -> println("Nhập sai")
        }

    }
    private fun searchService(){
        println("Tìm kiếm theo \t1.ID\t2.Name\t3.Price")
        val choice = scanner.next()
        println("Nhập dữ liệu cần tìm: ")
        val data = scanner.next()
        when(choice){
            "1" -> Manager.searchService(Manager.SortField.ID, data)
            "2" -> Manager.searchService(Manager.SortField.NAME, data)
            "3" -> Manager.searchService(Manager.SortField.PRICE, data)
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
                    searchAndEdit();
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
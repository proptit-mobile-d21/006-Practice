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
        var choice = scanner.next()
        println("Nhập dữ liệu cần tìm: ")
        var data = scanner.next()
        var listID = listOf<String>()
        when(choice){
            "1" -> listID = Manager.searchClient(Manager.SortField.ID, data)
            "2" -> listID = Manager.searchClient(Manager.SortField.NAME, data)
            "3" -> listID = Manager.searchClient(Manager.SortField.ADDRESS, data)
            "4" -> listID = Manager.searchClient(Manager.SortField.PHONE_NUMBER, data)
            "5" -> listID = Manager.searchClient(Manager.SortField.EMAIL, data)
            else -> println("Nhập sai")
        }
        println(listID)
        println("Nhập ID khách hàng cẩn sửa: ")
        val id = scanner.next()
        if(listID.contains(id)){
            println("Nhập thông tin cần sửa: \t1.Name\t2.Address\t3.Phone\t4.Email")
            choice = scanner.next()
            when(choice){
                "1" -> {
                    println("Nhập tên mới: ")
                    data = readlnOrNull()
                    Manager.editClient(id, data, Manager.SortField.NAME)
                }
                "2" -> {
                    println("Nhập địa chỉ mới")
                    data = readlnOrNull()
                    Manager.editClient(id, data, Manager.SortField.ADDRESS)
                }
                "3" -> {
                    println("Nhập điện thoại mới")
                    data = readlnOrNull()
                    Manager.editClient(id, data, Manager.SortField.PHONE_NUMBER)
                }
                "4" -> {
                    println("Nhập email mới")
                    data = readlnOrNull()
                    Manager.editClient(id, data, Manager.SortField.EMAIL)
                }
            }
        }
        else{
            println("Không tìm thấy")
        }
    }

    private fun searchRoom(){
        println("Tìm kiếm theo: \t1.ID\t2.Room Type\t3.Price\t4.Room Number")
        var choice = scanner.next()
        println("Nhập dữ liệu cần tìm: ")
        var data = scanner.next()
        var listID = listOf<Int>()
        when(choice){
            "1" -> listID = Manager.searchRoom(Manager.SortField.ID, data)
            "2" -> listID = Manager.searchRoom(Manager.SortField.TYPE, data)
            "3" -> listID = Manager.searchRoom(Manager.SortField.PRICE, data)
            "4" -> listID = Manager.searchRoom(Manager.SortField.ROOM_NUMBER, data)
            else -> println("Nhập sai")
        }
        println(listID)
        println("Nhập ID room cẩn sửa: ")
        val id = scanner.nextInt()
        if(listID.contains(id)){
            println("Nhập thông tin cần sửa: \t1.Type\t2.Price\t3.Room Number\t4.Note")
            choice = scanner.next()
            when(choice){
                "1" -> {
                    println("Nhập loại phòng:\n" +
                            "\tSINGLE_ROOM,\n" +
                            "\tDOUBLE_ROOM,\n" +
                            "\tVIP_ROOM ")
                    data = readlnOrNull()
                    Manager.editRoom(id, data, Manager.SortField.TYPE)
                }
                "2" -> {
                    println("Nhập giá mới: ")
                    data = readlnOrNull()
                    Manager.editRoom(id, data, Manager.SortField.PRICE)
                }
                "3" -> {
                    println("Nhập số phòng mới")
                    data = readlnOrNull()
                    Manager.editRoom(id, data, Manager.SortField.ROOM_NUMBER)
                }
                "4" -> {
                    println("Nhập ghi chú cho phòng")
                    data = readlnOrNull()
                    Manager.editRoom(id, data, Manager.SortField.NOTE)
                }
            }
        }
        else{
            println("Không tìm thấy")
        }


    }
    private fun searchService(){
        println("Tìm kiếm theo \t1.ID\t2.Name\t3.Price")
        var choice = scanner.next()
        println("Nhập dữ liệu cần tìm: ")
        var data = scanner.next()
        var listID = listOf<Int>()
        when(choice){
            "1" -> listID = Manager.searchService(Manager.SortField.ID, data)
            "2" -> listID = Manager.searchService(Manager.SortField.NAME, data)
            "3" -> listID = Manager.searchService(Manager.SortField.PRICE, data)
            else -> println("Nhập sai")
        }

        println(listID)
        println("Nhập ID service cẩn sửa: ")
        val id = scanner.nextInt()
        if(listID.contains(id)){
            println("Nhập thông tin cần sửa: \t1.Price\t2.Name")
            choice = scanner.next()
            when(choice){
                "1" -> {
                    println("Nhập giá: ")
                    data = readlnOrNull()
                    Manager.editService(id, data, Manager.SortField.PRICE)
                }
                "2" -> {
                    println("Nhập tên mới: ")
                    data = readlnOrNull()
                    Manager.editService(id, data, Manager.SortField.NAME)
                }

            }
        }
        else{
            println("Không tìm thấy")
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
                    searchAndEdit()
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
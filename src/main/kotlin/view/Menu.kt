package view

import exception.NotFoundException
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
        var data = readlnOrNull()
        var listID = listOf<String>()
        when(choice){
            "1" -> listID = data?.let { Manager.searchClient(Manager.SortField.ID, it) } ?: listOf()
            "2" -> listID = data?.let { Manager.searchClient(Manager.SortField.NAME, it) } ?: listOf()
            "3" -> listID = data?.let { Manager.searchClient(Manager.SortField.ADDRESS, it) } ?: listOf()
            "4" -> listID = data?.let { Manager.searchClient(Manager.SortField.PHONE_NUMBER, it) } ?: listOf()
            "5" -> listID = data?.let { Manager.searchClient(Manager.SortField.EMAIL, it) } ?: listOf()
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
                    data?.let { Manager.editClient(id, it, Manager.SortField.NAME) }
                }
                "2" -> {
                    println("Nhập địa chỉ mới")
                    data = readlnOrNull()
                    data?.let { Manager.editClient(id, it, Manager.SortField.ADDRESS) }
                }
                "3" -> {
                    println("Nhập điện thoại mới")
                    data = readlnOrNull()
                    data?.let { Manager.editClient(id, it, Manager.SortField.PHONE_NUMBER) }
                }
                "4" -> {
                    println("Nhập email mới")
                    data = readlnOrNull()
                    data?.let { Manager.editClient(id, it, Manager.SortField.EMAIL) }
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
        var data = readlnOrNull()
        var listID = listOf<Int>()
        when(choice){
            "1" -> listID = data?.let { Manager.searchRoom(Manager.SortField.ID, it) } ?: listOf()
            "2" -> listID = data?.let { Manager.searchRoom(Manager.SortField.TYPE, it) } ?: listOf()
            "3" -> listID = data?.let { Manager.searchRoom(Manager.SortField.PRICE, it) } ?: listOf()
            "4" -> listID = data?.let { Manager.searchRoom(Manager.SortField.ROOM_NUMBER, it) } ?: listOf()
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
                    data?.let { Manager.editRoom(id, it, Manager.SortField.TYPE) }
                }
                "2" -> {
                    println("Nhập giá mới: ")
                    data = readlnOrNull()
                    data?.let { Manager.editRoom(id, it, Manager.SortField.PRICE) }
                }
                "3" -> {
                    println("Nhập số phòng mới")
                    data = readlnOrNull()
                    data?.let { Manager.editRoom(id, it, Manager.SortField.ROOM_NUMBER) }
                }
                "4" -> {
                    println("Nhập ghi chú cho phòng")
                    data = readlnOrNull()
                    data?.let { Manager.editRoom(id, it, Manager.SortField.NOTE) }
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
        var data = readlnOrNull()
        var listID = listOf<Int>()
        when(choice){
            "1" -> listID = data?.let { Manager.searchService(Manager.SortField.ID, it) } ?: listOf()
            "2" -> listID = data?.let { Manager.searchService(Manager.SortField.NAME, it) } ?: listOf()
            "3" -> listID = data?.let { Manager.searchService(Manager.SortField.PRICE, it) } ?: listOf()
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
                    data?.let { Manager.editService(id, it, Manager.SortField.PRICE) }
                }
                "2" -> {
                    println("Nhập tên mới: ")
                    data = readlnOrNull()
                    data?.let { Manager.editService(id, it, Manager.SortField.NAME) }
                }

            }
        }
        else{
            println("Không tìm thấy")
        }

    }

    private fun bookRoom(){

        println("Nhập tên khách hàng: ")
        val nameClient = readlnOrNull()
        println("Danh sách khách hàng: ${nameClient}")
        val listClient = nameClient?.let { Manager.searchClient(Manager.SortField.NAME, it) } ?: listOf()
        if(listClient.isEmpty()){
            println("Không có khách hàng")
            return
        }
        println(listClient)
        println("Nhập ID khách hàng đặt phòng: ")
        val idClient = scanner.next()
        if(listClient.contains(idClient)){
            println("Danh sách phòng")
            Manager.printListRoom()
            println("Nhập ID phòng cần đặt: ")
            try {
                val idRoom = scanner.nextInt()
                println("Danh sách các dịch vụ")
                Manager.printListService()
                println("Nhập ID dịch vụ")
                try {
                    val idService = scanner.next()
                    val listService = Manager.searchServiceOj(Manager.SortField.ID, idService).toMutableList()
                    println("Bạn có muốn đặt phòng (Yes/No)")
                    when(scanner.next()){
                        "Yes" -> Manager.bookRoom(idClient, idRoom, listService)
                        "No" -> {
                            return
                        }
                    }
                }
                catch (_: NotFoundException){
                    println(NotFoundException("Không tìm thấy ID dịch vụ"))
                }
            }
            catch (_ : NotFoundException){
                println(NotFoundException("Không tìm thấy phòng"))
            }



        }
        else{
            println("Không tìm thấy ID")
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
                    bookRoom()
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
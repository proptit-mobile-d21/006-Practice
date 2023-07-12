package view

import controller.Controller
import controller.RoomManagement
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
    private val roomManagement = RoomManagement()
    private val controller = Controller(roomManagement)

    fun run() {
        controller.init()
        while (true) {
            println("Menu")
            println("1. Danh sách các đối tượng")
            println("2. Tìm kiếm và thay đổi thông tin đối tượng")
            println("3. Đặt phòng")
            when (scanner.nextInt()) {
                1 -> {
//                    TODO: print list object
                    println("Danh sách các đối tượng:")
                    println("1. Danh sách phòng")
                    println("2. Danh sách khác hàng")
                    println("3. Danh sách dịch vụ")
                    when(scanner.nextInt()){
                        1 -> {
                            println("In danh sách phòng:")
                            for(it in controller.showRoomList()){
                                println("ID: ${it.id} --- Room Type: ${it.roomType} --- Price: ${it.price} --- Room Number: ${it.roomNumber}")
                            }

                            println("Chọn cách sắp xếp:")
                            println("1. Theo số phòng.")
                            println("2. Theo loại phòng.")
                            println("3. Theo giá phòng.")
                            controller.sortRoomList(scanner.nextInt())

                            for(it in controller.showRoomList()){
                                println("ID: ${it.id} --- Room Type: ${it.roomType} --- Price: ${it.price} --- Room Number: ${it.roomNumber}")
                            }
                        }
                        2 -> {
                            println("In danh sách khách hàng:")
                            for(it in controller.showClientList()){
                                println("ID: ${it.idCard} --- Name: ${it.name} --- Address: ${it.address} --- Phone Number: ${it.phoneNumber} --- Email: ${it.email} --- Note: ${it.note}")
                            }

                            println("Chọn cách sắp xếp khách hàng:")
                            println("1. Theo tên khách hàng.")
                            println("2. Theo ID khách hàng.")
                            println("3. Theo địa chỉ khách hàng.")
                            controller.sortClientList(scanner.nextInt())

                            for(it in controller.showClientList()){
                                println("ID: ${it.idCard} --- Name: ${it.name} --- Address: ${it.address} --- Phone Number: ${it.phoneNumber} --- Email: ${it.email} --- Note: ${it.note}")
                            }
                        }
                        3 -> {
                            println("In danh sách dịch vụ:")
                            for(it in controller.showServiceList()){
                                println("ID: ${it.id} --- Name: ${it.name} --- Price: ${it.price}")
                            }

                            println("Chọn cách sắp xếp dịch vụ:")
                            println("1. Theo tên dịch vụ.")
                            println("2. Theo ID dịch vụ.")
                            println("3. Theo giá dịch vụ.")
                            controller.sortServiceList(scanner.nextInt())
                            for(it in controller.showServiceList()){
                                println("ID: ${it.id} --- Name: ${it.name} --- Price: ${it.price}")
                            }
                        }
                        else -> {
                            return
                        }
                    }

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
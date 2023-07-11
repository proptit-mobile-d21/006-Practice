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
                            println("Danh sách phòng:")
                            for(it in controller.showRoomList()){
                                println("ID: ${it.id} --- Note: ${it.note} --- Price: ${it.price}")
                            }
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
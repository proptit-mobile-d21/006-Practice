package view

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
    fun run() {
        while (true) {
            println("---Menu---")
            println("1. Danh sách các đối tượng")
            println("2. Tìm kiếm và thay đổi thông tin đối tượng")
            println("3. Đặt phòng")
            when (scanner.nextInt()) {
                1 -> {
//                    TODO: print list object
                    printListMenu()
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

    fun printListMenu() {
        println("---Danh sách các đối tượng---")
        println("0. Trở về Menu")
        println("1. Danh sách các phòng")
        println("2. Danh sách các khách hàng")
        println("3. Danh sách dịch vụ")
        when (scanner.nextInt()) {
            1 -> {
                printRoomListMenu()
            }

            2 -> {
            }

            3 -> {
            }

            0 -> {

            }

            else -> {
            }
        }
    }

    fun printRoomListMenu() {
        println("---Danh sách các phòng---")
    }
}
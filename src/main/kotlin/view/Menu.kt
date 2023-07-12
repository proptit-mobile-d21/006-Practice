package view

import data.AllDataForExam
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
    private val manager = Manager()
    fun run() {
        while (true) {
            println("Menu")
            println("1. Danh sách các đối tượng")
            println("2. Tìm kiếm và thay đổi thông tin đối tượng")
            println("3. Đặt phòng")
            when (scanner.nextInt()) {
                1 -> {
//                    TODO: print list object
                    manager.printList()
                }

                2 -> {
//                    TODO: search and update data
                    manager.finding()
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
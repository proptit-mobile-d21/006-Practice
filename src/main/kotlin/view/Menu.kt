package view

import model.Booking
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

    private fun showMenu() {
        println(".______________________________________________.")
        println("|                     Menu                     |")
        println("|1. Danh sách các đối tượng                    |")
        println("|2. Tìm kiếm và thay đổi thông tin đối tượng   |")
        println("|3. Đặt phòng                                  |")
        println("|4. Thoát                                      |")
        println(".______________________________________________.")
        print("Enter your choice: ")
    }

    private fun choice1() {

        // Chọn danh sách muốn in
        println("._______________________________.")
        println("|1. Danh sách phòng             |")
        println("|2. Danh sách khách hàng        |")
        println("|3. Danh sách dịch vụ           |")
        println("|Nhấn phím khác để về menu      |")
        println("._______________________________.")
        print("Enter your choice: ")
        //
        when (scanner.nextInt()) {
            1 -> {
                // Lựa chọn
                println("._______________________________.")
                println("|      Danh sách phòng theo     |")
                println("|1. Mã phòng                    |")
                println("|2. Loại phòng                  |")
                println("|3. Giá phòng                   |")
                println("|4. Số phòng                    |")
                println("|Nhấn phím khác để về menu      |")
                println("._______________________________.")
                print("Enter your choice: ")
                //
                when (scanner.nextInt()) {
                    1 -> {
                        manager.showRoomById()
                    }

                    2 -> {
                        manager.showRoomByType()
                    }

                    3 -> {
                        manager.showRoomByPrice()
                    }

                    4 -> {
                        manager.showRoomByNumber()
                    }

                    else -> return

                }
            }

            2 -> {
                // Lựa chọn
                println("._______________________________.")
                println("|   Danh sách khách hàng theo   |")
                println("|1. Mã khách hàng               |")
                println("|2. Tên khách hàng              |")
                println("|3. Địa chỉ                     |")
                println("|4. Số điện thoại               |")
                println("|Nhấn phím khác để về menu      |")
                println("._______________________________.")
                print("Enter your choice: ")
                when (scanner.nextInt()) {
                    1 -> {
                        manager.showClientById()
                    }

                    2 -> {
                        manager.showClientByName()
                    }

                    3 -> {
                        manager.showClientByAddress()
                    }

                    4 -> {
                        manager.showClientByPhoneNumber()
                    }

                    else -> return
                }
            }

            3 -> {
                println("._______________________________.")
                println("|   Danh sách dịch vụ theo      |")
                println("|1. Mã dịch vụ                  |")
                println("|2. Tên dịch vụ                 |")
                println("|3. Giá dịch vụ                 |")
                println("|Nhấn phím khác để về menu      |")
                println("._______________________________.")
                print("Enter your choice: ")
                when (scanner.nextInt()) {
                    1 -> {
                        manager.showServiceById()
                    }

                    2 -> {
                        manager.showServiceByName()
                    }

                    3 -> {
                        manager.showServiceByPrice()
                    }

                    else -> return
                }
            }

            else -> return
        }

        print("Press any key to continue ")
        scanner.next()
    }

    fun choice2() {

    }

    fun choice3() {

    }


    fun run() {
        while (true) {
            showMenu()
            when (scanner.nextInt()) {
                1 -> {
                    choice1()
                }

                2 -> {
//                    TODO: search and update data
                }

                3 -> {
//                    TODO: booking
                }

                4 -> {
//                    TODO: back to menu
                }

                else -> {
                    return
                }
            }
        }
    }
}
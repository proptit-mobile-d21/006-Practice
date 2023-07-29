package view

import other.ClientList
import other.Function
import other.RoomList
import other.ServiceList
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
    private val roomList = RoomList()
    private val clientList = ClientList()
    private val serviceList = ServiceList()
    fun run() {
        while (true) {
            Function.selectFunction()
            try {
                when (scanner.nextLine().toInt()) {
                    1 -> {
                        Function.selectObject()
                        try {
                            when (scanner.nextLine().toInt()) {
                                1 -> {
                                    roomList.showAllData()
                                }

                                2 -> {
                                    clientList.showAllData()
                                }

                                3 -> {
                                    serviceList.showAllData()
                                }
                            }
                        }catch (e: NumberFormatException) {
                            println("Invalid input! Please enter a valid number.")
                        }
                    }
                    2 -> {
                        Function.selectObject()
                        try {
                            when (scanner.nextLine().toInt()) {
                                1 -> {
                                    roomList.searchData().let { roomList.updateData(it) }
                                }

                                2 -> {
                                    clientList.searchData().let { clientList.updateData(it) }
                                }

                                3 -> {
                                    serviceList.searchData().let { serviceList.updateData(it) }
                                }
                            }
                        }catch (e: NumberFormatException) {
                            println("Invalid input! Please enter a valid number.")
                        }
                    }
                    3 -> {
                        clientList.addData()
                        print("Enter room id : ")
                        roomList.searchData().note = "Unavailable"
                    }
                    0 -> {
                        continue
                    }
                    else -> {
                        return
                    }
                }
            }catch (e: NumberFormatException) {
                    println("Invalid input! Please enter a valid number.")
            }
        }
    }
}
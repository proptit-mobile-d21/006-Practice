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
    fun run() {
        while (true) {
            println("._________________________.")
            println("|           MENU          |")
            println("|1. Show list             |")
            println("|2. Find and edit         |")
            println("|3. Book room             |")
            println("|4. Exit                  |")
            println("._________________________.")
            print("Your choice: ")
            val choiceMenu = readln()!!.toInt()
            val manager = Manager()
            when(choiceMenu){
                1 -> {
                    println("._________________________.")
                    println("|           SHOW          |")
                    println("|1. Show list of rooms    |")
                    println("|2. Show list of clients  |")
                    println("|3. Show list of services |")
                    println("|4. Back to MENU          |")
                    println("._________________________.")
                    print("Your choice: ")
                    val choiceShow = readln()!!.toInt()
                    when(choiceShow){
                        1 -> {
                            println("._________________________.")
                            println("|           SHOW          |")
                            println("|1. Show list by room type|")
                            println("|2. Show list by price    |")
                            println("|3. Show list by room ID  |")
                            println("._________________________.")
                            print("Your choice: ")
                            val choiceShowBy = readln()!!.toInt()
                            when(choiceShowBy){
                                1 -> {
                                    manager.showByRoomType()
                                }
                                2 -> {
                                    manager.showByPrice()
                                }
                                3 -> {
                                    manager.showByRoomID()
                                }
                            }
                        }
                        2 -> {
                            println("._________________________.")
                            println("|           SHOW          |")
                            println("|1. Show list by name     |")
                            println("|2. Show list by ID       |")
                            println("._________________________.")
                            print("Your choice: ")
                            val choiceShowBy = readln()!!.toInt()
                            when(choiceShowBy){
                                1 -> {
                                    manager.showByClientName()
                                }
                                2 -> {
                                    manager.showByClientID()
                                }
                            }
                        }
                        3 -> {
                            println("._________________________.")
                            println("|           SHOW          |")
                            println("|1. Show list by name     |")
                            println("|2. Show list by price    |")
                            println("|3. Show list by ID       |")
                            println("._________________________.")
                            print("Your choice: ")
                            val choiceShowBy = readln()!!.toInt()
                            when(choiceShowBy) {
                                1 -> {
                                    manager.showByServiceName()
                                }

                                2 -> {
                                    manager.showByServicePrice()
                                }

                                3 -> {
                                    manager.showByServiceID()
                                }
                            }
                        }
                        4 -> {
                            continue
                        }
                    }
                }
                2 -> {
                    println("._________________________.")
                    println("|      FIND AND EDIT      |")
                    println("|1. FAE room              |")
                    println("|2. FAE client            |")
                    println("|3. FAE service           |")
                    println("|4. Back to MENU          |")
                    println("._________________________.")
                    print("Your choice: ")
                    val choiceFAE = readln()!!.toInt()
                    when(choiceFAE){
                        1 -> {
                            manager.showByRoomID()
                            print("Enter ID room: ")
                            val id = readln()!!.toInt()
                            manager.findByRoomID(id)
                            println("._________________________.")
                            println("|      FIND AND EDIT      |")
                            println("|1. ID                    |")
                            println("|2. Room Type             |")
                            println("|3. Price                 |")
                            println("|4. Room Number           |")
                            println("|5. Note                  |")
                            println("|0. Back to MENU          |")
                            println("._________________________.")
                            print("Your choice: ")
                            val choiceFAEBy = readln()!!.toInt()
                            when(choiceFAEBy){
                                1 -> {
                                    manager.editRoom(1,id)
                                }
                                2 -> {

                                }
                                3 -> {

                                }
                                4 -> {

                                }
                                5 -> {

                                }
                                0 -> {
                                    continue
                                }
                            }
                        }
                        2 -> {
                            manager.showByClientID()
                        }
                        3 -> {
                            manager.showByServiceID()
                        }
                        4 -> {
                            continue
                        }
                    }
                }
                3 -> {

                }
                4 -> {
                    println("Thank you for using my service <3.")
                    break
                }
            }
        }
    }
}
package view

import model.Manager
import model.Service
import java.text.DateFormat
import java.text.SimpleDateFormat
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
        val manager = Manager()
        val list =  mutableListOf<Service>()
        var count = 1
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
                                    manager.editRoom(2,id)
                                }
                                3 -> {
                                    manager.editRoom(3,id)
                                }
                                4 -> {
                                    manager.editRoom(4,id)
                                }
                                5 -> {
                                    manager.editRoom(5,id)
                                }
                                0 -> {
                                    continue
                                }
                            }
                        }
                        2 -> {
                            manager.showByClientID()
                            print("Enter ID Client: ")
                            val id = readln()!!
                            manager.findByClientID(id)
                            println("._________________________.")
                            println("|      FIND AND EDIT      |")
                            println("|1. ID                    |")
                            println("|2. Name                  |")
                            println("|3. Address               |")
                            println("|4. Phone Number          |")
                            println("|5. Email                 |")
                            println("|6. Note                  |")
                            println("|0. Back to MENU          |")
                            println("._________________________.")
                            print("Your choice: ")
                            val choiceFAEBy = readln()!!.toInt()
                            when(choiceFAEBy){
                                1 -> {
                                    manager.editClient(1,id)
                                }
                                2 -> {
                                    manager.editClient(2,id)
                                }
                                3 -> {
                                    manager.editClient(3,id)
                                }
                                4 -> {
                                    manager.editClient(4,id)
                                }
                                5 -> {
                                    manager.editClient(5,id)
                                }
                                6 -> {
                                    manager.editClient(6,id)
                                }
                                0 -> {
                                    continue
                                }
                            }
                        }
                        3 -> {
                            manager.showByServiceID()
                            print("Enter ID Service: ")
                            val id = readln()!!.toInt()
                            manager.findByServiceID(id)
                            println("._________________________.")
                            println("|      FIND AND EDIT      |")
                            println("|1. ID                    |")
                            println("|2. Name                  |")
                            println("|3. Price                 |")
                            println("|0. Back to MENU          |")
                            println("._________________________.")
                            print("Your choice: ")
                            val choiceFAEBy = readln()!!.toInt()
                            when(choiceFAEBy){
                                1 -> {
                                    manager.editService(1,id)
                                }
                                2 -> {
                                    manager.editService(2,id)
                                }
                                3 -> {
                                    manager.editService(3,id)
                                }
                                0 -> {
                                    continue
                                }
                            }
                        }
                        4 -> {
                            continue
                        }
                    }
                }
                3 -> {
                    print("Enter Name: ")
                    val inputName = readln()!!
                    var inputClientID: String
                    if(manager.checkByClientName(inputName) > 0) {
                        manager.findByClientName(inputName)
                        print("Enter ID of Client: ")
                        inputClientID = readln()!!
                    }else {
                        print("Enter new ID of Client: ")
                        inputClientID = readln()!!
                    }
                    manager.showByRoomID()
                    print("Enter ID of Room: ")
                    val inputRoomID = readln()!!.toInt()

                    manager.showByServiceID()
                    while(true){
                        print("Enter ID of Service (Enter '0' to quit): ")
                        val inputServiceID = readln()!!.toInt()
                        if(inputServiceID.equals(0)) break
                        manager.checkByServiceID(inputServiceID, list)
                    }

                    print("Enter rental start date (dd/MM/yyyy): ")
                    val inputStart = readln()!!
                    print("Enter rental end date (dd/MM/yyyy): ")
                    val inputEnd = readln()!!
                    val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy")
                    var dateStart: Date? = null
                    dateStart = dateFormat.parse(inputStart)
                    var dateEnd: Date? = null
                    dateEnd = dateFormat.parse(inputEnd)

                    manager.addBooking(count, inputClientID, inputRoomID, list ,dateStart, dateEnd)
                    count++
                    manager.showBooking()
                }
                4 -> {
                    println("Thank you for using my service <3.")
                    break
                }
            }
        }
    }
}
package view


/*
* @author: Vo Huu Tuan
* @since:  06/07/2023 23:22
* @github:  https://github.com/hidenobi
* @update: 
*
* */

import model.Manager
import model.TypeOfList
import java.util.*

class Menu {
    private val scanner = Scanner(System.`in`)

    fun printTypeOfList(){
        val types = model.TypeOfList.values()
        println("===Vui long nhap loai danh sach===")
        for(type in types){
            println("%d - %s".format(type.inputCode, type.description))
        }
        print("An 1 - ${types.size} de chon: ")
    }

    fun printTypeOfRoomSort(){
        val types = model.TypeOfRoomSort.values()
        println("===Vui long nhap kieu sap xep===")
        for(type in types){
            println("%d - %s".format(type.inputCode, type.description))
        }
        print("An 1 - ${types.size} de chon: ")
    }

    fun printTypeOfClientSort(){
        val types = model.TypeOfClientSort.values()
        println("===Vui long nhap kieu sap xep===")
        for(type in types){
            println("%d - %s".format(type.inputCode, type.description))
        }
        print("An 1 - ${types.size} de chon: ")
    }

    fun printTypeOfServiceSort(){
        val types = model.TypeOfServiceSort.values()
        println("===Vui long nhap kieu sap xep===")
        for(type in types){
            println("%d - %s".format(type.inputCode, type.description))
        }
        print("An 1 - ${types.size} de chon: ")
    }

    fun printPropertyOfRoom(){
        val types = model.PropertyOfRoom.values()
        println("===Vui long nhap thuoc tinh===")
        for(type in types){
            println("%d - %s".format(type.inputCode, type.description))
        }
        print("An 1 - ${types.size} de chon: ")
    }

    fun printPropertyOfClient(){
        val types = model.PropertyOfClient.values()
        println("===Vui long nhap thuoc tinh===")
        for(type in types){
            println("%d - %s".format(type.inputCode, type.description))
        }
        print("An 1 - ${types.size} de chon: ")
    }

    fun printPropertyOfService(){
        val types = model.PropertyOfService.values()
        println("===Vui long nhap thuoc tinh===")
        for(type in types){
            println("%d - %s".format(type.inputCode, type.description))
        }
        print("An 1 - ${types.size} de chon: ")
    }

    fun run() {
        println("==============Menu==============")
        println("1. Danh sách các đối tượng")
        println("2. Tìm kiếm đối tượng")
        println("3. Thay đổi thông tin đối tượng")
        println("4. Đặt phòng")
        println("================================")
        var choiceMenu = scanner.nextInt() //luu lua chon cua menu
        val choiceList : Int
        when (choiceMenu) {
            1 -> {
//                    TODO: print list object
                printTypeOfList()
                choiceList = scanner.nextInt() // luu loai danh sach
                Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
                val choiceSort : Int
                when(choiceList){
                    1 -> {
                        printTypeOfRoomSort()
                        choiceSort = scanner.nextInt() // luu kieu sort
                        Manager.sortRoomList(choiceSort)
                        Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
                    }

                    2 -> {
                        printTypeOfClientSort()
                        choiceSort = scanner.nextInt()
                        Manager.sortClientList(choiceSort)
                        Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
                    }

                    3 -> {
                        printTypeOfServiceSort()
                        choiceSort = scanner.nextInt()
                        Manager.sortClientList(choiceSort)
                        Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
                    }
                }

            }
            2 -> {
//                    TODO: search data
                printTypeOfList()
                choiceList = scanner.nextInt() // luu loai danh sach
                Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
                val choiceSearch : Int
                when(choiceList){
                    1 -> {
                        println("========Search In Room List==========")
                        printPropertyOfRoom()
                        choiceSearch = scanner.nextInt() // luu property cua room
                        print("-> Nhap noi dung can tim kiem: ")
                        var context = scanner.next()
                        Manager.searchInRoomList(choiceSearch, context)
                    }

                    2 -> {
                        println("========Search In Client List==========")
                        printPropertyOfClient()
                        choiceSearch = scanner.nextInt() // luu property cua client
                        print("-> Nhap noi dung can tim kiem: ")
                        var context = scanner.next()
                        Manager.searchInClientList(choiceSearch, context)
                    }

                    3 -> {
                        println("========Search In Service List==========")
                        printPropertyOfService()
                        choiceSearch = scanner.nextInt() // luu property cua room
                        print("-> Nhap noi dung can tim kiem: ")
                        var context = scanner.next()
                        Manager.searchInServiceList(choiceSearch, context)
                    }
                }
            }
            3 -> {
//                    TODO: update data
                printTypeOfList()
                choiceList = scanner.nextInt() // luu loai danh sach
                Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
                val choiceSearch : Int
                when(choiceList){
                    1 -> {
                        println("========Edit Room List==========")
                        printPropertyOfRoom()
                        choiceSearch = scanner.nextInt() // luu property cua room
                        print("Nhap id room can thay doi : ")
                        var choiceId = scanner.nextInt() // luu id cua room can tim
                        print("-> Nhap noi dung thay doi (Neu khong muon thay doi bam 0 de tro ve menu): ")
                        var context = scanner.next()
                        if(context.equals("0")) {
                            choiceMenu = 0
                        }
                        else{
                            Manager.editRoomListById(choiceSearch, choiceId, context)
                        }
                        Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
                    }

                    2 -> {
                        println("========Edit Client List==========")
                        printPropertyOfClient()
                        choiceSearch = scanner.nextInt() // luu property cua room
                        print("Nhap id client can thay doi : ")
                        var choiceId = scanner.nextInt() // luu id cua room can tim
                        print("-> Nhap noi dung thay doi (Neu khong muon thay doi bam 0 de tro ve menu): ")
                        var context = scanner.next()
                        if(context.equals("0")) {
                            choiceMenu = 0
                        }
                        else{
                            Manager.editClientListById(choiceSearch, choiceId, context)
                        }
                        Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
                    }

                    3 -> {
                        println("========Edit Service List==========")
                        printPropertyOfService()
                        choiceSearch = scanner.nextInt() // luu property cua room
                        print("Nhap id service can thay doi : ")
                        var choiceId = scanner.nextInt() // luu id cua room can tim
                        print("-> Nhap noi dung thay doi (Neu khong muon thay doi bam 0 de tro ve menu): ")
                        var context = scanner.next()
                        if(context.equals("0")) {
                            choiceMenu = 0
                        }
                        else{
                            Manager.editServiceListById(choiceSearch, choiceId, context)
                        }
                        Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
                    }
                }
            }
            4 -> {
//                    TODO: booking
                print("Nhap ten khach hang: ")
                val name = scanner.next()
                if(Manager.searchInClientList(2, name)?.size == 0){
                    println("======Add new client======")
                    print("Nhap dia chi: ")
                    val address = scanner.next()
                    print("Nhap so dien thoai: ")
                    val phoneNumber = scanner.next()
                    print("Nhap email: ")
                    val email = scanner.next()
                    print("Nhap note: ")
                    val note = scanner.next()
                    Manager.addNewClient(name, address, phoneNumber, email, note)
                    println("~~~Successfully!~~~")
                }
                choiceList = 1
                Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
            }

            0 -> {
//                    TODO: back to menu
                println("Menu")
                println("1. Danh sách các đối tượng")
                println("2. Tìm kiếm và thay đổi thông tin đối tượng")
                println("3. Đặt phòng")
                //choiceMenu = scanner.nextInt()
            }

            else -> {
                return
            }
        }
    }
}
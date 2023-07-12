package view


/*
* @author: Vo Huu Tuan
* @since:  06/07/2023 23:22
* @github:  https://github.com/hidenobi
* @update: 
*
* */

import model.Manager
import model.Manager.editClientListById
import model.Manager.editRoomListById
import model.Manager.editServiceListById
import model.Manager.searchInClientList
import model.Manager.searchInRoomList
import model.Manager.searchInServiceList
import model.Manager.sortClientList
import model.Manager.sortRoomList
import model.Manager.sortServiceList
import model.TypeOfList
import java.time.LocalDate
import java.util.*

class Menu {
    private val scanner = Scanner(System.`in`)
    private var choiceMenu : Int = 0
    private var choiceList : Int = 0
    private var choiceSort : Int = 0
    private var choiceSearch : Int = 0

//    fun<T> printEnumValues(types : Array<T>, prompt : String){
//        println("===$prompt===")
//        for(type in types){
//            println("%d - %s".format(type.inputCode, type.description))
//        }
//        print("An 1 - ${types.size} de chon: ")
//    }
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

    fun displayMenu(){
        println("==============Menu==============")
        println("1. Danh sách các đối tượng")
        println("2. Tìm kiếm đối tượng")
        println("3. Thay đổi thông tin đối tượng")
        println("4. Đặt phòng")
        println("================================")
        choiceMenu = scanner.nextInt() //luu lua chon cua menu
    }
    fun displayDataList(callback1 : () -> Unit, callback2: (Int) -> Unit){
        callback1()
        choiceSort = scanner.nextInt() // luu kieu sort
        callback2(choiceSort)
        Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
    }

    fun displayTypeOfList(){
        printTypeOfList()
        choiceList = scanner.nextInt() // luu loai danh sach
        Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
    }

    fun searchInDataList(callback1 : () -> Unit, callback2: (Int, String) -> Unit, typeList : String){
        println("========Search In $typeList List==========")
        callback1()
        choiceSearch = scanner.nextInt() // luu property cua room
        print("-> Nhap noi dung can tim kiem: ")
        val context = scanner.next()
        callback2(choiceSearch, context)
    }

    fun editDataList(callback1 : () -> Unit, callback2: (Int, Int, String) -> Unit, typeList : String){
        println("========Edit $typeList List==========")
        callback1()
        choiceSearch = scanner.nextInt() // luu property cua room
        print("Nhap id room can thay doi : ")
        val choiceId = scanner.nextInt() // luu id cua room can tim
        print("-> Nhap noi dung thay doi (Neu khong muon thay doi bam 0 de tro ve menu): ")
        val context = scanner.next()
        if(context.equals("0")) {
            choiceMenu = 0
        }
        else{
            callback2(choiceSearch, choiceId, context)
        }
        Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
    }

    fun bookingRoom(){
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
        val client = Manager.searchInClientList(2, name)?.first()
        var clientId : String = ""
        if(client != null) clientId = client.idCard

        // Hien thi danh sach phong
        choiceList = 1
        Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
        print("Nhap room id muon chon: ")
        val roomId = scanner.nextInt()

        // Hien thi danh sach dich vu
        choiceList = 3
        Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
        print("So dich vu muon chon: ")
        val serviceNumber = scanner.nextInt()
        val serviceIdList : MutableList<model.Service> = mutableListOf()
        var serviceId : Int = 0
        for(i in 1..serviceNumber){
            print("Nhap service id: ")
            serviceId = scanner.nextInt()
        }

        print("1. Save booking\n")
        print("0. Menu\n")

        print("Nhap lua chon: ")
        val choice = scanner.nextInt()
        if(choice == 1){
            Manager.addNewBooking(clientId, roomId, serviceIdList, LocalDate.now())
        }
        Manager.displayList(4, TypeOfList.values().find{it.inputCode == 4}?.description)
    }

    fun run() {
        displayMenu()
        when (choiceMenu) {
            1 -> {
//                    TODO: print list object
                displayTypeOfList()
                when(choiceList){
                    1 -> {
                        displayDataList(::printTypeOfRoomSort, ::sortRoomList)
                    }

                    2 -> {
                        displayDataList(::printTypeOfClientSort, ::sortClientList)
                    }

                    3 -> {
                        displayDataList(::printTypeOfServiceSort, ::sortServiceList)
                    }
                }

            }
            2 -> {
//                    TODO: search data
                displayTypeOfList()
                when(choiceList){
                    1 -> {
                        searchInDataList(::printPropertyOfRoom, ::searchInRoomList, "Room")
                    }

                    2 -> {
                        searchInDataList(::printPropertyOfClient, ::searchInClientList, "Client")
                    }

                    3 -> {
                        searchInDataList(::printPropertyOfService, ::searchInServiceList, "Service")
                    }
                }
            }
            3 -> {
//                    TODO: update data
                displayTypeOfList()
                when(choiceList){
                    1 -> {
                        editDataList(::printPropertyOfRoom, ::editRoomListById, "Room")
                    }

                    2 -> {
                        editDataList(::printPropertyOfClient, ::editClientListById, "Client")
                    }

                    3 -> {
                        editDataList(::printPropertyOfService, ::editServiceListById, "Service")
                    }
                }
            }
            4 -> {
//                    TODO: booking
                bookingRoom()
            }

            0 -> {
//                    TODO: back to menu
                displayMenu()
            }
            else -> {
                return
            }
        }
    }
}
package view

import model.InvalidSelection
import model.Manager
import model.TypeOfList
import java.time.LocalDate
import java.util.*

object ViewManager {
    val scanner = Scanner(System.`in`).useDelimiter("\\R")
    internal var choiceMenu : Int = 0 // chon chuc nang trong menu
    internal var choiceList : Int = 0 // chon list
    internal var choiceSort : Int = 0 // chon kieu sap xep
    internal var choiceSearch : Int = 0 // chon thuoc tinh can tim kiem

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
        print("An 0 - ${types.size} de chon: ")
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
        print("An 1 -> 4 de chon: ")
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

        if(choiceList < 0 || choiceList > TypeOfList.values().size){
            throw InvalidSelection("Error choice")
        }
        else if(choiceList == 0){
            choiceMenu = 0
        }
        else{
            Manager.displayList(choiceList, TypeOfList.values().find{it.inputCode == choiceList}?.description)
        }

    }

    fun searchInDataList(callback1 : () -> Unit, callback2: (Int, String) -> Unit, typeList : String){
        println("========Search In $typeList List==========")
        callback1()
        choiceSearch = scanner.nextInt() // luu property cua room
        print("-> Nhap noi dung can tim kiem: ")
        val context = scanner.next()
        callback2(choiceSearch, context)
    }

    fun<T> editDataList(callback1 : () -> Unit, callback2: (Int, T, String) -> Unit, typeList : String){
        println("========Edit $typeList List==========")
        callback1()
        choiceSearch = scanner.nextInt() // luu property cua room
        print("Nhap id ${typeList.lowercase()} can thay doi : ")
        val choiceId = scanner.next().uppercase() as T// luu id cua room can tim
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
}
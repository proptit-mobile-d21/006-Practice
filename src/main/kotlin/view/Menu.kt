package view

import controller.ClientController
import controller.RoomController
import controller.ServiceController
import model.Client
import model.Room
import model.Service
import other.ClientProperty
import other.RoomProperty
import other.ServiceProperty
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
    private val clientController = ClientController()
    private val roomController = RoomController()
    private val serviceController = ServiceController()
    fun run() {
        while (true) {
            showMenu()
            when (scanner.nextInt()) {
                1 -> {
                    showTypeOption()
                    val choice = showList()
                    println("=== Hiển thị danh sách đã được sắp xếp ===")
                    if(choice!=0){
                        showSortOption(choice)
                        val sortChoice = scanner.nextInt()
                        if(sortChoice!=0) showSortedList(choice, sortChoice)
                    }

                }

                2 -> {
                    showTypeOption()
                    val choice = showList()
                    println("=== Hãy chọn thuộc tính tìm kiếm ===")
                    if(choice!=0)
                    {
                        showSearchOption(choice)
                        val searchOption = scanner.nextInt()
                        println("Nhập thông tin tìm kiếm")
                        scanner.nextLine()
                        val valueSearch = scanner.nextLine()
                        val findItem = searchByProperty(choice, searchOption, valueSearch)
                        if(findItem!=null)
                        {
                            showPropertyChange(choice)
                            val typeProperty = scanner.nextInt()
                            println("Nhập giá trị mới")
                            scanner.nextLine()
                            val newValue = scanner.nextLine()
                            changeByProperty(choice, typeProperty, newValue, findItem)
                        }

                    }
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

    private fun changeByProperty(choice: Int, typeProperty: Int, newValue: String?, findItem: Any) {
        when(choice){
            1->{
                when(typeProperty){
                    1->{
                        newValue?.let {
                            roomController.updateItemByProperty(findItem as Room, RoomProperty.ROOM_NUMBER,
                                it
                            )
                        }
                    }
                }
            }
            2->{
                when(typeProperty){
                    1->{
                        newValue?.let {
                            clientController.updateItemByProperty(findItem as Client, ClientProperty.NAME,
                                it
                            )
                        }
                    }
                }
            }
            3->{
                when(typeProperty){
                    1->{
                        newValue?.let {
                            serviceController.updateItemByProperty(findItem as Service, ServiceProperty.NAME,
                                it
                            )
                        }
                    }
                }
            }
        }

    }

    private fun searchByProperty(choice: Int, searchOption: Int, valueSearch: String?): Any? {
        return when(choice){
            1->{
                when(searchOption)
                {
                    1->{
                        if (valueSearch != null) {
                            roomController.findItemByProperty(RoomProperty.ROOM_NUMBER, valueSearch).also {
                                println("${it?.id} ${it?.roomType} ${it?.price} ${it?.roomNumber} ${it?.note}")

                            }
                            roomController.findItemByProperty(RoomProperty.ROOM_NUMBER, valueSearch)
                        } else {
                            println("Hãy nhập giá trị!")
                        }
                    }
                    else->{
                        null
                    }
                }
            }
            2->{
                when(searchOption)
                {
                    1->{
                        if (valueSearch != null) {
                            clientController.findItemByProperty(ClientProperty.NAME, valueSearch).also {
                                println("${it?.idCard} ${it?.name} ${it?.address} ${it?.phoneNumber} ${it?.email} ${it?.note}")

                            }
                            clientController.findItemByProperty(ClientProperty.NAME, valueSearch)
                        } else {
                            println("Hãy nhập giá trị!")
                        }
                    }
                    else ->{
                        null
                    }
                }
            }
            3->{
                when(searchOption)
                {
                    1->{
                        if(valueSearch!=null){
                            serviceController.findItemByProperty(ServiceProperty.NAME, valueSearch).also {
                                println("${it?.id} ${it?.name} ${it?.price}")

                            }
                            serviceController.findItemByProperty(ServiceProperty.NAME, valueSearch)
                        } else{
                            println("Hãy nhập giá trị!")
                        }
                    }
                    else->{
                        null
                    }
                }
            }
            else ->{
                null
            }
        }
    }


    private fun showMenu() {
        println("========= Menu =========")
        println("1. Hiển thị danh sách các đối tượng")
        println("2. Tìm kiếm và thay đổi thông tin đối tượng")
        println("3. Đặt phòng")
    }

    private fun showTypeOption(){
        println("1. Danh sách phòng")
        println("2. Danh sách khách hàng")
        println("3. Danh sách dịch vụ")
    }

    private fun showList(): Int {
        return when (scanner.nextInt()) {
            1 -> {
                roomController.printListItem()
                1
            }

            2 -> {
                clientController.printListItem()
                2
            }

            3 -> {
                serviceController.printListItem()
                3
            }

            else -> {
                0
            }
        }
    }

    private fun showSortOption(choice: Int) {
        when(choice){
            1 -> {
                println("1. Sắp xếp theo số phòng")
            }

            2 -> {
                println("1. Sắp xếp theo tên")
            }

            3 -> {
                println("1. Sắp xếp theo tên")
            }

            else -> {
                showMenu()
            }
        }
    }

    private fun showSortedList(choice: Int, sortChoice: Int) {
        when(choice){
            1->{
                when(sortChoice){
                    1->{
                        roomController.sortByRoomNumber()
                    }
                }
            }
            2->{
                when(sortChoice){
                    1-> {
                        clientController.sortByName()
                    }
                }
            }
            3->{
                when(sortChoice){
                    1->{
                        serviceController.sortByServiceName()
                    }
                }
            }
        }
    }

    private fun showSearchOption(typeList: Int) {
        when (typeList) {
            1 -> {
                println("1. Tìm theo số phòng")
            }

            2 -> {
                println("1. Tìm theo tên khách hàng")
            }

            3 -> {
                println("1. Tìm theo tên dịch vụ")
            }

            else -> {
                showMenu()
            }
        }
    }

    private fun showPropertyChange(typeList: Int) {
        when (typeList) {
            1 -> {
                println("1. Sửa số phòng")
            }

            2 -> {
                println("1. Sửa tên khách hàng")
            }

            3 -> {
                println("1. Sửa tên dịch vụ")
            }

            else -> {
                showMenu()
            }
        }
    }


}
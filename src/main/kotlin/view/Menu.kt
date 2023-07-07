package view

import controller.ClientController
import controller.RoomController
import controller.ServiceController
import model.Client
import model.Room
import model.Service
import other.ClientField
import other.RoomField
import other.ServiceField
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
            menu()
            when (scanner.nextInt()) {
                1 -> {
                    showTypeList()
                    val typeList = showList()
                    if (typeList != 0) {
                        showTypeSort(typeList)
                        val typeSort = scanner.nextInt()
                        if (typeSort != 0) showListSorted(typeList, typeSort)
                    }

                }

                2 -> {
                    showTypeList()
                    val typeList = showList()
                    if (typeList != 0) {
                        showTypeSearch(typeList)
                        val typeSearch = scanner.nextInt()
                        println("Nhập giá trị tìm kiếm")
                        scanner.nextLine() // tránh nhập null khi vừa nhập số xong
                        val valueSearch = scanner.nextLine()
                        val findItem = searchByProperty(typeList, typeSearch, valueSearch)
                        if (findItem != null) {
                            showPropertyChange(typeList)
                            val typeProperty = scanner.nextInt()
                            println("Nhập giá trị mới")
                            scanner.nextLine() // tránh nhập null khi vừa nhập số xong
                            val newValue = scanner.nextLine()
                            changeByProperty(typeList, typeProperty, newValue, findItem)
                        }
                    }
                }

                3 -> {
//                    TODO: booking
                }

                0 -> {
//                    Back to menu
                }

                else -> {
                    return
                }
            }
        }
    }

    private fun menu() {
        println("Menu")
        println("1. Danh sách các đối tượng")
        println("2. Tìm kiếm và thay đổi thông tin đối tượng")
        println("3. Đặt phòng")
    }

    private fun showTypeList() {
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

    private fun showTypeSort(typeList: Int) {
        when (typeList) {
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
                menu()
            }
        }
    }

    private fun showListSorted(typeList: Int, typeSort: Int) {
        when (typeList) {
            1 -> {
                when (typeSort) {
                    1 -> {
                        roomController.sortByRoomNumber()
                    }
                }
            }

            2 -> {
                when (typeSort) {
                    1 -> {
                        clientController.sortByName()
                    }
                }
            }

            3 -> {
                when (typeSort) {
                    1 -> {
                        serviceController.sortByName()
                    }
                }
            }

        }
    }

    private fun showTypeSearch(typeList: Int) {
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
                menu()
            }
        }
    }

    private fun searchByProperty(typeList: Int, typeSearch: Int, valueSearch: String): Any? {
        return when (typeList) {
            1 -> {
                when (typeSearch) {
                    1 -> {
                        roomController.findItemByProperty(RoomField.ROOM_NUMBER, valueSearch)
                    }

                    else -> null
                }
            }

            2 -> {
                when (typeSearch) {
                    1 -> {
                        clientController.findItemByProperty(ClientField.NAME, valueSearch)

                    }

                    else -> null
                }
            }

            3 -> {
                when (typeSearch) {
                    1 -> {
                        serviceController.findItemByProperty(ServiceField.NAME, valueSearch)

                    }

                    else -> null
                }
            }

            else -> null
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
                menu()
            }
        }
    }

    private fun changeByProperty(typeList: Int, typeChange: Int, newValue: String, findItem: Any) {
        when (typeList) {
            1 -> {
                when (typeChange) {
                    1 -> {
                        roomController.updateItemByProperty(findItem as Room, RoomField.ROOM_NUMBER, newValue)
                    }


                }
            }

            2 -> {
                when (typeChange) {
                    1 -> {
                        clientController.updateItemByProperty(findItem as Client, ClientField.NAME, newValue)

                    }

                }
            }

            3 -> {
                when (typeChange) {
                    1 -> {
                        serviceController.updateItemByProperty(findItem as Service, ServiceField.NAME, newValue)

                    }
                }
            }
        }
    }
}
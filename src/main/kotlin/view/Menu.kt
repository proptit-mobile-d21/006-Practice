package view

import controller.Controller
import controller.RoomManagement
import model.Service
import other.Util
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
    private val roomManagement = RoomManagement()
    private val controller = Controller(roomManagement)
    private val util = Util()

    fun run() {
        controller.init()
        while (true) {
            println("Menu")
            println("1. Danh sách các đối tượng")
            println("2. Tìm kiếm và thay đổi thông tin đối tượng")
            println("3. Đặt phòng")
            when (scanner.nextInt()) {
                1 -> {
//                    TODO: print list object
                    println("Danh sách các đối tượng:")
                    println("1. Danh sách phòng")
                    println("2. Danh sách khác hàng")
                    println("3. Danh sách dịch vụ")
                    when(scanner.nextInt()){
                        1 -> {
                            println("In danh sách phòng:")
                            util.displayList(controller.showRoomList(), 1)

                            println("Chọn cách sắp xếp:")
                            println("1. Theo số phòng.")
                            println("2. Theo loại phòng.")
                            println("3. Theo giá phòng.")
                            controller.sortRoomList(scanner.nextInt())

                            util.displayList(controller.showRoomList(), 1)
                        }
                        2 -> {
                            println("In danh sách khách hàng:")
                            util.displayList(controller.showClientList(), 2)


                            println("Chọn cách sắp xếp khách hàng:")
                            println("1. Theo tên khách hàng.")
                            println("2. Theo ID khách hàng.")
                            println("3. Theo địa chỉ khách hàng.")
                            controller.sortClientList(scanner.nextInt())

                            util.displayList(controller.showClientList(), 2)
                        }
                        3 -> {
                            println("In danh sách dịch vụ:")
                            util.displayList(controller.showServiceList(), 3)

                            println("Chọn cách sắp xếp dịch vụ:")
                            println("1. Theo tên dịch vụ.")
                            println("2. Theo ID dịch vụ.")
                            println("3. Theo giá dịch vụ.")
                            controller.sortServiceList(scanner.nextInt())
                            util.displayList(controller.showServiceList(), 3)
                        }
                        else -> {
                            return
                        }
                    }

                }

                2 -> {
//                    TODO: search and update data
                    println("Chọn loại danh sách:")
                    println("1. Danh sách phòng")
                    println("2. Danh sách khác hàng")
                    println("3. Danh sách dịch vụ")

                    when(scanner.nextInt()) {
                         1 -> {
                            util.displayList(controller.showRoomList(), 1)
                            println("Bạn muốn tìm theo thuộc tính nào?")
                            println("1. ID")
                            println("2. Loại phòng.")
                            println("3. Giá phòng.")
                            println("4. Số phòng.")

                            when(scanner.nextInt()){
                                1 -> {
                                    println("Nhập ID cần tìm:")
                                    util.displayList(controller.searchRoom(1, scanner.next()), 1)
                                }

                                2 -> {
                                    println("Nhập loại phòng cần tìm: (VIP_ROOM | SINGLE_ROOM)")
                                    util.displayList(controller.searchRoom(2, scanner.next()), 1)
                                }

                                3 -> {
                                    println("Nhập giá phòng cần tìm:")
                                    util.displayList(controller.searchRoom(3, scanner.next()), 1)
                                }

                                4 -> {
                                    println("Nhập số phòng cần tìm:")
                                    util.displayList(controller.searchRoom(4, scanner.next()), 1)
                                }
                            }

                        }
                        2 -> {
                            util.displayList(controller.showClientList(), 2)
                            println("Bạn muốn tìm theo thuộc tính nào?")
                            println("1. ID")
                            println("2. Tên.")
                            println("3. Địa chỉ.")
                            println("4. Số điện thoại.")
                            println("5. Email.")

                            when(scanner.nextInt()){
                                1 -> {
                                    println("Nhập ID cần tìm:")
                                    util.displayList(controller.searchClient(1, scanner.next()), 2)
                                }

                                2 -> {
                                    println("Nhập tên cần tìm")
                                    util.displayList(controller.searchClient(2, scanner.next()), 2)
                                }

                                3 -> {
                                    println("Nhập địa chỉ cần tìm:")
                                    util.displayList(controller.searchClient(3, scanner.next()), 2)
                                }

                                4 -> {
                                    println("Nhập số điện thoại cần tìm:")
                                    util.displayList(controller.searchClient(4, scanner.next()), 2)
                                }
                                5 -> {
                                    println("Nhập email cần tìm:")
                                    util.displayList(controller.searchClient(5, scanner.next()), 2)
                                }
                            }
                        }
                        3 -> {
                            util.displayList(controller.showServiceList(), 3)
                            println("Bạn muốn tìm theo thuộc tính nào?")
                            println("1. ID")
                            println("2. Tên.")
                            println("3. Giá.")

                            when(scanner.nextInt()){
                                1 -> {
                                    println("Nhập ID cần tìm:")
                                    util.displayList(controller.searchService(1, scanner.next()), 2)
                                }

                                2 -> {
                                    println("Nhập tên cần tìm")
                                    util.displayList(controller.searchService(2, scanner.next()), 2)
                                }

                                3 -> {
                                    println("Nhập giá cần tìm:")
                                    util.displayList(controller.searchService(3, scanner.next()), 2)
                                }
                            }
                        }
                    }
                }

                3 -> {
//                    TODO: booking
                    println("Nhập tên khách hàng:")
                    val name = scanner.next()
                    val idClient : String
                    if(controller.searchClient(2, name).isEmpty()){
                        println("Nhập địa chỉ khách hàng mới:")
                        scanner.nextLine()
                        val address = scanner.nextLine()
                        println("Nhập số điện thoại:")
                        val phoneNumber = scanner.next()
                        println("Nhập email:")
                        val email = scanner.next()
                        controller.addNewClient(name, address, phoneNumber, email, null)
                        idClient = controller.showClientList().size.toString()
                        util.displayList(controller.searchClient(2, name), 2)

                    }else{
                        util.displayList(controller.searchClient(2, name), 2)
                        println("Nhập id khách hàng:")
                        idClient = scanner.next()
                    }

                    util.displayList(controller.showRoomList(), 1)
                    println("Nhập id phòng bạn muốn book:")
                    val idRoom = scanner.nextInt()

                    util.displayList(controller.showServiceList(), 3)
                    val bookingServices = mutableListOf<Service>()
                    println("Chọn các dịch vụ muốn book: (Bấm 0 để thôi chọn)")
                    while (true){
                        val opt = scanner.nextInt()
                        if (opt == 0) break
                        bookingServices.add(controller.showServiceList().elementAt(opt-1))
                    }
                    controller.addNewBooking(idClient, idRoom, bookingServices)

                    println("Thông tin hoá đơn bạn vừa book:")
                    for(it in controller.showBookingList()){
                        println("ID: ${it.id} --- Room ID: ${it.idRoom}")
                        println("Danh sách dịch vụ: ")
                        util.displayList(it.listService, 3)
                    }

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
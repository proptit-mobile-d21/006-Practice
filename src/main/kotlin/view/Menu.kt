package view


/*
* @author: Vo Huu Tuan
* @since:  06/07/2023 23:22
* @github:  https://github.com/hidenobi
* @update: 
*
* */

import model.Manager.editClientListById
import model.Manager.editRoomListById
import model.Manager.editServiceListById
import model.Manager.searchInClientList
import model.Manager.searchInRoomList
import model.Manager.searchInServiceList
import model.Manager.sortClientList
import model.Manager.sortRoomList
import model.Manager.sortServiceList
import view.ViewManager.bookingRoom
import view.ViewManager.choiceList
import view.ViewManager.choiceMenu
import view.ViewManager.displayDataList
import view.ViewManager.displayMenu
import view.ViewManager.displayTypeOfList
import view.ViewManager.editDataList
import view.ViewManager.printPropertyOfClient
import view.ViewManager.printPropertyOfRoom
import view.ViewManager.printPropertyOfService
import view.ViewManager.printTypeOfClientSort
import view.ViewManager.printTypeOfRoomSort
import view.ViewManager.printTypeOfServiceSort
import view.ViewManager.searchInDataList

class Menu {

    fun run() {
        displayMenu()
        while(true){
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
                    choiceMenu = 0

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
}
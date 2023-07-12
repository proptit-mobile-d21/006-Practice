package view.menu

import controller.Manager
import view.Option

class ListMenu(parent: Menu, title: String) : Menu(parent, title) {
    init {
        addOption(Option("Danh sách các phòng") {
            Manager.printRoomList()
            val sortMenu = SortMenu(this, "Sắp xếp theo",Manager.Type.ROOM, Manager.roomFields)
            sortMenu.print()
        })
        addOption(Option("Danh sách các khách") {
            Manager.printClientList()
            val sortMenu = SortMenu(this, "Sắp xếp theo",Manager.Type.CLIENT, Manager.clientFields)
            sortMenu.print()
        })
        addOption(Option("Danh sách các dịch vụ") {
            Manager.printServiceList()
            val sortMenu = SortMenu(this, "Sắp xếp theo",Manager.Type.SERVICE, Manager.serviceFields)
            sortMenu.print()
        })
    }
}
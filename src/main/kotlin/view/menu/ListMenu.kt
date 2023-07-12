package view.menu

import controller.Manager
import view.Option

class ListMenu(parent: Menu, title: String) : Menu(parent, title) {
    init {
        addOption(Option("Danh sách các phòng") { Manager.printRoomList() })
        addOption(Option("Danh sách các khách") { Manager.printClientList() })
        addOption(Option("Danh sách các dịch vụ") { Manager.printServiceList() })
    }
}
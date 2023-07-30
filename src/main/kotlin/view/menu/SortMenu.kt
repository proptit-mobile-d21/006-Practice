package view.menu

import controller.Manager
import view.Option

class SortMenu(parent: Menu, title: String, type: Manager.Type, fields: List<Manager.Field>) : Menu(parent, title) {
    init {
        fields.forEach {
            addOption(Option(it.toString()) {
                when (type) {
                    Manager.Type.ROOM -> {
                        Manager.sortRoomList(it)
                        Manager.printRoomList()
                    }

                    Manager.Type.CLIENT -> {
                        Manager.sortClientList(it)
                        Manager.printClientList()
                    }

                    Manager.Type.SERVICE -> {
                        Manager.sortServiceList(it)
                        Manager.printServiceList()
                    }

                    else -> {}
                }
            })
        }
    }
}
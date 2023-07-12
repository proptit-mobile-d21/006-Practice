package view

import view.menu.MainMenu

class View {
    fun run() {
        val mainMenu = MainMenu(null, "Menu")
        while (true) {
            mainMenu.print()
        }
    }
}
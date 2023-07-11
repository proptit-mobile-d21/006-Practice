package view

import utils.lcConsole.Display
import view.menu.MainMenu


/*
* @author: Vo Huu Tuan
* @since:  06/07/2023 23:22
* @github:  https://github.com/hidenobi
* @update: 
*
* */



class Menu {

    fun run() {
        Display.init(MainMenu())
        Display.run()
    }
}
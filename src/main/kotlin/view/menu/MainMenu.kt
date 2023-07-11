package view.menu

import utils.lcConsole.Display
import utils.lcConsole.Option
import utils.lcConsole.Menu

class MainMenu(): Menu("Hotel Manager", null, Display.scanner) {
    init {
        val listMenu = ListMenu(this)
        val modifyMenu = ModifyMenu(this)
        val rentMenu = RentMenu(this)
        add(Option("Hiển thị danh sách") {Display.switchTo(listMenu)})
        add(Option("Tìm kiếm và thay đổi thông tin") {Display.switchTo(modifyMenu)})
        add(Option("Đặt phòng") {Display.switchTo(rentMenu)})
    }
}
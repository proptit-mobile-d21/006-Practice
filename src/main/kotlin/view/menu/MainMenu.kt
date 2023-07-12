package view.menu

import utils.lcConsole.Display
import utils.lcConsole.Option
import utils.lcConsole.Menu

class MainMenu : Menu("Hotel Manager", null, Display.scanner) {
    init {
        add(Option("Hiển thị danh sách") { display(ListMenu(this)) })
        add(Option("Tìm kiếm và thay đổi thông tin") { display(ModifyMenu(this)) })
        add(Option("Đặt phòng") { display(RentMenu(this)) })
    }
}
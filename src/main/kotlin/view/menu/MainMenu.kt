package view.menu

import view.Option

class MainMenu(parent: Menu?, title: String) : Menu(parent, title) {
    init {
        val listMenu = ListMenu(this, "Danh sách các đối tượng")
        val searchMenu = SearchMenu(this,"Tìm kiếm và chỉnh sửa")
        val orderMenu = OrderMenu(this,"Đặt phòng")
        addOption(Option(listMenu.title) { listMenu.print() })
        addOption(Option(searchMenu.title) { })
        addOption(Option(searchMenu.title) { })
    }
}
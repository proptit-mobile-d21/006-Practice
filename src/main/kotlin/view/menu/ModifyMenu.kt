package view.menu

import utils.lcConsole.Option
import utils.lcConsole.Menu

class ModifyMenu(root: Menu) : Menu("Tìm kiếm và chỉnh sửa", root, root.scanner) {
    override val description = "Chọn danh sách bạn muốn tìm kiếm/chỉnh sửa"

    init {
        add(Option("Phòng") {})
        add(Option("Khách hàng") {})
        add(Option("Dịch vụ") {})
    }
}

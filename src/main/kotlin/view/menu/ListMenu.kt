package view.menu

import controller.Manager
import utils.lcConsole.Display
import utils.lcConsole.Option
import utils.lcConsole.Menu
import utils.lcConsole.TableViewer

class ListMenu(root: Menu) : Menu("Hiển thị danh sách", root, root.scanner) {
    override val description = "Chọn danh sách bạn muốn hiển thị"

    init {
        add(Option("Phòng") {
            Display.switchTo(TableViewer(
                Manager.getRoomTable(),
                "Danh sách Phòng",
                this,
                scanner
            ))
        })
        add(Option("Khách hàng") {
            Display.switchTo(TableViewer(
                Manager.getClientTable(),
                "Danh sách Khách hàng",
                this,
                scanner
            ))
        })
        add(Option("Dịch vụ") {
            Display.switchTo(TableViewer(
                Manager.getServiceTable(),
                "Danh sách Dịch vụ",
                this,
                scanner
            ))
        })
    }
}
package view.menu

import controller.ClientController
import controller.RoomController
import controller.ServiceController
import model.Room
import utils.lcConsole.Option
import utils.lcConsole.Menu
import utils.lcConsole.TableViewer

class ListMenu(root: Menu) : Menu("Hiển thị danh sách", root, root.scanner) {

    override val description = "Chọn danh sách bạn muốn hiển thị"

    private val clientController = ClientController()
    private val roomController = RoomController()
    private val serviceController = ServiceController()

    init {
        add(Option("Phòng") {
            display(TableViewer(
                roomController.list.getTable(),
                "Danh sách Phòng",
                this,
                scanner
            ))
        })
        add(Option("Khách hàng") {
            display(TableViewer(
                clientController.list.getTable(),
                "Danh sách Khách hàng",
                this,
                scanner
            ))
        })
        add(Option("Dịch vụ") {
            display(TableViewer(
                serviceController.list.getTable(),
                "Danh sách Dịch vụ",
                this,
                scanner
            ))
        })
    }
}
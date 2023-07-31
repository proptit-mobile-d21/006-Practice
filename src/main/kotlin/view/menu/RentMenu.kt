package view.menu

import controller.ClientController
import controller.RoomController
import controller.ServiceController
import model.Client
import model.Room
import model.Service
import utils.lcConsole.*

class RentMenu(root: Menu) : Menu("Đặt phòng", root, root.scanner) {
    override val description: String = "Điền thông tin vào hóa đơn sau"

    private var client: Client? = null
    private var room: Room? = null
    private val listService: MutableList<Service> = mutableListOf()

    private val clientController = ClientController()
    private val roomController = RoomController()
    private val serviceController = ServiceController()

    init {
        add(Option(clientOption()) {inputClient()})
        add(Option(roomOption()) {inputRoom()})
        add(Option(serviceOption()) {inputService()})
    }

    private fun clientOption(): String {
        var clientStr = "Khách hàng: "
        if (client == null) clientStr += "Chưa điền"
        else clientStr += "${client?.name} - ${client?.idCard}"
        return clientStr
    }

    private fun roomOption(): String {
        var roomStr = "Phòng: "
        if (room == null) roomStr += "Chưa điền"
        else roomStr += "${room?.id.toString()} - ${room?.roomType} - ${room?.roomNumber}"
        return roomStr
    }

    private fun serviceOption(): String {
        var serviceStr = "Dịch vụ: "
        if (listService.size == 0) serviceStr += "Không có dịch vụ"
        else listService.forEach {
            serviceStr += "\n   ${it.name}"
        }
        return serviceStr
    }

    private fun inputClient() {
        val clientPicker = TablePicker<Client>(
            clientController.list,
            "Chọn Khách hàng",
            this,
            { client, keyword -> client.idCard.lowercase() == keyword.trim().lowercase() },
            {
                this.client = it
                this.get(1).context = clientOption()
            }
        )
        val clientNameInput = Dialog(this, "Nhập tên khách hàng") { name ->
            clientPicker.tableFilter = {
                it.name.contains(name)
            }
            display(clientPicker)
        }
        display(clientNameInput)
    }

    private fun inputRoom() {
        val roomPicker = TablePicker<Room>(
            roomController.list,
            "Chọn Phòng",
            this,
            { room, keyword -> room.id.toString() == keyword.trim()},
            {
                this.room = it
                this.get(2).context = roomOption()
            }
        )
        Display.switchTo(roomPicker)
    }

    private fun inputService() {
        val servicePicker = TablePicker<Service>(
            serviceController.list,
            "Chọn Dịch vụ",
            this,
            { service, keyword -> service.id.toString() == keyword.trim() },
            {
                this.listService.add(it)
                this.get(3).context = serviceOption()
            }
        )
        Display.switchTo(servicePicker)
    }
}

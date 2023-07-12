package view.menu

import controller.Manager
import model.Client
import model.Room
import model.Service
import utils.lcConsole.*

class RentMenu(root: Menu) : Menu("Đặt phòng", root, root.scanner) {
    private var client: Client? = null
    private var room: Room? = null
    private val listService: MutableList<Service> = mutableListOf()

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
            Manager.clientList,
            "Chọn Khách hàng",
            this,
            { client, keyword -> client.idCard.lowercase() == keyword.trim().lowercase() },
            {
                this.client = it
                this.get(1).context = clientOption()
            }
        )
        val clientNameInput = Dialog(this, "Nhập tên khách hàng") {name ->
            clientPicker.tableFilter = {
                it.name.contains(name)
            }
            Display.switchTo(clientPicker)
        }
        Display.switchTo(clientNameInput)
    }

    private fun inputRoom() {
        val roomPicker = TablePicker<Room>(
            Manager.roomList,
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
            Manager.serviceList,
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

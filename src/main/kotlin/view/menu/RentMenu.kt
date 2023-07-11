package view.menu

import model.Client
import model.Room
import model.Service
import utils.lcConsole.Menu
import utils.lcConsole.Option

class RentMenu(root: Menu) : Menu("Đặt phòng", root, root.scanner) {
    private val client: Client? = null
    private val room: Room? = null
    private val listService: MutableList<Service> = mutableListOf()

    private fun clientOption(): String {
        var clientStr = "Khách hàng: "
        if (client == null) clientStr += "Chưa điền"
        else clientStr += "${client.name} - ${client.idCard}"
        return clientStr
    }

    private fun roomOption(): String {
        var roomStr = "Khách hàng: "
        if (room == null) roomStr += "Chưa điền"
        else roomStr += room.id.toString()
        return roomStr
    }

    private fun serviceOption(): String {
        var serviceStr = "Dịch vụ: "
        if (room == null) serviceStr += "Chưa điền"
        else listService.forEach {
            serviceStr += "\n   ${it.name}"
        }
        return serviceStr
    }

    init {
        add(Option(clientOption()) {})
        add(Option(roomOption()) {})
        add(Option(serviceOption()){})
    }
}

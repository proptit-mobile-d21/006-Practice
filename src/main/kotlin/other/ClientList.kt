package other

import data.AllDataForExam
import model.Client
import java.util.Scanner

class ClientList : CRUD<Client> {
    private val scanner = Scanner(System.`in`)
    private val clients: MutableList<Client> = AllDataForExam.clientList.toMutableList()

    override fun getAllData(): List<Client> {
        return clients
    }
    override fun addData() {
        val idCard = (clients.size + 1 ).toString()
        print("Enter client name: ")
        val name = scanner.nextLine()
        print("Enter address: ")
        val address = scanner.nextLine()
        print("Enter phone number: ")
        val phoneNumber = scanner.nextLine()
        print("Enter email: ")
        val email = scanner.nextLine()
        print("Enter note: ")
        val note = scanner.nextLine()
        val item = Client(idCard, name, address, phoneNumber, email, note)
        clients.add(item)
    }
    override fun searchData(): Client {
        var client : Client? = null
        while(client == null){
            print("Enter phone number : ")
            client = clients.find { it.phoneNumber == scanner.nextLine() }
                if(client == null){
                    println("Can't find this phone number !")
                }
        }
        return client
    }
    override fun updateData(item: Client) {
        print("Enter client name : ")
        item.name = scanner.nextLine()
        print("Enter address : ")
        item.address = scanner.nextLine()
        print("Enter phone number : ")
        item.phoneNumber = scanner.nextLine()
        print("Enter email : ")
        item.email = scanner.nextLine()
        print("Enter note : ")
        item.note  = scanner.nextLine()
    }
    override fun deleteData(item: Client) {
        clients.remove(item)
    }
    override fun showAllData() {
        clients.forEach { element ->
            println(
                "Client ID : " + element.idCard +
                        " Name : " + element.name +
                        " Address : " + element.address +
                        " Phone number : " + element.phoneNumber +
                        " Email : " + element.email +
                        " Note : " + element.note
            )
        }
    }
}
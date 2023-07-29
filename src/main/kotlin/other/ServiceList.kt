package other

import data.AllDataForExam
import model.Service
import java.util.Scanner

class ServiceList : CRUD<Service> {
    private val scanner = Scanner(System.`in`)
    private val services: MutableList<Service> = AllDataForExam.serviceList.toMutableList()

    override fun getAllData(): List<Service> {
        return services
    }
    override fun addData() {
        val id = services.size + 1
        print("Enter service name : ")
        val name = scanner.nextLine()
        print("Enter price : ")
        val price = scanner.nextLine().toLong()
        val item = Service(id, name, price)
        services.add(item)
    }
    override fun searchData(): Service {
        var service : Service? = null
        while(service == null){
            print("Enter service ID :")
            service = services.find { it.id.toString() == scanner.nextLine() }
            if(service == null ){
                println("Invalid ID")
            }
        }
        return service
    }
    override fun updateData(item: Service) {
        print("Enter service name : ")
        item.name = scanner.nextLine()
        print("Enter price : ")
        item.price = scanner.nextLine().toLong()
    }
    override fun deleteData(item: Service) {
        services.remove(item)
    }
    override fun showAllData(){
        services.forEach { element ->
            println(
                "Service ID : " + element.id +
                        " Name : " + element.name +
                        " Price : " + element.price
            )
        }
    }
}
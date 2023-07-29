package other

import data.AllDataForExam
import model.Room
import java.util.Scanner

class RoomList : CRUD<Room> {
    private val scanner = Scanner(System.`in`)
    private val rooms: MutableList<Room> = AllDataForExam.roomList.toMutableList()

    override fun getAllData(): List<Room> {
        return rooms
    }
    override fun addData() {
        val id = rooms.size+1
        println("1. Single Room")
        println("2. Double Room")
        println("3. VIP Room")
        print("Please choose a room type: ")
        var type : RoomType? = null
        while (type == null) {
            when (scanner.nextLine()) {
                "1" -> type = RoomType.SINGLE_ROOM
                "2" -> type = RoomType.DOUBLE_ROOM
                "3" -> type = RoomType.VIP_ROOM
                else -> println("Invalid input. Please enter 1, 2, or 3 to choose room type.")
            }
        }
        print("Enter room number : ")
        val roomNumber = scanner.nextLine()
        print("Enter note : ")
        val note = scanner.nextLine()
        print("Enter price : ")
        val price = scanner.nextLine().toLong()
        val item = Room(id, type , price , roomNumber, note)
        rooms.add(item)
    }
    override fun searchData(): Room {
        var room: Room? = null
        while(room == null){
            print("Enter room ID : ")
            room = rooms.find { it.roomNumber == scanner.nextLine() }
            if(room == null){
                println("Invalid ID")
            }
        }
        return room
    }
    override fun updateData(item: Room) {
        println("1. Single Room")
        println("2. Double Room")
        println("3. VIP Room")
        print("Please choose a room type: ")
        var type : RoomType? = null
        while (type == null) {
            when (scanner.nextLine()) {
                "1" -> type = RoomType.SINGLE_ROOM
                "2" -> type = RoomType.DOUBLE_ROOM
                "3" -> type = RoomType.VIP_ROOM
                else -> println("Invalid input. Please enter 1, 2, or 3 to choose room type.")
            }
        }
        print("Enter room number : ")
        item.roomNumber = scanner.nextLine()
        print("Enter note : ")
        item.note = scanner.nextLine()
        print("Enter price : ")
        item.price = scanner.nextLine().toLong()
    }
    override fun deleteData(item: Room) {
        rooms.remove(item)
    }
    override fun showAllData() {
        rooms.forEach { element ->
            println(
                "Room ID : " + element.id +
                        " Room type : " + element.roomType +
                        " Room number : " + element.roomNumber +
                        " Note : " + element.note +
                        " Price : " + element.price
            )
        }
    }
}
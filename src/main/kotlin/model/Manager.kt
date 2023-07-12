package model

import data.AllDataForExam
import other.RoomType

enum class TypeOfList(val inputCode : Int, val description : String){
    ROOM(1, "Danh sach phong"),
    CLIENT(2, "Danh sách khach hang"),
    SERVICE(3, "Danh sach dich vu")
}

enum class TypeOfRoomSort(val inputCode: Int, val description: String){
    INCREASE_PRICE(1, "Tang dan theo gia phong"),
    DECREASE_PRICE(2, "Giam dan theo gia phong")
}

enum class TypeOfClientSort(val inputCode: Int, val description: String){
    INCREASE_ID(1, "Tang dan theo ID"),
    DECREASE_ID(2, "Giam dan theo ID")
}

enum class TypeOfServiceSort(val inputCode: Int, val description: String){
    INCREASE_PRICE(1, "Tang dan theo gia phong"),
    DECREASE_PRICE(2, "Giam dan theo gia phong")
}

enum class PropertyOfRoom(val inputCode: Int, val description: String){
    ID(1, "ID of room"),
    ROOM_TYPE(2, "Type of room"),
    PRICE(3, "Price of room"),
    ROOM_NUMBER(4, "Number of room"),
    NOTE(5, "Note of room")
}

enum class PropertyOfClient(val inputCode: Int, val description: String){
    ID_CARD(1, "ID card of client"),
    NAME(2, "Name of client"),
    ADDRESS(3, "Address of client"),
    PHONE_NUMBER(4, "Phone number of client"),
    EMAIL(5, "Email of client"),
    NOTE(6, "Note of client")
}

enum class PropertyOfService(val inputCode: Int, val description: String){
    ID(1, "ID of service"),
    NAME(2, "Name of service"),
    PRICE(3, "Price of service"),
}
object Manager {
    private var listOfRoom = mutableListOf<Room>()
    private var listOfClient = mutableListOf<Client>()
    private var listOfService = mutableListOf<Service>()

    init {
        listOfRoom = AllDataForExam.roomList.toMutableList()
        listOfClient = AllDataForExam.clientList.toMutableList()
        listOfService = AllDataForExam.serviceList.toMutableList()
    }

    // DISPLAY
    private fun <T> displaySpecificList(list : MutableList<T>){
        for(e in list){
            println(e)
        }
    }

    fun displayList(choice: Int, description: String?){
        print("==============" + description + "==============\n" )
        when(choice){
            model.TypeOfList.ROOM.inputCode -> {
                displaySpecificList(listOfRoom)
            }
            model.TypeOfList.CLIENT.inputCode -> {
                displaySpecificList(listOfClient)
            }
            model.TypeOfList.SERVICE.inputCode -> {
                displaySpecificList(listOfService)
            }
        }
    }

    // SORT
    fun sortRoomList(choice: Int){
        when(choice){
            model.TypeOfRoomSort.INCREASE_PRICE.inputCode -> {
                listOfRoom.sortBy { it.price }
            }

            model.TypeOfRoomSort.DECREASE_PRICE.inputCode -> {
                listOfRoom.sortByDescending { it.price }
            }
        }
    }

    fun sortClientList(choice: Int){
        when(choice){
            model.TypeOfClientSort.INCREASE_ID.inputCode -> {
                listOfClient.sortBy { it.idCard }
            }

            model.TypeOfClientSort.DECREASE_ID.inputCode -> {
                listOfClient.sortByDescending { it.idCard }
            }
        }
    }

    fun sortServiceList(choice: Int){
        when(choice){
            model.TypeOfServiceSort.INCREASE_PRICE.inputCode -> {
                listOfService.sortBy { it.price }
            }

            model.TypeOfServiceSort.DECREASE_PRICE.inputCode -> {
                listOfService.sortByDescending { it.price }
            }
        }
    }

    // SEARCH
    fun searchInRoomList(choice : Int, searchContext : String){
        var filterRoomList : MutableList<Room> = mutableListOf()
        when(choice){
            PropertyOfRoom.ID.inputCode -> {
                filterRoomList = listOfRoom.filter {
                    it.id.equals(searchContext.toIntOrNull())
                }.toMutableList()
            }

            PropertyOfRoom.ROOM_TYPE.inputCode -> {
                filterRoomList= listOfRoom.filter { it: Room ->
                    it.roomType.toString().equals(searchContext, true)
                }.toMutableList()
            }

            PropertyOfRoom.PRICE.inputCode -> {
                filterRoomList = listOfRoom.filter {
                    it.price.equals(searchContext.toLongOrNull())
                }.toMutableList()
            }

            PropertyOfRoom.ROOM_NUMBER.inputCode -> {
                filterRoomList = listOfRoom.filter {
                    it.roomNumber.equals(searchContext, true)
                }.toMutableList()
            }
            PropertyOfRoom.NOTE.inputCode -> {
                filterRoomList = listOfRoom.filter {
                    it.note?.let {note ->
                        note.equals(searchContext, true)
                    } == true
                }.toMutableList()
            }
        }
        displaySpecificList(filterRoomList)
    }

    fun searchInClientList(choice : Int, searchContext : String) : MutableList<Client>?{
        var filterClientList : MutableList<Client>? = null
        when(choice){
            PropertyOfClient.ID_CARD.inputCode -> {
                filterClientList = listOfClient.filter {
                    it.idCard.equals(searchContext, true)
                }.toMutableList()
            }

            PropertyOfClient.NAME.inputCode -> {
                filterClientList = listOfClient.filter { it ->
                    it.name.equals(searchContext, true)
                }.toMutableList()
            }

            PropertyOfClient.ADDRESS.inputCode -> {
                filterClientList = listOfClient.filter {
                    it.address.equals(searchContext, true)
                }.toMutableList()
            }

            PropertyOfClient.PHONE_NUMBER.inputCode -> {
                filterClientList = listOfClient.filter {
                    it.phoneNumber.equals(searchContext, true)
                }.toMutableList()
            }

            PropertyOfClient.EMAIL.inputCode -> {
                filterClientList = listOfClient.filter {
                    it.email.equals(searchContext, true)
                }.toMutableList()
            }

            PropertyOfClient.NOTE.inputCode -> {
                filterClientList = listOfClient.filter {
                    it.note?.let {note ->
                        note.equals(searchContext, true)
                    } == true
                }.toMutableList()
            }
        }
        if(filterClientList != null) displaySpecificList(filterClientList)
        return filterClientList
    }

    fun searchInServiceList(choice : Int, searchContext : String){
        var filterServiceList : MutableList<Service> = mutableListOf()
        when(choice){
            PropertyOfService.ID.inputCode -> {
                filterServiceList = listOfService.filter {
                    it.id.equals(searchContext.toIntOrNull())
                }.toMutableList()
            }

            PropertyOfService.NAME.inputCode -> {
                filterServiceList= listOfService.filter { it ->
                    it.name.toString().equals(searchContext, true)
                }.toMutableList()
            }

            PropertyOfService.PRICE.inputCode -> {
                filterServiceList = listOfService.filter {
                    it.price.equals(searchContext.toLongOrNull())
                }.toMutableList()
            }

        }
        displaySpecificList(filterServiceList)
    }

    // EDIT
    fun editRoomListById(choice : Int, id : Int, context : String){
        val index = listOfRoom.indexOfFirst{
            it.id.equals(id)
        }

        var filterRoom  = listOfRoom[index]

        when(choice){
            PropertyOfRoom.ID.inputCode -> {
                filterRoom = filterRoom.copy(id = context.toInt())
            }
            PropertyOfRoom.ROOM_TYPE.inputCode -> {
                filterRoom = filterRoom.copy(roomType = RoomType.valueOf(context))
            }

            PropertyOfRoom.PRICE.inputCode -> {
                filterRoom = filterRoom.copy(price = context.toLong())
            }

            PropertyOfRoom.ROOM_NUMBER.inputCode -> {
                filterRoom = filterRoom.copy(roomNumber = context)
            }
            PropertyOfRoom.NOTE.inputCode -> {
                filterRoom = filterRoom.copy(note = context)
            }
        }

        listOfRoom[index] = filterRoom
    }

    fun editClientListById(choice : Int, id : Int, context : String){
        val index = listOfClient.indexOfFirst{
            it.idCard.equals(id)
        }

        var filterClient  = listOfClient[index]

        when(choice){
            PropertyOfClient.ID_CARD.inputCode -> {
                filterClient = filterClient.copy(idCard = context)
            }
            PropertyOfClient.NAME.inputCode -> {
                filterClient = filterClient.copy(name = context)
            }

            PropertyOfClient.ADDRESS.inputCode -> {
                filterClient = filterClient.copy(address = context)
            }

            PropertyOfClient.PHONE_NUMBER.inputCode -> {
                filterClient = filterClient.copy(phoneNumber = context)
            }

            PropertyOfClient.EMAIL.inputCode -> {
                filterClient = filterClient.copy(email = context)
            }

            PropertyOfRoom.NOTE.inputCode -> {
                filterClient = filterClient.copy(note = context)
            }
        }

        listOfClient[index] = filterClient
    }

    fun editServiceListById(choice : Int, id : Int, context : String){
        val index = listOfService.indexOfFirst{
            it.id.equals(id)
        }

        var filterService  = listOfService[index]

        when(choice){
            PropertyOfService.ID.inputCode -> {
                filterService = filterService.copy(id = context.toInt())
            }

            PropertyOfService.NAME.inputCode -> {
                filterService = filterService.copy(name = context)
            }

            PropertyOfService.PRICE.inputCode -> {
                filterService = filterService.copy(price = context.toLong())
            }

        }

        listOfService[index] = filterService
    }

    fun addNewClient(name : String, address : String, phoneNumber: String, email : String?, note : String?){
        val newClient = Client("ID" + (listOfClient.size + 1).toString().padStart(3, '0'), name, address, phoneNumber, email, note)
        listOfClient.add(newClient)
    }
}




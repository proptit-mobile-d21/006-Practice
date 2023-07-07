package data

import model.Client
import model.Room
import model.Service
import other.RoomType


/*
* @author: Vo Huu Tuan
* @since:  06/07/2023 21:10
* @github:  https://github.com/hidenobi
* @update: 
*
* */


// This file is not allowed to be edited
object AllDataForExam {
    val roomList = listOf(
        Room(1, RoomType.SINGLE_ROOM, 1000, "101"),
        Room(2, RoomType.DOUBLE_ROOM, 1500, "201"),
        Room(3, RoomType.VIP_ROOM, 2000, "301"),
        Room(4, RoomType.SINGLE_ROOM, 1200, "102"),
        Room(5, RoomType.DOUBLE_ROOM, 1800, "202"),
        Room(6, RoomType.VIP_ROOM, 2500, "302"),
        Room(7, RoomType.SINGLE_ROOM, 1100, "103"),
        Room(8, RoomType.DOUBLE_ROOM, 1600, "203"),
        Room(9, RoomType.VIP_ROOM, 2200, "303"),
        Room(10, RoomType.SINGLE_ROOM, 1300, "104"),
        Room(11, RoomType.DOUBLE_ROOM, 1700, "204"),
        Room(12, RoomType.VIP_ROOM, 2400, "304"),
        Room(13, RoomType.SINGLE_ROOM, 1050, "105"),
        Room(14, RoomType.DOUBLE_ROOM, 1550, "205"),
        Room(15, RoomType.VIP_ROOM, 2100, "305"),
        Room(16, RoomType.SINGLE_ROOM, 1150, "106"),
        Room(17, RoomType.DOUBLE_ROOM, 1650, "206"),
        Room(18, RoomType.VIP_ROOM, 2300, "306"),
        Room(19, RoomType.SINGLE_ROOM, 1400, "107"),
        Room(20, RoomType.DOUBLE_ROOM, 1900, "207")
    )
    val clientList = listOf(
        Client("ID001", "John Doe", "123 Main St, City", "123456789", "john.doe@example.com", "Note 1"),
        Client("ID002", "Jane Smith", "456 Elm St, Town", "987654321", null, "Note 2"),
        Client("ID003", "Mike Johnson", "789 Oak St, Village", "456789123", "mike.johnson@example.com", null),
        Client("ID004", "Sarah Williams", "321 Maple St, County", "789123456", "sarah.williams@example.com", "Note 4"),
        Client("ID005", "David Brown", "654 Pine St, State", "321654987", null, null),
        Client("ID006", "Emily Davis", "987 Cedar St, Country", "654987321", "emily.davis@example.com", "Note 6"),
        Client("ID007", "James Miller", "234 Birch St, Province", "987321654", "james.miller@example.com", "Note 7"),
        Client("ID008", "Olivia Wilson", "567 Willow St, Kingdom", "321987654", null, "Note 8"),
        Client("ID009", "Daniel Taylor", "890 Spruce St, Empire", "654321987", "daniel.taylor@example.com", null),
        Client("ID010", "Sophia Anderson", "123 Rose St, Republic", "123987456", "sophia@example.com", null),
        Client("ID011", "Jacob Martinez", "456 Sun St, Nation", "987456123", null, null),
        Client("ID012", "Mia Thompson", "789 Moon St, World", "456123987", "mia.thompson@example.com", "Note 12"),
        Client("ID013", "William Garcia", "321 Star St, Galaxy", "789654321", "william.garcia@example.com", "Note 13"),
        Client("ID014", "Ava Robinson", "654 Sky St, Universe", "321456987", null, "Note 14"),
        Client("ID015", "Joseph Clark", "987 Cloud St, Cosmos", "654789123", "joseph.clark@example.com", null),
        Client("ID016", "Abigail Rodriguez", "234 Rain St, Solar System", "987123456", "abigail@example.com", null),
        Client("ID017", "Ethan Lewis", "567 Thunder St, Milky Way", "321789654", null, "Note 17"),
        Client("ID018", "Harper Lee", "890 Lightning St, Andromeda", "654321789", "harper.lee@example.com", null),
        Client("ID019", "Madison Hall", "123 Storm St, Orion", "123654987", "madison.hall@example.com", "Note 19"),
        Client("ID020", "Michael Ward", "456 Blizzard St, Nebula", "987456321", null, "Note 20")
    )

    val serviceList = listOf(
        Service(1, "Service 1", 100),
        Service(2, "Service 2", 200),
        Service(3, "Service 3", 150),
        Service(4, "Service 4", 180),
        Service(5, "Service 5", 250),
        Service(6, "Service 6", 120),
        Service(7, "Service 7", 300),
        Service(8, "Service 8", 160),
        Service(9, "Service 9", 220),
        Service(10, "Service 10", 190),
        Service(11, "Service 11", 130),
        Service(12, "Service 12", 280),
        Service(13, "Service 13", 170),
        Service(14, "Service 14", 240),
        Service(15, "Service 15", 140),
        Service(16, "Service 16", 210),
        Service(17, "Service 17", 270),
        Service(18, "Service 18", 230),
        Service(19, "Service 19", 260),
        Service(20, "Service 20", 150)
    )
}
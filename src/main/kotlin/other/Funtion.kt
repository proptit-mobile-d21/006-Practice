package other

import model.Room

class Function {
    companion object {
        fun selectFunction() {
            println("Menu")
            println("0. Back to menu")
            println("1. Print list of objects")
            println("2. Search and update data")
            println("3. Booking")
        }
        fun selectObject(){
            println("Select object")
            println("0. Back to menu")
            println("1. Room list")
            println("2. Client list")
            println("3. Service list")
        }
    }
}
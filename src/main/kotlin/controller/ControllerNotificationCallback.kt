package controller

import other.NotificationCallback


/*
* @author: Vo Huu Tuan
* @since:  07/07/2023 11:12
* @github:  https://github.com/hidenobi
* @update: 
*
* */



class ControllerNotificationCallback:NotificationCallback {
    override fun onSuccess(message: String) {
        println("$message success")
    }

    override fun onError(message: String) {
        println("$message fail")
    }
}
package controller

import other.Notification

class NotificationController: Notification {
    override fun onSuccess(message: String) {
        println("$message successfully!")
    }

    override fun onError(message: String) {
        println("$message fail!")
    }

}
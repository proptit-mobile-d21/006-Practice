package other

interface Notification {
    fun onSuccess(message:String)
    fun onError(message: String)
}
package utils.lcConsole

open class Dialog(parent: Page, val message: String, val callback: (input: String) -> Unit) :
    Page(parent.title, parent.root, parent.scanner) {

    override fun content() {
        println(message)
    }

    override fun execute(input: String) {
        close()
        callback(input)
    }
}
package utils.lcConsole

import java.util.Scanner

abstract class Page(val title: String, val root: Page?, val scanner: Scanner) {
    companion object {
        var lineMaxLength = 40
    }

    open val inputTitle: String = "Nhập"
    open val description: String = ""

    private var header: String
    private var line: String

    init {
        header = title
        while(header.length < lineMaxLength) {
            header = "-$header-"
        }
        line = "-".repeat(header.length)
    }

    abstract fun content()

    fun run() {
        println(header)
        if (description != "") println(description)
        content()
        println(line)
        print("$inputTitle: ")
        execute(scanner.nextLine())
    }

    abstract fun execute(input: String)

    fun display(page: Page) {
        Display.switchTo(page)
    }

    fun close() {
        Display.back()
    }
}
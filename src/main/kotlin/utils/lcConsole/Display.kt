package utils.lcConsole

import java.util.Scanner

object Display {
    private lateinit var currentPage: Page

    val scanner = Scanner(System.`in`)

    fun init(page: Page) {
        currentPage = page
    }

    fun clear() {
        /*
        NOTE: IntelliJ Console is a console log, which means we can't clear it properly.
        These code below simply print empty line to make it looks "clear"
        */
        repeat(30) { println() }
    }

    fun back() {
        if (currentPage.root != null) {
            currentPage = currentPage.root!!
        }
    }

    fun switchTo(page: Page) {
        currentPage = page
    }

    fun pause() {
        System.`in`.read()
    }

    fun run() {
        while (true) {
            clear()
            try {
                currentPage.run()
            } catch (e: Exception) {
                println("Lỗi không xác định: ${e.message}")
                pause()
            }
        }
    }
}
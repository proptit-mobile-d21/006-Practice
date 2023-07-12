package view.menu

import view.Option
import java.util.*


/*
* @author: Vo Huu Tuan
* @since:  06/07/2023 23:22
* @github:  https://github.com/hidenobi
* @update: 
*
* */



open class Menu(val parent: Menu?, val title: String) {
    private val scanner = Scanner(System.`in`)
    private val options = mutableListOf<Option>()

    fun addOption(option: Option) {
        options.add(option)
    }

    fun print() {
        println("---$title---")
        options.forEachIndexed { index, option ->
            println("${index + 1}. ${option.title}")
        }
        navigate()
    }

    fun navigate() {
        print("Nhập lựa chọn: ")
        val choice = scanner.nextInt()
        when (choice) {
            in 1..options.size -> {
                options[choice - 1].function.invoke()
            }

            else -> {
            }
        }
    }
}
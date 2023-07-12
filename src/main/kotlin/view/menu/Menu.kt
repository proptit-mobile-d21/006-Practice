package view.menu

import controller.IOException
import view.Option
import java.lang.Exception
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
        val input = scanner.nextLine()
        when (val choice = input.toInt()) {
            0 -> {
                parent?.print() ?: throw IOException("Không thể quay lại")
            }

            in 1..options.size -> {
                options[choice - 1].function.invoke()
            }

            else -> {
                throw IOException("Không hợp lệ")
            }
        }
    }
}
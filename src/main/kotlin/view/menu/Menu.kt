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
    private val options =
        mutableListOf<Option>(Option("Quay lại") { parent?.print() ?: throw IOException("Không thể quay lại") })

    fun addOption(option: Option) {
        options.add(option)
    }

    fun print() {
        println("---$title---")
        options.forEachIndexed { index, option ->
            println("${index}. ${option.title}")
        }
        navigate()
    }

    private fun navigate() {
        print("Nhập lựa chọn: ")
        val input = scanner.nextLine()
        when (val choice = input.toInt()) {
            in 0 until options.size -> {
                options[choice].function.invoke()
            }

            else -> {
                throw IOException("Không hợp lệ")
            }
        }
    }
}
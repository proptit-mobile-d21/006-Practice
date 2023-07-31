package utils.lcConsole

import java.util.Scanner

open class Menu(title: String, root: Page?, scanner: Scanner): Page(title, root, scanner) {
    class InvalidSelection(msg: String): Exception(msg)

    private val options: MutableList<Option> = mutableListOf()

    override val inputTitle: String = "Nhập lựa chọn"

    fun add(option: Option) {
        options.add(option)
    }

    fun get(optionNumber: Int) : Option {
        return options.get(optionNumber-1)
    }

    override fun content() {
        options.forEachIndexed { index, option ->
            println("${index+1}. ${option.context}")
        }
        if (root != null) println("\n0. Quay về")
    }

    override fun execute(input: String) {
        val optionNumber: Int = input.toInt()
        if (optionNumber < 0 || optionNumber > options.size) {
            throw InvalidSelection("Lựa chọn không hợp lệ!")
        }
        if (optionNumber == 0) {
            if (root == null) {
                throw InvalidSelection("Không thể quay lại trang trước đó!")
            } else {
                Display.back()
            }
        } else options[optionNumber-1].function.invoke()
    }
}
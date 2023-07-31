package utils.lcConsole

import utils.lcTable.Table
import java.util.Scanner

open class TableViewer(val table: Table, title: String, root: Page?, scanner: Scanner): Menu(title, root, scanner) {

    override fun content() {
        table.print()
        super.content()
    }
}
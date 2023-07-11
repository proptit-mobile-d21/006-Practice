package view

class Table() {
    private var title = mutableListOf<String>()
    private var width = mutableListOf<Int>()
    private var data = mutableListOf<MutableList<String>>()
    private val widthOffset = 5

    constructor(title : MutableList<String>) : this(){
        println(title.size)
        this.width.clear()
        this.data.clear()
        this.title.clear()
        this.title = title
        setTitle(title)
    }
    private fun setTitle(title : MutableList<String>){
       // println("Hehe setTitle")
        width.clear()
        for (i in 0 until title.size){
            width.add(title[i].length + widthOffset)
        }
        println(title.size)
        for(i in 0 until title.size){
            fitIn(title[i], i)
        }
    }
    private fun fitIn(str : String, index : Int){
      //  println("Hehe Fitin")
        if(str.length + this.widthOffset > width[index]){
            width[index] = str.length + widthOffset
           // println("Độ rộng cột ${index + 1} đã được thay đổi thành ${width[index]}")
        }
    }
    fun addData(data : MutableList<String>){
        this.data.add(data)
        for(i in 0 until data.size){
            fitIn(data[i], i)
        }
    }
    fun printData(){
        if(data.isEmpty()){
            println("Không có dữ liệu")
            return
        }
        for(i in 0 until title.size){
            print("|" + title[i].padEnd(width[i]))
        }
        println()
        var sum = 0
        for(i in 0 until width.size){
            sum += width[i]
        }
        val str = "-".repeat(sum)
        for(i in 0 until data.size){
            println(str)
            for(j in 0 until data[i].size){
                print("|" + data[i][j].padEnd(width[j]))
            }
            println()
        }

    }



}
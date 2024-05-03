package data.mappers

import data.models.DataModel
import data.models.Item

class BookMapper {
    fun mapUniqueBooks(dataModel: DataModel): List<Item>{
        val booksList: MutableList<Item> = mutableListOf()
        println("Initial size: " + dataModel.items.size)
        for(item in dataModel.items){
            booksList.add(item)
        }
        return booksList
    }

    fun checkField(string: String): Boolean{
        return string.isNullOrEmpty()
    }
}

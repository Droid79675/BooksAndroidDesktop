package data.models

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("items")
    val items: List<Item>
)

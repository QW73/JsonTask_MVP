package com.qw73.itfactory.testprojectmvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Section {

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("items")
    @Expose
    var items: List<Item>? = null

    @SerializedName("header")
    @Expose
    var header: String? = null

    @SerializedName("itemsTotal")
    @Expose
    var itemsTotal: Int? = null

    @SerializedName("itemsToShow")
    @Expose
    var itemsToShow: Int? = null

    var clickedTotalItemsCount = 0

}


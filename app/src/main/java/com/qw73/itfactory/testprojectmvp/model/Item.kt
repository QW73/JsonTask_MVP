package com.qw73.itfactory.testprojectmvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("image")
    @Expose
    var image : Image?  = Image()


    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("aspectRatio")
    @Expose
    var aspectRatio: Int? = null

    @SerializedName("loopAnimation")
    @Expose
    var loopAnimation: Boolean? = null

}
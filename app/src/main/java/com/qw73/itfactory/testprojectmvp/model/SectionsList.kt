package com.qw73.itfactory.testprojectmvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SectionsList {
    @SerializedName("sections")
    @Expose
    var sections: List<Section>? = null

}

package com.qw73.itfactory.testprojectmvp.service

import com.qw73.itfactory.testprojectmvp.model.Section
import com.qw73.itfactory.testprojectmvp.model.SectionsList
import com.qw73.itfactory.testprojectmvp.network.ApiClient
import com.qw73.itfactory.testprojectmvp.network.ApiInterface
import com.qw73.itfactory.testprojectmvp.сontract.SectionsListContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SectionsListModel : SectionsListContract.Model {

    override fun getSectionsList(
        onFinishListener: SectionsListContract.Model.OnFinishListener,
        pageNumber: Int,
    ) {

        val apiService: ApiInterface = ApiClient.getClient()!!.create(ApiInterface::class.java)

        val call = apiService.getAllSections()
        call.enqueue(object : Callback<SectionsList> {
            override fun onResponse(
                call: Call<SectionsList>,
                response: Response<SectionsList>,
            ) {
                if (response.isSuccessful) {
                    val sections: List<Section>? = response.body()?.sections
                    onFinishListener.onFinished(sections)
                }
            }

            override fun onFailure(call: Call<SectionsList>, t: Throwable) {
                onFinishListener.onFailure(t)
            }

        })
    }
}

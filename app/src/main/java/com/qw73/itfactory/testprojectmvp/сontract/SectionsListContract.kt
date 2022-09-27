package com.qw73.itfactory.testprojectmvp.сontract

import com.qw73.itfactory.testprojectmvp.model.Section

interface SectionsListContract {
    interface Model {

        interface OnFinishListener {
            fun onFinished(sectionsList: List<Section>?)
            fun onFailure(throwable: Throwable)
        }

        fun getSectionsList(onFinishListener: OnFinishListener, pageNumber: Int)
    }

    interface View {
        fun showProgress()
        fun hideProgress()
        fun setDateRecyclerView(sectionsList: List<Section>)
        fun onResponseFailure(throwable: Throwable)
    }

    interface Presenter {
        fun onDestroy()
        fun getMoreData(pageNumber: Int)
        fun requestDataFromServer()
    }
}
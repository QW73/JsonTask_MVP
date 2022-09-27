package com.qw73.itfactory.testprojectmvp.presentor

import com.qw73.itfactory.testprojectmvp.model.Section
import com.qw73.itfactory.testprojectmvp.service.SectionsListModel
import com.qw73.itfactory.testprojectmvp.сontract.SectionsListContract


class SectionPresenter : SectionsListContract.Presenter,
    SectionsListContract.Model.OnFinishListener {

    private var sectionsListView: SectionsListContract.View?
    private var sectionsListModel: SectionsListContract.Model

    constructor(sectionsListView: SectionsListContract.View) {
        this.sectionsListView = sectionsListView
        this.sectionsListModel = SectionsListModel()
    }


    override fun onFinished(sectionsList: List<Section>?) {
        sectionsListView?.setDateRecyclerView(sectionsList!!)
        sectionsListView?.hideProgress()
    }

    override fun onFailure(throwable: Throwable) {
        sectionsListView?.onResponseFailure(throwable)
        sectionsListView?.hideProgress()
    }

    override fun onDestroy() {
        sectionsListView = null
    }

    override fun getMoreData(pageNumber: Int) {
        sectionsListView?.showProgress()
    }

    override fun requestDataFromServer() {
        sectionsListView?.showProgress()
        sectionsListModel.getSectionsList(this, 1)
    }

}
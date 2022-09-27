package com.qw73.itfactory.testprojectmvp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qw73.itfactory.testprojectmvp.databinding.ActivityMainBinding
import com.qw73.itfactory.testprojectmvp.model.Section
import com.qw73.itfactory.testprojectmvp.presentor.SectionPresenter
import com.qw73.itfactory.testprojectmvp.view.SectionsListAdapter
import com.qw73.itfactory.testprojectmvp.сontract.SectionsListContract

class MainActivity : AppCompatActivity(), SectionsListContract.View {

    private lateinit var sectionsList: List<Section>
    private lateinit var sectionsListAdapter: SectionsListAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        sectionsList = ArrayList()

        rv = binding.recyclerView
        val linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager
        rv.setHasFixedSize(true)

        progressBar = binding.pbLoading
        progressBar = binding.pbLoading

        val sectionsPresenter = SectionPresenter(this)
        sectionsPresenter.requestDataFromServer()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun setDateRecyclerView(sectionsList: List<Section>) {
        this.sectionsList = sectionsList
        sectionsListAdapter = SectionsListAdapter(this.sectionsList, this)
        rv.adapter = sectionsListAdapter
    }

    override fun onResponseFailure(throwable: Throwable) {
        Log.d("TEST", "onResponseFail ${throwable.toString()}")
        Log.d("TEST", "onResponseFail ...........")
        Toast.makeText(this, "Error in getting data", Toast.LENGTH_SHORT).show()
    }


}
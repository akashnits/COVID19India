package com.akash.tracker.covid19.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.akash.tracker.covid19.AppExecutors
import com.akash.tracker.covid19.R
import com.akash.tracker.covid19.databinding.ItemCovidStatsBinding
import com.akash.tracker.covid19.ui.common.DataBoundListAdapter
import com.akash.tracker.covid19.vo.StatewiseItem

/**
 * Created by akash on 21,July,2020
 */
class CovidStateStatsAdapter(val dataBindingComponent: DataBindingComponent, appExecutors: AppExecutors)
    : DataBoundListAdapter<StatewiseItem, ItemCovidStatsBinding>(
    appExecutors,
    object : DiffUtil.ItemCallback<StatewiseItem>() {
        override fun areItemsTheSame(oldItem: StatewiseItem, newItem: StatewiseItem): Boolean {
            return oldItem.lastupdatedtime == newItem.lastupdatedtime
        }

        override fun areContentsTheSame(oldItem: StatewiseItem, newItem: StatewiseItem): Boolean {
            return oldItem.confirmed == newItem.confirmed
        }
    }
) {

    override fun createBinding(parent: ViewGroup): ItemCovidStatsBinding {
        Log.d("CovidStateStatsAdapter", "create binding called")
        val binding= DataBindingUtil.inflate<ItemCovidStatsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_covid_stats,
            parent,
            false,
            dataBindingComponent
        )
        return binding
    }

    override fun bind(binding: ItemCovidStatsBinding, item: StatewiseItem) {
        binding.state= item
    }
}
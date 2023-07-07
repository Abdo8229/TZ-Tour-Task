package com.abdelrahman.ramadan.tz_.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.abdelrahman.ramadan.tz_.R
import com.abdelrahman.ramadan.tz_.data.pojo.data.TasksResponse


class ExpandableListAdapter(

) : BaseExpandableListAdapter() {
     var headers: List<String> = emptyList()
     var items: HashMap<String, List<TasksResponse>> = HashMap()
        fun updateData(headers: List<String>, items: HashMap<String, List<TasksResponse>>) {
            this.headers = headers
            this.items = items
            notifyDataSetChanged()
        }
    override fun getGroupCount(): Int {
        return headers.size
    }


    override fun getChildrenCount(p0: Int): Int {
        return items[headers[p0]]!!.size
    }

    override fun getGroup(p0: Int): Any {
        return headers[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return items[headers[p0]]!![p1]
    }

    override fun getGroupId(p0: Int): Long {

        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p3: View?, viewGroup: ViewGroup?): View {
        val view = LayoutInflater.from(viewGroup?.context)
            .inflate(R.layout.header_list_item, viewGroup, false)
        val rideIdTv: TextView = view.findViewById(R.id.tvRideId_header_list_item)
        rideIdTv.text = headers[p0]
        return view
    }

    @SuppressLint("SetTextI18n")
    override fun getChildView(
        p0: Int,
        p1: Int,
        p2: Boolean,
        p3: View?,
        viewGroup: ViewGroup?
    ): View {
        val view = LayoutInflater.from(viewGroup?.context)
            .inflate(R.layout.footer_list_item, viewGroup, false)
        val rideIdTv: TextView = view.findViewById(R.id.tvRideId_footer_list_item)
        val guideNameTv: TextView = view.findViewById(R.id.tvGideName_footer_list_item)
        val nodeTv: TextView = view.findViewById(R.id.tvNode_footer_list_item)
        val rideTypeTv: TextView = view.findViewById(R.id.tvRideType_footer_list_item)
        val pac: TextView = view.findViewById(R.id.tvTotalPac_footer_list_item)
        val task = items[headers[p0]]!![p1]
        rideIdTv.text = "RideId: " + task.rideId
        guideNameTv.text = "GuideName: " + task.guide
        nodeTv.text = "Note: " + task.note
        rideTypeTv.text = "RideType: " + task.rideType
        pac.text = "TotalPax: " + task.pax.toString()
        return view
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

}
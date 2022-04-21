package com.example.uccapplication.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.uccapplication.R
import com.example.uccapplication.models.TimetableModel

class TimetableAdapter():RecyclerView.Adapter<TimetableAdapter.ViewHolder>() {


    private var timetableModelArrayList: ArrayList<TimetableModel>? = ArrayList()
    var context: Context? = null


    constructor(list: ArrayList<TimetableModel>, context: Context) : this() {
        this.timetableModelArrayList = list
        this.context = context
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_timetable, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var timetableModel: TimetableModel = timetableModelArrayList?.get(position)!!
        holder.courseCode.text = timetableModelArrayList?.get(position)?.courseCode
        holder.courseTitle.text = timetableModelArrayList?.get(position)?.courseTitle
        holder.sec.text = timetableModelArrayList?.get(position)?.section
        holder.cr.text = timetableModelArrayList?.get(position)?.credit
        holder.room.text = timetableModelArrayList?.get(position)?.room
        holder.days.text = timetableModelArrayList?.get(position)?.days
        holder.start.text = timetableModelArrayList?.get(position)?.start
        holder.ends.text = timetableModelArrayList?.get(position)?.end

    }


    override fun getItemCount(): Int {
        return timetableModelArrayList?.size!!
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var courseCode: TextView = itemView.findViewById(R.id.tv_tt_courseCode)
        var courseTitle: TextView = itemView.findViewById(R.id.tv_tt_course_title)
        var sec: TextView = itemView.findViewById(R.id.tv_tt_sec)
        var cr: TextView = itemView.findViewById(R.id.tv_tt_credit)
        var room: TextView = itemView.findViewById(R.id.tv_tt_room)
        var days: TextView = itemView.findViewById(R.id.tv_tt_days)
        var start: TextView = itemView.findViewById(R.id.tv_tt_timeStarts)
        var ends: TextView = itemView.findViewById(R.id.tv_tt_timeEnds)
    }

}




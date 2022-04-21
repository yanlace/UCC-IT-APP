package com.example.uccapplication.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.uccapplication.R
import com.example.uccapplication.models.CourseModel

class CoursesAdapter(): RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {


    private  var coursesModelArrayList : ArrayList<CourseModel>?= ArrayList()
    var context : Context?= null

    constructor(list :ArrayList<CourseModel>,context: Context) : this() {
        this.coursesModelArrayList = list
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return  ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_course,parent,false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var courseModel: CourseModel = coursesModelArrayList?.get(position)!!
         holder.courseCode.text = coursesModelArrayList?.get(position)?.courseCode
         holder.courseTitle.text = coursesModelArrayList?.get(position)?.title
         holder.credit.text = coursesModelArrayList?.get(position)?.credits
         holder.preRequest.text = coursesModelArrayList?.get(position)?.preRequests
         holder.description.text = coursesModelArrayList?.get(position)?.description

    }
    override fun getItemCount(): Int {
        Log.d("Course A List Size :",""+coursesModelArrayList?.size)
       return coursesModelArrayList?.size!!
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var courseCode : TextView = itemView.findViewById(R.id.tv_course_course_code)

        var courseTitle : TextView = itemView.findViewById(R.id.tv_course_title)
        var credit : TextView = itemView.findViewById(R.id.tv_course_credit_hours)
        var preRequest :TextView= itemView.findViewById(R.id.tv_pre_request_course)
        var description : TextView = itemView.findViewById(R.id.tv_course_term)
    }


}

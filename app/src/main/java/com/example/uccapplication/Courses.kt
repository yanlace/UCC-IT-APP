package com.example.uccapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uccapplication.adapter.CoursesAdapter
import com.example.uccapplication.databinding.ActivityCoursesBinding
import com.example.uccapplication.models.CourseModel

class Courses : AppCompatActivity() {
    lateinit var db:DbHelper

    private lateinit var binding: ActivityCoursesBinding
    private  var coursesModelArrayList : ArrayList<CourseModel> = ArrayList()
    private  var coursesAdapter: CoursesAdapter?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Activity title
        binding.toolbar.tvToolbar.text ="Courses"
        db= DbHelper(this)
        db.addCourses()
        coursesModelArrayList=db.getCourses()
        coursesAdapter = CoursesAdapter(coursesModelArrayList,this)

        binding.idRVCourses.layoutManager = LinearLayoutManager(this)
        binding.idRVCourses.adapter = coursesAdapter

        // toolbar back icon
        // go back to main activity
        binding.toolbar.ivToolbarBack.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }




    }


}
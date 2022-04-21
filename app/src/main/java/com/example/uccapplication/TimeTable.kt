package com.example.uccapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.uccapplication.adapter.TimetableAdapter
import com.example.uccapplication.databinding.ActivityTimeTableBinding
import com.example.uccapplication.models.TimetableModel

class TimeTable : AppCompatActivity() {

    private lateinit var binding: ActivityTimeTableBinding

    private  var timetableModelArrayList: ArrayList<TimetableModel> = ArrayList()
    private var timetableAdapter: TimetableAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTimeTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.tvToolbar.text = "Time table"

        timetableAdapter = TimetableAdapter(timetableModelArrayList,this)

        binding.idRVTimetable.layoutManager = LinearLayoutManager(this)
        binding.idRVTimetable.adapter = timetableAdapter


        // toolbar back icon
        // go back to main activity
        binding.toolbar.ivToolbarBack.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



        setTimetable()
    }

   private fun setTimetable(){
       timetableModelArrayList.add(TimetableModel("ITT303","Programming Design using Java","A","3","sun","12:00","2:00","online"))
       timetableModelArrayList.add(TimetableModel("ITT420","Mobile Application Development","A1","3","mon","2:00","4:00","online"))
       timetableModelArrayList.add(TimetableModel("ITT411","Project +","B","3","tue","4:00","6:00","online"))
       timetableModelArrayList.add(TimetableModel("ITT405","Human Computer Interaction & Interface Design","B2","3","wed","5:00","7:00","online"))
       timetableModelArrayList.add(TimetableModel("SOC100","Intro to Sociology","A3","3","thu","6:00","8:00","online"))
       timetableModelArrayList.add(TimetableModel("ITT201","Data Communication and Network 1","AA","3","fri","9:00","11:00","online"))
       timetableModelArrayList.add(TimetableModel("MTH103","Calculus","AB","3","sat","11:00","1:00","online"))
       timetableModelArrayList.add(TimetableModel("ITT208","Internet Authoring I","AB","3","sat","6:00","8:00","online"))

   }
}
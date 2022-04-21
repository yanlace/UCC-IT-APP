package com.example.uccapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uccapplication.adapter.FacultyAdapter
import com.example.uccapplication.databinding.ActivityFacultyDirectoryBinding
import com.example.uccapplication.models.FacultyModel


class FacultyDirectory : AppCompatActivity() {


    private lateinit var binding: ActivityFacultyDirectoryBinding


    private  var facultyModelArrayList: ArrayList<FacultyModel> = ArrayList()
    private var facultyAdapter: FacultyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFacultyDirectoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // Activity Title
        binding.toolbar.tvToolbar.text ="Faculty Directory"

        facultyAdapter = FacultyAdapter(facultyModelArrayList,this)



       binding.idRvFaculties
           .layoutManager = LinearLayoutManager(this)
        binding.idRvFaculties .adapter = facultyAdapter

        // toolbar back icon
        // go back to main activity
        binding.toolbar.ivToolbarBack.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        setFaculty()
    }


    private fun setFaculty() {

        facultyModelArrayList?.add(FacultyModel("Natalie Rose", "+876", "ithod@ucc.edu.jm"))
        facultyModelArrayList?.add(FacultyModel("Otis Osbourne", "+876", "oosbourne@faculty.ucc.edu.jm"))
        facultyModelArrayList?.add(FacultyModel("Neil Williams", "+876", "nwilliams@faculty.ucc.edu.jm"))
        facultyModelArrayList?.add(FacultyModel("Henry Osbourne", "+876", "hosbourne@faculty.ucc.edu.jm"))
        facultyModelArrayList?.add(FacultyModel("Cecil White", "+876", "cwhite@faculty.ucc.edu.jmm"))
        facultyModelArrayList?.add(FacultyModel("Stephen Gentles", "+876", "sgentles@faculty.ucc.edu.jm"))
        facultyModelArrayList?.add(FacultyModel("Rochelle McBean", "+876", "rmcbean@faculty.ucc.edu.jm"))
        facultyModelArrayList?.add(FacultyModel("Karen Wilson", "+876", "kwilson@faculty.ucc.edu.jm"))
        facultyModelArrayList?.add(FacultyModel("Bryanna Chang", "+876", "bchang@faculty.ucc.edu.jm"))
        facultyModelArrayList?.add(FacultyModel("Shanae Owen", "+876", "sowens@faculty.ucc.edu.jm"))


    }

    fun phoneClicked(phone:String)
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),12);

        }else {
            val intent = Intent(Intent.ACTION_CALL);
            intent.data = Uri.parse("tel:$phone")
            startActivity(intent)
        }

    }


    fun emailClicked(email:String)
    {
        val to = email
        val intent = Intent(Intent.ACTION_SEND)
        val addressees = arrayOf(to)
        intent.putExtra(Intent.EXTRA_EMAIL, addressees)
        intent.type = "message/rfc822"
        startActivity(Intent.createChooser(intent, "Send Email using:"));

    }
}




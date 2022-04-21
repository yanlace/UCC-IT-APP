package com.example.uccapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Switch
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.uccapplication.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import java.util.*
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivTimeTable.setOnClickListener {
            val intent = Intent(this, TimeTable::class.java)
            startActivity(intent)
        }
        binding.ivCourses.setOnClickListener {
            val intent = Intent(this, Courses::class.java)
            startActivity(intent)
        }
        binding.ivAdmission.setOnClickListener {
            val intent = Intent(this, Admissions::class.java)
            startActivity(intent)
        }
        binding.ivFacultyDirectory.setOnClickListener {
            val intent = Intent(this, FacultyDirectory::class.java)
            startActivity(intent)
        }




       binding.ivFacebook.setOnClickListener {
           val intent =
               Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/uccjamaica/"))
           startActivity(intent)
       }
        binding.ivTwitter.setOnClickListener {
           val intent =
               Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/uccjamaica/"))
           startActivity(intent)
       }
        binding.ivInstagram.setOnClickListener {
           val intent =
               Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/accounts/login/?next=/uccjamaica/"))
           startActivity(intent)
       }

        binding.ivToolbarMenu.setOnClickListener{
            openDrawer()
        }

      // bind fab email here...
        binding.fabEmail.setOnClickListener{

            val to = "Rose-ithod@ucc.edu.jm"
            val intent = Intent(Intent.ACTION_SEND)
            val addressees = arrayOf(to)
            intent.putExtra(Intent.EXTRA_EMAIL, addressees)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Send Email using:"));
        }


    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.menu_courses){
            val intent = Intent(this, TimeTable::class.java)
            startActivity(intent)
        }

        if(item.itemId==R.id.menu_time_table){
            val intent = Intent(this, TimeTable::class.java)
            startActivity(intent)
        }
        if(item.itemId==R.id.menu_admissions){
            val intent = Intent(this, Admissions::class.java)
            startActivity(intent)
        }
        if(item.itemId==R.id.menu_faculty_directory){
            val intent = Intent(this, FacultyDirectory::class.java)
            startActivity(intent)
        }


       return true
    }
    public  fun openDrawer()
    {
        binding.myDrawerLayout.openDrawer(GravityCompat.START)
    }

    public  fun  closeDrawer()
    {
        binding.myDrawerLayout.closeDrawer(GravityCompat.START)
    }

}


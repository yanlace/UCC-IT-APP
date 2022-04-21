package com.example.uccapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.uccapplication.models.CourseModel

class DbHelper(context: Context) : SQLiteOpenHelper(context, "couses.db", null, 6) {
    val TAG = "DB HELPER"
    val TABLE = "COURSES"

    companion object {
        public val id: String = "id"
        public val courseTitle: String = "TITLE"
        public val term: String = "TERM"
        public val code: String = "CODE"
        public val credit: String = "CREDIT"
        public val prereq: String = "PREREQ"
    }

    val DATABASE_CREATE =
        "CREATE TABLE if not exists " + TABLE + " (" +
                "${id} integer PRIMARY KEY autoincrement," +
                "${courseTitle}  varchar," +
                "${term}         varchar , "+
                "${code}         varchar , "+
                "${credit}      varchar ,"+
                "${prereq}      varchar "+
                ")"


    override fun onCreate(db: SQLiteDatabase) {
        Log.d(TAG, "Creating: " + DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(p0: SQLiteDatabase, p1: Int, p2: Int) {
    }

  fun   addCourses()
    {
        this.readableDatabase.delete(TABLE,null,null)

        add(CourseModel("MTH103","Discrete Mathematics","3","ITT102 Discrete Mathematics","Semester 2nd"))
        add(CourseModel("ITT403","Data Communication and Networks II","3","ITT201 Data Communication and Networks I","Semester 3rd"))
        add(CourseModel("ITT411","Project +","0","None","Semester 8th"))
        add(CourseModel("ITT303","JAVA","3","ITT200  C++","Semester Ist"))
        add(CourseModel("ITT405","Human Computer Interaction & Interface Design","3","PSY100 Introduction to Psychology, ITT205 System Analysis and Design","Semester 6th"))
        add(CourseModel("ITT401","Intelligent System","3","ITT300 Discrete Mathematics II","Semester 7th"))
        add(CourseModel("MTH103","Discrete Mathematics","3","ITT102 Discrete Mathematics","Semester 8th"))
        add(CourseModel("ITT302","Operating Systems","3","ITT200 Object Oriented Programming using C++ ","Semester 4th"))
        add(CourseModel("ITT401","Intelligent Systems","3","ITT102 Discrete Mathematics II","Semester 8th"))
        add(CourseModel("ITT323","IT Capstone Project I","3","Completed 87 credit hours","Semester 6th"))

    }

    fun add(course: CourseModel) {
        val values = ContentValues()
        values.put(courseTitle, course.title)
        values.put(term, course.description)
        values.put(code, course.courseCode)
        values.put(credit, course.credits)
        values.put(prereq, course.preRequests)
        getWritableDatabase().insert(TABLE, null, values);
    }

    fun getCourses():ArrayList<CourseModel>
    {
        val db = this.readableDatabase

        // on below line we are creating a cursor with query to read data from database.

        // on below line we are creating a cursor with query to read data from database.
        val cursorCouses = db.rawQuery("SELECT * FROM $TABLE", null)

        // on below line we are creating a new array list.

        // on below line we are creating a new array list.
        val courseModalArrayList: ArrayList<CourseModel> = ArrayList()

        // moving our cursor to first position.

        // moving our cursor to first position.
        if (cursorCouses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(
                    CourseModel(
                        cursorCouses.getString(3),
                        cursorCouses.getString(1),
                        cursorCouses.getString(4),
                        cursorCouses.getString(5),
                        cursorCouses.getString(2)
                    )
                )
            } while (cursorCouses.moveToNext())
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        // at last closing our cursor
        // and returning our array list.
        cursorCouses.close()
        return courseModalArrayList

    }



}
package com.example.uccapplication.models

class TimetableModel {
    var courseCode: String? = null
    var courseTitle: String? = null
    var section: String? = null
    var credit: String? = null
    var days: String? = null
    var start: String? = null
    var end: String? = null
    var room: String? = null

    constructor() {}
    constructor(
        courseCode: String?,
        courseTitle: String?,
        section: String?,
        credit: String?,
        days: String?,
        start: String?,
        end: String?,
        room: String?
    ) {
        this.courseCode = courseCode
        this.courseTitle = courseTitle
        this.section = section
        this.credit = credit
        this.days = days
        this.start = start
        this.end = end
        this.room = room
    }
}
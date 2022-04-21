package com.example.uccapplication.models

class CourseModel {
   public var courseCode: String? = null
   public var title: String? = null
   public var credits: String? = null
   public var preRequests: String? = null
   public var description: String? = null

    constructor(
        courseCode: String?,
        title: String?,
        credits: String?,
        preRequests: String?,
        description: String?
    ) {
        this.courseCode = courseCode
        this.title = title
        this.credits = credits
        this.preRequests = preRequests
        this.description = description
    }


}
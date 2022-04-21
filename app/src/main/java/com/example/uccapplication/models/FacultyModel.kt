package com.example.uccapplication.models

class FacultyModel {
   public var name: String? = null
   public  var phone: String? = null
   public var email: String? = null


    constructor() {}
    constructor(name: String){
        this.name = name
    }
    constructor(name: String?, phone: String?, email: String?) {
        this.name = name
        this.phone = phone
        this.email = email
    }


}
package com.employee.commandObjects

import grails.validation.Validateable

class EmployeeCommand implements Validateable{
    String firstName
    String lastName
    Integer age
    String phonenumber

    static constraints = {
        firstName(blank: false, maxSize: 30)
        lastName(blank: false, maxSize: 30)
        age(blank: false,null:false, min: 18)
        phonenumber(blank: false, null: false)
    }
}

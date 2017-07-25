package com.company.employee

class Employee {
    String first_Name
    String last_Name
    int age
    String phonenumber

    static mapping = {
      
    }
    static constraints = {
        first_Name blank: false
        last_Name blank: false
        phonenumber blank: false
        age range: 13..99
    }

}

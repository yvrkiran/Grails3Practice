package com.employee.phoneLookup

import com.company.employee.Employee
import com.employee.bo.Address
import com.employee.bo.EmployeeDetails
import com.employee.bo.Occupation
import com.employee.commandObjects.EmployeeCommand
import com.employee.errors.PhoneNumberException
import grails.transaction.Transactional

@Transactional
class EmployeeService {


    PhoneNumberException phoneNumberExceptionBean

    def employeeLookup(String phoneNumber) {
        def empDetails = Employee.findByPhonenumber(phoneNumber)
        def empAddress = com.company.employee.Address.findByEmployee_id(empDetails?.id)
        //def empOccupation = com.company.employee.Occupation.findByEmployee_id(empDetails?.id)


        EmployeeDetails employee = new EmployeeDetails()
        Address address = new Address()
        Occupation occupation = new Occupation()

        if (!empDetails) {
            throw phoneNumberExceptionBean
        } else {

           /* occupation.employer = empOccupation.employer
            occupation.experience = empOccupation.experience*/

            /*address.street = "shelard"
            address.city = "Hopkins"
            address.state = "MN"*/

            address.street = empAddress?.street
            address.city = empAddress?.city
            address.state = empAddress?.state

            occupation.employer = "worldwide"
            occupation.experience = 9



            employee.firstName = empDetails.first_Name
            employee.lastName = empDetails.last_Name
            employee.address = address
            employee.occupation = occupation
        }
        return employee
    }
    void registerEmployeeDetails(EmployeeCommand employeeCommand) {
        Employee employee = new Employee(
                first_Name: employeeCommand?.firstName,
                last_Name: employeeCommand?.lastName,
                age: employeeCommand?.age,
                phonenumber: employeeCommand.phonenumber
        )
        employee.save()

    }
}

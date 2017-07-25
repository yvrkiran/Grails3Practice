package com.employee.phoneLookup

import com.company.employee.Employee
import com.employee.commandObjects.EmployeeCommand
import com.employee.errors.PhoneNumberException
import grails.converters.JSON
import grails.core.GrailsApplication
import grails.plugins.rest.client.RestBuilder
import grails.rest.RestfulController
import org.springframework.context.MessageSource

class EmployeeController extends RestfulController{
    EmployeeController() {
        super(Employee)
    }


    EmployeeService employeeService
    MessageSource messageSource
    GrailsApplication grailsApplication

    def restConsume() {
        String url = "https://httpbin.org/get"

        def resp = new RestBuilder().get(url) {
        }
        render resp.json
    }

    def index() {

        if (params?.phonenumber) {
            render employeeService.employeeLookup(params.phonenumber) as JSON
        } else {
            render "Phonenumber not found in the request uri"
        }

    }

    def registration() {
        render view: "registration"
    }

    def handleException(Exception e) {
        print e.printStackTrace()
        if (e instanceof PhoneNumberException) {
            render messageSource.getMessage(e.errorErrorMessage, null, Locale.getDefault())
        }
    }

    def save(EmployeeCommand employeeCommand) {

        if (employeeCommand.hasErrors()) {
            render messageSource.getMessage('com.registration.form.error', null, Locale.getDefault())
            return
        }
        employeeService.registerEmployeeDetails(employeeCommand)
        println grailsApplication.config.getProperty("foo.bar.hello")
        //println grailsApplication.config.application.person.url

        render messageSource.getMessage('com.registration.form.success', [employeeCommand.firstName] as Object[], Locale.getDefault())

    }
}

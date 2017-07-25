package com.company.employee

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.hibernate.HibernateSpec

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@SuppressWarnings(['MethodName', 'DuplicateNumberLiteral'])
@TestFor(Employee)
class EmployeeSpec extends HibernateSpec {
    Employee employee
    def setup() {
employee = Mock()
    }

    def cleanup() {
    }

    void "test domain class validation"() {
        when: 'A domain class is saved with invalid data'
        employee = new Employee(first_Name: "",last_Name: "",age: 12,phonenumber: "")
        employee.save()

        then:'There were errors and the data was not saved'
        employee.hasErrors()

    }
}

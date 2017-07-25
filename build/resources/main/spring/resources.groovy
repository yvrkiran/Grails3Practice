import com.employee.errors.PhoneNumberException

// Place your Spring DSL code here
beans = {
    phoneNumberExceptionBean(PhoneNumberException){
        println "phone number exception bean created"
        errorCode = '101'
        errorErrorMessage = 'com.phonnumberlookup.notfound'
    }
}

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Form</title>
</head>
<body>
<g:form controller="employee" action="save">
    <label>First Name: </label>
    <g:textField name="firstName"/><br/>
    <label>Last Name: </label>
    <g:textField name="lastName"/><br/>
    <label>Age: </label>
    <g:textField name="age"/><br/>
    <label>Phone NO: </label>
    <g:textField name="phonenumber"/><br/>
    <g:actionSubmit value="Save"/>
</g:form>
</body>
</html>
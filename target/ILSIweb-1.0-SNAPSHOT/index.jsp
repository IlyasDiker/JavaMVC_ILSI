<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>MVC- Java</title>
    <link rel="stylesheet" href="https://unpkg.com/chota@latest">
    <link rel="stylesheet" href="resources/css/styles.css">
    <script src="resources/js/app.js"></script>
</head>
<body>

<div class="container">
    <h1><%= "MVC - ILSIweb" %></h1>
    <br/>

    <h3>Create new Student</h3>
    <form action="StudentController" method="POST">
        <div class="row">
            <input class="col" type="text" name="FirstName" placeholder="First Name">
            <input class="col" type="text" name="LastName" placeholder="Last Name">
        </div>
        <div class="row">
            <select name="sexe" class="col">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
        </div>
        <input type="submit" value="Save">

    </form>
</div>

</body>
</html>
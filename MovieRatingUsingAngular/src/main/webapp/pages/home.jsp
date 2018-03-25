<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>Employee List</h1>
        <h3>
            <a href="newUser">New User</a>
        </h3>
        <table border="1">
 
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Telephone</th>
            <th>Action</th>
 
            <c:forEach var="user" items="${listUsers}">
                <tr>
 
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.phoneNumber}</td>
                    <td><a href="editUser?id=${user.userId}">Edit</a>
                             <a
                        href="deleteEmployee?id=${user.userId}">Delete</a></td>
 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #04AA6D;
  color: white;
}
.button:link, .button:visited{
  background-color: white;
  color: black;
  border: 2px solid green;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
.button:hover, .button:active {
  background-color: green;
  color: white;
}
a:link, a:visited {
  background-color: white;
  color: black;
  border: 2px solid green;
  padding: 3px 6px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
a:hover, a:active {
  background-color: green;
  color: white;
}
</style>
<body>
	<h1>Student List</h1>
	<!-- <table border="2" width="70%" cellpadding="2"> -->
	<table>
	<tr><th>Student Id</th><th>Name</th><th>Email</th><th>Country</th><th>Contact Number</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="student" items="${list}"> 
    <tr>
    <td>${student.studentId}</td>
    <td>${student.name}</td>
    <td>${student.email}</td>
    <td>${student.country}</td>
    <td>${student.contactno}</td>
    <td><a href="editstudent/${student.studentId}">Edit</a></td>
    <td><a href="deletestudent/${student.studentId}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="studentform" class="button">Add New Student</a>
    <a href="index.jsp" class="button">Home Page</a>
</body>    
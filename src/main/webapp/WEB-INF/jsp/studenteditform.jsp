<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page isELIgnored="false" %>

<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  width: 50%;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
a:link, a:visited {
  background-color: white;
  color: black;
  border: 2px solid green;
  padding: 10px 20px;
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
<h1>Update Student</h1>
<p style="color:red;">${error} </p>
<div>
  <form:form method="POST" action="/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="studentId" /></td>
         </tr> 
         <tr>  
          <td>Name : </td> 
          <td><form:input required="required" path="name"  /></td>
         </tr>  
         <tr>  
          <td>Email :</td>  
          <td><form:input required="required" path="email" /></td>
         </tr> 
         <tr>  
          <td>Country :</td>  
          <td><form:input required="required" path="country" /></td>
         </tr> 
         <tr>  
          <td>Contact Number :</td>  
          <td><form:input required="required" path="contactno" /></td>
         </tr>       
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Update" /></td>  
         </tr>  
        </table>  
       </form:form> 
</div>
</body>		

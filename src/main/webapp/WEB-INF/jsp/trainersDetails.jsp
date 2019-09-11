<%-- 
    Author     : elTok
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="./static/trainersDetails.css" /> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainer</title>
       
    </head>
    <body>
        
         <div class="col-sm-12 text-center">
         <h4>Trainer's Details Form</h4>
                          </div>
       
        <form:form method="post" modelAttribute="trainer"  action="/trainersApp/addTrainer">

	
            <div class="col-sm-12 col-md-8 col-md-offset-2">
               
              <div class="form-group">
                
              <form:hidden path="id"/>
              <form:label class="sr-only" path="name"> Name:</form:label>
              <form:input path="name" cssClass="form-control" placeholder="First Name" required="required" ></form:input>
   
              </div>
              <div class="form-group">

              <form:label path="lastname" class="sr-only" >Last Name:</form:label>
              <form:input path="lastname" placeholder="Last Name" cssClass="form-control" required="required"></form:input>
              
              </div>
              
              <div class="form-group">
  
              <form:label path="subject" class="sr-only">Subject:</form:label>
              <form:input path="subject" placeholder="Subject" cssClass="form-control" required="required"></form:input>
             
              
              </div>

               <div class="form-group">

               <button type="save" value="Save" class="btn-sm btn-success"> <i class="fas fa-save"></i>Save</button>
    	
               </div>  
              
                   
</form:form>
          </div>
     

</br>

 <div class="col-sm-12 text-center">
                
<h4>All Trainers</h4> 
         
 </div>     

 <div class="col-sm-12 col-md-8 col-md-offset-2">

<c:if test="${!empty listOfTrainers}">
	<table class="table table-striped">
	<tr>
          
            <th># </th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Subject </th>
            <th>Action</th>
            <th>Action</th>
	</tr>
            
	<c:forEach items="${listOfTrainers}" var="trainer">
		<tr>
			<td id="result">${trainer.id}</td>
			<td id="result">${trainer.name}</td>
			<td id="result">${trainer.lastname}</td>
                        <td id="result">${trainer.subject}</td>

			<td><a class="btn-sm btn-warning" role="button" href="<c:url value='/updateTrainer/${trainer.id}' />" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
Edit</a></td>
			<td><a class="btn-sm btn-danger" onClick=" return confirmDelete()" role="button" href="<c:url value='/deleteTrainer/${trainer.id}' />" ><i class="fa fa-close"></i>Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
  
 </div>
<script type="text/javascript">
function confirmDelete(){
var userchoice = confirm("Are you sure you want to delete this entry?");
if (userchoice === true){
    alert("Entry deleted!");
  }
  else{
    alert("Entry not deleted!");
} 
return userchoice;
}
</script>
 
    </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="utf-8" />
    <title>AngularJS User Registration and Login Example & Tutorial</title>
   
	
	 
	 
	 <script type="text/javascript" src="<c:url value="/resources/js/angular.min.js" />"></script>
	
</head>
<body ng-app="myApp">

    
	<div ng-controller="myCtrl"> 
	{{firstName}}
	{{3+4}}
	
	<button ng-click="getUserData();" >OK</button>
	
	Insert New USer:
	<p>First Name  <input type="text" name="firstname" ng-model="name" required /></p>
	<p>First Name  <input type="text" name="email" ng-model="email" required /></p>
	 <button ng-click="sendDataAngular2()">Submit</button>
	 
	 {{message}}
		
	{{getData}}
	
	UPdate User
	<p>First Name  <input type="text" name="updatedname" ng-model="updatedname" required /></p>
	<p>email <input type="text" name="updtaedemail" ng-model="updtaedemail" required /></p>
	 <button ng-click="updtaeData()">Submit</button>
	 {{updateMessage}}
	</div>
	ssss
	
	
	

<div>

	
	
	

     <script type="text/javascript" src="<c:url value="/resources/js/app.js" />"></script>
   
</body>
</html>
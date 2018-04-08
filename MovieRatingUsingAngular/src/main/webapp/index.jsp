<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app="testModule">
<head>
<!-- files should be inside resources folder under web app -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<link href="<c:url value="/resources/cssFiles/loginstyle.css" />" rel="stylesheet">
<script src="<c:url value="/resources/jsFiles/test.js" />"></script>
<script src="<c:url value="/resources/jsFiles/testAngular.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <form action="insert">
    	<input type="submit"/>
    </form>
    <div ng-controller="firstController">
    <button ng-click="testClick()">Testjs</button>
	</div>
    <h1 id="h1">hi lets check css working or not ${pageContext.request.contextPath}</h1>
</body>
</html>
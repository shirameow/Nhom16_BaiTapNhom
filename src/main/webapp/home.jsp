<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.account.getRole().equal("Sinh viên")}">
      	<p>Chức năng sv 1</p>
      	<p>Chức năng sv 2</p>
      	<p>Chức năng sv 3</p>
    </c:if>
    <c:if test="${sessionScope.account.getRole().equal("Giảng viên")">
      	<p>Chức năng gv 1</p>
      	<p>Chức năng gv 2</p>
      	<p>Chức năng gv 3</p>
    </c:if>
</body>
</html>
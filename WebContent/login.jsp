<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%@taglib prefix="s" uri="/struts-tags"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>login</title>  
</head>  
<body>  
<s:form action="login.action" namespace="">  
    <s:textfield key="username"/>  
    <s:password key="password" />  
    <s:submit/>  
</s:form>  
</body>  
</html>  
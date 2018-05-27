<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-reboot.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New waggon</title>
</head>
<body>
<div align="center">
    <h1>New waggon</h1>
    <table>
        <form:form action="${pageContext.request.contextPath}/waggons/add" method ="post" modelAttribute="waggon">
            <tr>
                <td>Registration Number:</td>
                <td><form:input path="regNumber"/></td>
            </tr>
            <tr>
                <td>Shift size:</td>
                <td><form:input path="shiftSize"/></td>
            </tr>
            <tr>
                <td>Capacity:</td>
                <td><form:input path="capacity"/></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td>
                    <form:select class="form-control" path="status">
                        <form:option value="" label ="Please select"/>
                        <form:options items="${statusWaggon}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Current city:</td>
                <td>
                    <form:select class="form-control" path="city">
                        <form:option value="" label=" Please select"/>
                        <form:options items="${maps}" itemValue="idCity" itemLabel="city" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                </td>
            </tr>

        </form:form>
    </table>
</div>
<p><a href="${pageContext.request.contextPath}/welcome">Home page</a></p>
</body>
</html>
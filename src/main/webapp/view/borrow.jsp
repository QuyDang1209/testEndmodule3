<%--<%@ page import="org.example.tourscrud.model.Tour" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />

    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" />
    <link rel="stylesheet" href="css/dataTables.bootstrap5.min.css" />
    <link rel="stylesheet" href="/css/edit.css">
    <title>Tour Management Application</title>
</head>
<body>
<div>
    <div>
        <h1> Borrow Book</h1>
    </div>
    <table>
        <tr>
        <td>
            <label for="id" >Book id</label>
            <input type="hidden" class="form-control" id="id" name="id" value="<c:out value='${bookbr.bookID}' />">
        </td>
        <td>
            <label for="name" >Book name</label>
            <input type="text" class="form-control" id="name" name="name" value="<c:out value='${bookbr.bookName}' />">
        </td>
        <td>
            <label for="type" class="form-label">Students</label>
            <select class="form-control" id="type" name="type">
                <c:forEach items="${stu}" var="t">
                    <option value="${t.studentID}"
                    >${t.name}</option>
                </c:forEach>
            </select>
        </td>
        <td>
            <label for="date">Date borrow</label>
            <input type="hidden" placeholder="YY/MM/DD" id="date" name="date">
        </td>
        <td>
            <label for="date1">Date pay</label>
            <input type="text" placeholder="YY/MM/DD" id="date1" name="date1">
        </td>
        </tr>
    </table>
</div>


<script src="./js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.0.2/dist/chart.min.js"></script>
<script src="./js/jquery-3.5.1.js"></script>
<script src="./js/jquery.dataTables.min.js"></script>
<script src="./js/dataTables.bootstrap5.min.js"></script>
<script src="./js/script.js"></script>

</body>
</html>
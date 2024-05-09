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

    <link rel="stylesheet" href="/css/style.css">
    <title>Tour List</title>
</head>
<body>



<section id="table">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12 mb-3">
                <div class="card">
                    <div>
                        <h1 STYLE="text-align: center">LIST BOOKS</h1>
                    </div>
<%--                    <form action="" method="post">--%>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table id="example" class="table table-striped data-table" style="width: 100%">
                                <thead>
                                <tr>
                                    <th>BOOK ID</th>
                                    <th>BOOK NAME</th>
                                    <th>AUTHOR</th>
                                    <th>DECRIPTION</th>
                                    <th>QUANTITY</th>
                                    <th>ACTION</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="b" items="${listBook}">
                                    <tr>
                                        <td><c:out value="${b.bookID}"/></td>
                                        <td><c:out value="${b.bookName}"/></td>
                                        <td><c:out value="${b.author}"/></td>
                                        <td><c:out value="${b.decription}"/></td>
                                        <td><c:out value="${b.quantity}"/></td>
                                        <td>
                                            <button type="button" class="btn btn-info" onclick="window.location.href='/book?action=borrow&id=${b.bookID}'">Borrow</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>

<script src="./js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.0.2/dist/chart.min.js"></script>
<script src="./js/jquery-3.5.1.js"></script>
<script src="./js/jquery.dataTables.min.js"></script>
<script src="./js/dataTables.bootstrap5.min.js"></script>
<script src="./js/script.js"></script>

</body>
</html>

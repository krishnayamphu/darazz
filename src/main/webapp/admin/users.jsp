<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Admin Users</title>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <div class="container">
        <a class="navbar-brand" href="/darazz">DARAZZ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/darazz">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="users">Admin Users</a>
                </li>
            </ul>

            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">${user}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">
    <div class="row justify-content-between py-3">
        <div class="col"><h5>All Users</h5></div>
        <div class="col">
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="admin-add"><i class="fa fa-user-plus"></i> User</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col">
            ${err}
        </div>
    </div>
    <table class="table table-bordered ">
        <thead>
        <tr>
            <th>SN</th>
            <th>Fullname</th>
            <th>Address</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Created Date</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <th>1</th>
                <td>${user.firstname} ${user.lastname}</td>
                <td>${user.address}</td>
                <td>${user.email}</td>
                <td>${user.contact}</td>
                <td>${user.createdAt}</td>
                <td>
                    <a class="btn btn-primary" href="edit?id=${user.id}"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                            data-bs-target="#modal${user.id}">
                        <i class="fa fa-trash-o" aria-hidden="true"></i>
                    </button>
                </td>


                <!-- Modal -->
                <div class="modal fade" id="modal${user.id}" tabindex="-1" aria-labelledby="modal${user.id}"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="admin-del" method="post">
                                <input type="hidden" value="${user.id}" name="id">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="modal${user.id}">Deleting Item</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <p class="modal-title" id="modal${user.id}">Are you sure delete this Item?</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel
                                    </button>
                                    <button type="submit" class="btn btn-danger">Confirm</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>

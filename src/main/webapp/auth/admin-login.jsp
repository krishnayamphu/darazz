<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Admin Login</title>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="/darazz">DARAZZ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/darazz">Home</a>
                </li>
            </ul>

            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">Register</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">
   <div class="row justify-content-center mt-5 pt-5">
       <div class="col-6">
           <form action="login" method="post">
               ${error}
               <div class="mb-3">
                   <label class="form-label">Username</label>
                   <input type="text" class="form-control" name="username" placeholder="username" required>

               </div>
               <div class="mb-3">
                   <label class="form-label">Password</label>
                   <input type="password" class="form-control" name="password" placeholder="password" required>
               </div>
               <%--        <div class="mb-3 form-check">--%>
               <%--            <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
               <%--            <label class="form-check-label" for="exampleCheck1">Check me out</label>--%>
               <%--        </div>--%>
               <button type="submit" class="btn btn-primary">Login</button>
           </form>
       </div>
   </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>

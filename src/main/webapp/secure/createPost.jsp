<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 450px}

        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="/secure/threadView">Home</a></li>
                <li><a href="/secure/createThread.jsp">Create Thread</a></li>
                <li><a href="/secure/users">Board Users</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/secure/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

   <div>
        <c:forEach items="${threadList}" var="viewThreads">
        <h4 class="media-heading">Welcome to <c:out value="${viewThreads.threadName}"/> post below!</h4>
        </c:forEach>
    </div>

    <div class="media">

            <c:forEach items="${post}" var="showPost">
                <div class="media-body">
                    <h4 style="color: red" class="media-heading"><c:out value="${showPost.usernameOfPoster}"/></h4>
                    <p><c:out value="${showPost.postContent}"/></p>
                    <h6 style="color: greenyellow"><c:out value="${showPost.timeOfPost}"/></h6>

                </div>
            </c:forEach>
    </div>

<form action="/secure/postView/createNewPost" method="POST" role="form">
    <div class="form-group">
        <label for="postContent">Post</label>
        <textarea class="form-control" rows="3" id="postContent" name="postContent"></textarea>
    </div>
    <div class="form-group">
        <label for="timeOfPost">Date and Time of Post:</label>
        <input type="date" class="form-control"  id="timeOfPost" name="timeOfPost">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>


<footer class="container-fluid text-center">
    <p>Welcome To Ayub's Web App</p>
</footer>

</body>
</html>

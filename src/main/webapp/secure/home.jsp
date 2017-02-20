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
                <li class="active"><a href="#">Home</a></li>
                <li><a href="/secure/createThread.jsp">Create Thread</a></li>
                <li><a href="/secure/users">Board Users</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/secure/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="media">
<c:forEach items="${threadList.iterator()}" var="viewThreads">
    <div class="media-body">
        <h4 class="media-heading"><a href="/secure/createPost.jsp"><c:out value="${viewThreads.threadName}"/></a></h4>
        <p><c:out value="${viewThreads.threadDescription}"/></p>
</c:forEach>
</div>

    <div class="row">
        <div class="col-sm-4 col-xs-4" >
            <c:if test="${threadList.hasPrevious()}">
                <div class="pull-left"><a href="/secure/threadView?page=<c:out value="${threadList.number - 1}"/>&size=<c:out value="${threadList.size}"/>"> Previous
                    Page</a></div>
            </c:if>
        </div>

        <div class="col-sm-4 col-xs-4">
            Page <c:out value="${threadList.number+1}"/> of <c:out value="${threadList.totalPages}"/>, Total Records Found:<c:out value="${threadList.totalElements}"/>
            <div>
                <form method="post" action="/secure/threadView" id="sizeform">
                    Results Per Page:
                    <select name="size" onchange="sizeform.submit();">
                        <option value="3" <c:out value="${threadList.size==3?'selected':''}"/> >
                            3
                        </option>
                        <option value="6" <c:out value="${threadList.size==6?'selected':''}"/> >
                            6
                        </option>
                        <option value="9" <c:out value="${threadList.size==9?'selected':''}"/> >
                            9
                        </option>
                    </select>
                </form>
            </div>
        </div>


        <div class="col-sm-4 col-xs-4">

            <c:if test="${threadList.hasNext()}">
                <div class="pull-right"><a href="/secure/threadView?page=<c:out value="${threadList.number + 1}"/>&size=<c:out value="${threadList.size}"/> "> Next
                    Page</a></div>
            </c:if>
        </div>
    </div>


<footer class="container-fluid text-center">
    <p>Welcome To Ayub's Web App</p>
</footer>

</body>
</html>

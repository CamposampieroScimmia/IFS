<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/index.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <form class="form-signin" name="formLog" action="/check" method="post" >
                <h1 class="form-signin-heading text-muted">Esegui l'accesso</h1>
                <c:if test = "${ErrMsg!=null}"><div id="err" style="color:red;"> ${ErrMsg}</div></c:if>
                <input type="text"  name="matr" maxlength="8" placeholder="Username" required="" autofocus="">
                <input type="password" name="pass"   maxlength="20" placeholder="Password" required="">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Accedi</button>
            </form>
    </body>
</html>

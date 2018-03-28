<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

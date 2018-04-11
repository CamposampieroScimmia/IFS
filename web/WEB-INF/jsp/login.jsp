<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <!-- CSS Aggiornato minimale e compilato -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Tema Opzionale -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
   <link rel="stylesheet" type="text/css" href="resources/css/style_login.css">
<!-- JavaScript Aggiornato minimale e compilato -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <br><br><br><br><br><br><br><br><br><br>
    <div class="login">
        <div class="login-triangle"></div>
  
         <h2 class="login-header">Log in</h2>
            
            <form class="login-container" name="formLog" action="/check" method="post">
            <c:if test = "${ErrMsg!=null}"><div id="err" style="color:red;"> ${ErrMsg}</div></c:if>
            <input type="text"  name="matr" maxlength="8" placeholder="Username" required="" autofocus="">
            <input type="password" name="pass"   maxlength="20" placeholder="Password" required="">
            <p><input type="submit" value="Log in"></p>
            </form>
    </div>
    </body>
</html>

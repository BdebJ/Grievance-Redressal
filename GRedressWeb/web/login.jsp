<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Login</title>
        <style type="text/css">          
            .button-login {background-color: green;color: white;}
        </style>
         <script src="./js/jquery-1.11.1.min.js"></script> 
    </head>
    <script>  
</script>  
    <body>
        <h2>Login</h2>
         <span style="color: red;"><s:property value="msg" /></span>
        <s:form name="myform" action="logon" method="post">
            <s:textfield label="Username" name="username" />
            <s:textfield label="Password" name="password" />          
            <s:submit cssClass="button-login" value="Login" />
        </s:form>
        
    </body>
</html>
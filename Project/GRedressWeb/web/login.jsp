<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Register</title>
        <style type="text/css">          
            .button-login {background-color: green;color: white;}
        </style>
         <script src="./js/jquery-1.11.1.min.js"></script> 
    </head>
    <script>  
</script>  
    <body>
        <h2>Login</h2>
        <s:form name="myform" action="login.action" method="post">
            <s:textfield label="Username" name="username" />
            <s:textfield label="Password" name="password" />          
            <s:submit cssClass="button-login" value="Login" />
        </s:form>
        <s:if test="ctr>0">
            <span style="color: green;"><s:property value="msg" /></span>
        </s:if>
        <s:else>
            <span style="color: red;"><s:property value="msg" /></span>
        </s:else>
    </body>
</html>
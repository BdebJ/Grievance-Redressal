<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Register</title>
        <style type="text/css">
            .button-register {
                background-color: green;
                color: white;
            }
            .button-report {
                background-color: #000000;
                color: white;
                margin-left: 30%;
            }
        </style>
    </head>
    <body>
        <h2>FEEDBACK</h2>
        <s:form action="addFeedback.action" method="post">

            <s:textfield label="FEEDBACK" name="feedback" />

            <s:textfield label="RATING" name="rating" />
            <s:submit  cssClass="button-register" value="Submit" />



        </s:form>

        <s:if test="ctr>0">
            <span style="color: green;"><s:property value="msg" /></span>
        </s:if>
        <s:else>
            <span style="color: red;"><s:property value="msg" /></span>
        </s:else>
    </body>
</html>
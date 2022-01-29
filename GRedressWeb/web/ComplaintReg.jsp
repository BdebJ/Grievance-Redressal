<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Add Complaint</title>
        <style type="text/css">
            .button-register {background-color: green;color: white;}
            .button-report {background-color: #000000;color: white;margin-left: 30%;}
        </style>
    </head>
    <body>
       
        <s:form action="addcomplaint.action" method="post">
             <s:textfield label="Date and Time" name="compltime" />
            <s:textfield label="Subject" name="subject" />
            <s:textfield label="Description" name="description" />
            <s:textfield label="Pid" name="pid" />
             <s:textfield label="Owned product" name="ownid" /> 
           
           
            
            <s:submit cssClass="button-register" value="Add Complaint" />
        </s:form>
        <s:if test="ctr>0">
            <span style="color: green;"><s:property value="msg" /></span>
        </s:if>
        <s:else>
            <span style="color: red;"><s:property value="msg" /></span>
        </s:else>
    </body>
</html>
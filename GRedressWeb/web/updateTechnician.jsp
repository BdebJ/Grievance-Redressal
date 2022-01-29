<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Update</title>
    </head>
    <body>
        <h2>UPDATE TECHNICIAN</h2>
        <form action= "updatetechniciandetails" method="post">

            <table>
                <tr>
                    <td><b>Technician Id:</b></td>
                    <td><input type="text" name="techid" value=''></td>
                </tr>
                <tr>
                    <td><b>Technician Name:</b></td>
                    <td><input type="text" name="techname" value=''></td>
                </tr>
                <tr>
                    <td><b>DepartMent ID:</b></td>
                    <td><input type="text" name="deptid" value=''></td>
                </tr>
            </table> 

            <button name="submitType" value="update" type="submit">Update</button>

        </form>
        <s:if test="ctr>0">
            <span style="color: red;"><s:property value="msg" /></span>
        </s:if>
        <s:else>
            <span style="color: red;"><s:property value="msg" /></span>
        </s:else>
    </body>
</html>

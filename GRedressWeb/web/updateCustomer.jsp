<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Update</title>
    </head>
    <body>
        <h2>UPDATE CUSTOMER</h2>
        <form action= "updateuser" method="post">

            <table>
                <tr>
                    <td><b>User Id:</b></td>
                    <td><input type="text" name="pid" value=''></td>
                </tr>
                <tr>
                    <td><b>Username:</b></td>
                    <td><input type="text" name="username" value='' placeholder="Change korte parbe na!" readonly></td>
                </tr>
                <tr>
                    <td><b>Password:</b></td>
                    <td><input type="text" name="password" value=''></td>
                </tr>
                <tr>
                    <td><b>First Name:</b></td>
                    <td><input type="text" name="firstname" value=''></td>
                </tr>
                <tr>
                    <td><b>Last Name:</b></td>
                    <td><input type="text" name="lastname" value=''></td>
                </tr>
                <tr>
                    <td><b>Address:</b></td>
                    <td><input type="text" name="address" value=''></td>
                </tr>
                <tr>
                    <td><b>email:</b></td>
                    <td><input type="text" name="email" value=''></td>
                </tr>
                <tr>
                    <td><b>Phone Number:</b></td>
                    <td><input type="text" name="phno" value=''></td>
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

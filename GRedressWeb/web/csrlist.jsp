<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Customer List</title>
        <style>
            table, td, th {border: 1px solid black;}
            table {border-collapse: collapse;width: 60%;}
            th {height: 30px;}
            .button-update {background-color: #008CBA;color: white;}
            .button-delete {background-color: red;color: white;}
        </style>
    </head>
    <body>
        <h2>Admin Customer List</h2>
        <div style="margin-top: 40px;">
            <s:if test="noData==false">
                <table>
                    <thead>
                        <tr style="background-color: #E0E0E1;">
                            <th>Customer id</th>
                            <th>Username</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                            <th>User Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <s:iterator value="csrList">
                        <tr>
                        <td><s:property value="pid"/></td>
                        <td><s:property value="username"/></td>
                        <td><s:property value="firstname"/></td>
                        <td><s:property value="lastname"/></td>
                        <td><s:property value="address"/></td>
                        <td><s:property value="email"/></td>
                        <td><s:property value="phno"/></td>
                        <td><s:property value="userstatus" /></td>
                        <td>
                            <a href=#>
                               <button class="button-update">Update</button>
                            </a>
                            <a href="deleteuser.action?pid=<s:property value="pid"/>">
                               <button class="button-delete">Delete</button>
                            </a>
                        </td>
                        </tr>
                    </s:iterator>
                </table>
            </s:if>
            <s:else>
                <div style="color: red;">No Data Found.</div>
            </s:else>
        </div>
    </body>
</html>
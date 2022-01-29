<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Customer dashboard</title>
        <style>
            table, td, th {
                border: 1px solid black;
            }
            table {
                border-collapse: collapse;
                width: 60%;
            }
            th {
                height: 30px;
            }
            .button-update {
                background-color: #008CBA;
                color: white;
            }
            .button-delete {
                background-color: red;
                color: white;
            }
        </style>
    </head>
    <body>
        <h2>Customer dashboard</h2>
        <div style="margin-top: 40px;">
            <s:if test="noData==false">
                <table>
                    <thead>
                        <tr style="background-color: #E0E0E1;">
                            <th>User Name</th>                            
                            <th>First name</th>
                            <th>Last name</th>
                            <th>address</th>       
                            <th>Email</th>                     
                            <th>Phone Number</th>
                        </tr>
                    </thead>
                    <s:iterator value="userList">
                        <tr>
                            <td><s:property value="username" /></td>
                            <td><s:property value="firstname" /></td>
                            <td><s:property value="lastname" /></td>
                            <td><s:property value="address" /></td>     
                            <td><s:property value="email" /></td>                                               
                            <td><s:property value="phno" /></td>
                            <td>

                                <a href="addcomplaint"><button class="button-report" type="button">Add Complaint</button></a>
                                <a href="addFeedback.action?complid=<s:property value="complid"/>">
                                    <button class="button-update">Add Feedback</button>
                                </a> 
                                <a href="viewcomplaint.action?complid=<s:property value="complid"/>">
                                    <button class="button-update">View Complaint</button>
                                </a> 
                                <a href="viewproductOwned.action?pid=<s:property value="pid"/>">
                                    <button class="button-update">View ProductOwned</button>
                                </a>
                                <a href="Viewproduct.action?pid=<s:property value="pid"/>">
                                    <button class="button-update">View Product</button>
                                </a>
                                <a href="customerDefects.action?pid=<s:property value="pid"/>">
                                    <button class="button-update">Customer defects</button>
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
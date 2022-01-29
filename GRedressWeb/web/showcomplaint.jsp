<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Show Complaints dashboard</title>
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
        <h2>Complaints dashboard</h2>
        <div style="margin-top: 40px;">
            <s:if test="noData==false">
                <table>
                    <thead>
                        <tr style="background-color: #E0E0E1;">
                            <th>pid</th>   
                            <th>complid</th>                            
                            <th>compltime</th>
                            <th>subject</th>
                            <th>description</th>       

                            <th>compl_status</th>
                            <th>startprog</th>
                            <th>ongoingprog</th>
                            <th>endprog</th>
                            <th>res_status</th>
                        </tr>
                    </thead>
                    <s:iterator value="complaintList">
                        <tr>
                            <td><s:property value="pid" /></td>       
                            <td><s:property value="complid" /></td>
                            <td><s:property value="compltime" /></td>
                            <td><s:property value="subject" /></td>
                            <td><s:property value="description" /></td>     
                            <td><s:property value="compl_status" /></td>
                            <td><s:property value="startprog" /></td>
                            <td><s:property value="ongoingprog" /></td>
                            <td><s:property value="endprog" /></td>
                            <td><s:property value="res_status" /></td>
                            <td>
                                <a href="Deletecomplaint.action?complid=<s:property value="complid"/>">
                                    <button class="button-update">Delete Complaint</button>
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
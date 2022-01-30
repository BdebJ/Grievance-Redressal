<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Report</title>
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
        <h2>Simple CURD Using STRUTS2 FRAMEWORK</h2>
        <div style="margin-top: 40px;">
            <s:if test="noData==false">
                <table>
                    <thead>
                        <tr style="background-color: #E0E0E1;">
                            <th>Complaint ID</th>
                            <th>First Name</th>

                            <th>Last Name</th>
                            <th>Complaint Time</th>
                            <th>Product Model</th>
                            <th>Product Name</th>
                            <th>Subject</th>
                            <th>Description</th>
                            <th>Technician ID</th>
                            <th>Tech Name</th>
                            <th>Complaint Status</th>
                            <th>Start Progress</th>
                            <th>Ongoing progress</th>
                            <th>End progress</th>
                            <th>Resolution Status</th>

                        </tr>
                    </thead>
                    <s:iterator value="complaintList">
                        <tr>
                            <td><s:property value="complid" /></td>
                            <td><s:property value="firstname" /></td>

                            <td><s:property value="lastname" /></td>
                            <td><s:property value="compltime" /></td>
                            <td><s:property value="prodmodel" /></td>
                            <td><s:property value="prodname" /></td>
                            <td><s:property value="subject" /></td>
                            <td><s:property value="description" /></td>
                            <td><s:property value="techid" /></td>
                            <td><s:property value="techname" /></td>
                            <td><s:property value="compl_status" /></td>
                            <td><s:property value="startprog" /></td>
                            <td><s:property value="ongoingprog" /></td>
                            <td><s:property value="endprog" /></td>
                            <td><s:property value="res_status" /></td>

                            <td>
                                <a href="ProductUpdate?submitType=updatedata&cusdefid=<s:property value="cusdefid"/>">
                                    <button class="button-update">Update</button>
                                </a>
                                <a href="deleterecord.action?productId=<s:property value="productId"/>">
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

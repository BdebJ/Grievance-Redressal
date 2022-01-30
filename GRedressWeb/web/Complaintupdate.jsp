<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Update</title>
    </head>
    <body>
        <h2>Update Complaints</h2>
        <style>
            input[type=text], select {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type=submit] {
                width: 100%;
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            buttton[type=submit]:hover {
                background-color: #45a049;
            }

            div {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }

        </style>
        <div>
            <form action="updateComplaint" method="post">

                <table>
                    <tr>
                        <td><b>Complaint ID</b></td>
                        <td><input type="text" name="complid" value='<s:property value="complid"/>'></td>
                    </tr>
                    <tr>
                        <td><b>Complaint Time</b></td>
                        <td><input type="text" name="compltime" value='<s:property value="compltime"/>'></td>
                    </tr>

                    <tr>
                        <td><b>Subject</b></td>
                        <td><input type="text" name="subject" value='<s:property value="subject"/>'></td>
                    </tr>
                    <tr>
                        <td><b>Description</b></td>
                        <td><input type="text" name="description" value='<s:property value="description"/>'></td>
                    </tr>
                    <tr>
                        <td><b>P id</b></td>
                        <td><input type="text" name="pid" value='<s:property value="pid"/>'></td>
                    </tr>
                    <tr>
                        <td><b>tech id</b></td>
                        <td><input type="text" name="techid" value='<s:property value="techid"/>'></td>
                    </tr>
                    <tr>
                        <td><b>Complaint Status</b></td>
                        <td><input type="text" name="compl_status" value='<s:property value="compl_status"/>'></td>
                    </tr>
                    <tr>
                        <td><b>Start progress</b></td>
                        <td><input type="text" name="startprog" value='<s:property value="startprog"/>'></td>
                    </tr>
                    <tr>
                        <td><b>ongoing progress</b></td>
                        <td><input type="text" name="ongoingprog" value='<s:property value="ongoingprog"/>'></td>
                    </tr>
                    <tr>
                        <td><b>end progress</b></td>
                        <td><input type="text" name="endprog" value='<s:property value="endprog"/>'></td>
                    </tr>
                    <tr>
                        <td><b>RES Status</b></td>
                        <td><input type="text" name="res_status" value='<s:property value="res_status"/>'></td>
                    </tr>
                </table> 

                <button name="submitType" value="update" type="submit">Update</button>

            </form>
        </div>
        <s:if test="ctr>0">
            <span style="color: red;"><s:property value="msg" /></span>
        </s:if>
        <s:else>
            <span style="color: red;"><s:property value="msg" /></span>
        </s:else>
    </body>
</html>
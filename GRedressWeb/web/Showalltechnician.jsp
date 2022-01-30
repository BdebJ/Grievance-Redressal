<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Report</title>
        <style>
            table, td, th {border: 1px solid black;}
            table {border-collapse: collapse;width: 60%;}
            th {height: 30px;}
            .button-update {background-color: #008CBA;color: white;}
            .button-delete {background-color: red;color: white;}
            div {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }
                        table, td, th {  
  border: 1px solid #ddd;
  text-align: left;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 10px;
}
        </style>
    </head>
    <body>
        <h2>Technicians</h2>
        <div style="margin-top: 40px;">
            <s:if test="noData==false">
                <table>
                    <thead>
                        <tr style="background-color: #E0E0E1;">
                          
                            
                            <th>Tech ID</th>
                            <th>Tech Name</th>
                            
                            
                        </tr>
                    </thead>
                    <s:iterator value="technician">
                        <tr>
                        <td><s:property value="techid" /></td>
                        <td><s:property value="techname" /></td>
                        
                        
                       
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


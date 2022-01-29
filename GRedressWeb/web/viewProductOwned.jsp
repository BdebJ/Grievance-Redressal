<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>View Product dashboard</title>
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
        <h2>Product dashboard</h2>
        <div style="margin-top: 40px;">
            <s:if test="noData==false">
                <table>
                    <thead>
                        <tr style="background-color: #E0E0E1;">
                            <th>product name</th>   
                            <th>product model</th> 
                        </tr>
                    </thead>
                    <s:iterator value="productList">
                        <tr>
                            <td><s:property value="prodname" /></td>       
                            <td><s:property value="prodmodel" /></td>
                           
                            
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
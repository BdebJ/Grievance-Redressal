<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<%
    response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
    if (request.getSession().getAttribute("validUser") == null) {
        String errormsg = "You are not logged in. Please login first!!";
        request.setAttribute("errormsg", errormsg);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    else if((Integer)request.getSession().getAttribute("roleid") != 1){
        String errormsg = "You are not logged in. Please login first!!";
        request.setAttribute("errormsg", errormsg);
        
        if(session!=null){  
        session.invalidate();
    }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link href="assets/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="navbar.jsp"/> 
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Update Product</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Update Product details by filling all the fields.</li>
                    </ol>

                    <s:if test="ctr>0">
                        <div class = "alert alert-success mt-2" role = "alert"><s:property value="msg" /></div>
                    </s:if>
                    <s:elseif test= "ctr==-1">
                        <div class = "alert alert-danger mt-2" role = "alert"><s:property value="msg" /></div>
                    </s:elseif>
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table me-1"></i>
                            Update Product
                        </div>

                        <div class="card-body">
                            <form action ="updateproductdetails" method ="post">
                                <div class="form-floating mb-3">
                                    <input class="form-control" id="pid" type="text" name ="prodid" placeholder="Product id" value='<s:property value="prodid"/>' readonly/>
                                    <label for="prodid">Poduct id</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <select class="form-control" name="deptid" required>
                                        <option value="" disabled selected><s:property value="deptname"/></option>
                                        <s:iterator value="departmentList">
                                            <option value="<s:property value="deptid"/>">
                                                <s:property value="deptname"/>
                                            </option>
                                        </s:iterator>
                                    </select>                                    
                                        <label for="deptid">Department Name</label>
                                </div>        

                                <div class="form-floating mb-3">
                                    <input class="form-control" id="prodname" type="text" name="prodname" placeholder="prodname"value='<s:property value="prodname"/>' />
                                    <label for="prodname">Product Name</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <input class="form-control" id="address" name="prodmodel" type ="text"  placeholder="prodmodel" value='<s:property value="prodmodel"/>'/>
                                    <label for="prodmodel">Product Model</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <select class="form-control" name="prodstatus" id="prodstatus" required>
                                        <option value="0">Inactive</option>
                                        <option value="1">Active</option> 
                                    </select>                                                
                                    <label for="prodstatus">Product Status</label>
                                </div>



                                <div class="mt-4 mb-0">
                                    <div class="d-grid"><input type = "submit" class="btn btn-primary btn-block" name="submitType" value="Update Product"></div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </main>
            <jsp:include page="footer.jsp"/>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="assets/js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="assets/js/datatables-simple-demo.js"></script>
</body>
</html>

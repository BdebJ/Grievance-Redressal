<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<%
    response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
    if (request.getSession().getAttribute("validUser") == null) {
        String errormsg = "You are not logged in. Please login first!!";
        request.setAttribute("errormsg", errormsg);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    else if((Integer)request.getSession().getAttribute("roleid") != 2){
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
        <title>Customers</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="navbarCSR.jsp"/> 
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Customers</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">View Departments</li>
                    </ol>

                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">

                        <!--                        <div class="btn-group me-4">
                                                    <a href="showcomplaintsforadmin"><button type="button" class="btn btn-sm btn-outline-primary active"><i class='fa fa-user'></i>All Complaints</button></a>
                                                    <a href="showresolvedcomplaints"><button type="button" class="btn btn-sm btn-outline-success"><i class='fa fa-check'></i> Resolved Complaints</button></a>
                                                    <a href="showunresolvedcomplaints"><button type="button" class="btn btn-sm btn-outline-warning"><i class='fa fa-clock'></i> Unresolved Complaints</button></a>
                                                    <a href="showrejectedcomplaints"><button type="button" class="btn btn-sm btn-outline-danger"><i class='fa fa-ban'></i> Rejected Complaints</button></a>
                        
                                                </div>-->
                        <div class="btn-toolbar mb-2 mb-md-0">

                            <!--<a href="addTechnician.jsp"><button type="button" class="btn btn-sm btn-outline-secondary">Add Product</button></a>-->
                        </div>
                    </div>
                    <s:if test="ctr>0">
                        <div class = "alert alert-success mt-2" role = "alert"><s:property value="msg" /></div>
                    </s:if>
                    <s:elseif test= "ctr==-1">
                        <div class = "alert alert-danger mt-2" role = "alert"><s:property value="msg" /></div>
                    </s:elseif>

                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table me-1"></i>
                            Customers
                        </div>
                        <div class="card-body">
                            <s:if test="noData==false">
                                <table id="datatablesSimple">
                                    <thead >
                                        <tr style="background-color: #E0E0E1;">
                                            <th>Customer id</th>
                                            <th>Username</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th style="width:10%">Address</th>
                                            <th style="width:20%">Email</th>
                                            <th>Phone Number</th>
                                            <th>User Status</th>

                                        </tr>
                                    </thead>
                                    <s:iterator value="customerList">
                                        <tr>
                                            <td><s:property value="pid"/></td>
                                            <td><s:property value="username"/></td>
                                            <td><s:property value="firstname"/></td>
                                            <td><s:property value="lastname"/></td>
                                            <td><s:property value="address"/></td>
                                            <td><s:property value="email"/></td>
                                            <td><s:property value="phno"/></td>
                                            <s:if test ="userstatus == 1"><td>Active</td> </s:if>
                                            <s:elseif test ="userstatus==0"><td>Inactive</td></s:elseif>
                                                <!--  <td>
                                                      <a href=#>
                                                          <button class="button"><span>Update</span></button>
                                                      </a>
                                                      <a href="deleteuser.action?pid=<s:property value="pid"/>">
                                                          <button class="button" ><span>Delete</span></button>
                                                      </a>
                                                  </td>--->
                                        </tr>
                                    </s:iterator>
                                </table>
                            </s:if>
                            <s:else>
                                <div style="color: red;">No Data Found.</div>
                            </s:else>
                        </div>
                    </div>
                </div>
            </main>
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid px-4">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; Your Website 2021</div>
                        <div>
                            <a href="#">Privacy Policy</a>
                            &middot;
                            <a href="#">Terms &amp; Conditions</a>
                        </div>
                    </div>
                </div>
            </footer>
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

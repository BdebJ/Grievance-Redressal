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
        
        <!--Navbar-->
        <jsp:include page="navbar.jsp"/> 
        
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Add CSR</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Add CSR</li>
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
                                Add CSR
                            </div>
                            
                            <div class="card-body">
                                <form action ="addcsr" method ="post">
                                    <div class="form-floating mb-3">
                                                <input class="form-control" id="username" type="text" name ="username" placeholder="username" required/>
                                                <label for="username">Username</label>
                                            </div>        
                                    <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name ="firstname" id="firstname" type="text" placeholder="Enter your first name" required />
                                                        <label for="firstname">First name</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" name ="lastname" id="firstname" type="text" placeholder="Enter your last name" required/>
                                                        <label for="lastname">Last name</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputEmail" type="email" name="email" placeholder="name@example.com" required/>
                                                <label for="emai;">Email address</label>
                                            </div>
                                    <div class="form-floating mb-3">
                                                <input class="form-control" id="address" name="address" type ="text"  placeholder="adreess" required/>
                                                <label for="address">Address</label>
                                            </div>
                                    <div class="form-floating mb-3">
                                                <input class="form-control" id="inputEmail" type="text" name ="phno" placeholder="Phone Number" required/>
                                                <label for="phno">Phone Number</label>
                                            </div>
                                    
                                            
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><input type = "submit" class="btn btn-primary btn-block" value="Add CSR"></a></div>
                                            </div>
                                        </form>
                                 
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

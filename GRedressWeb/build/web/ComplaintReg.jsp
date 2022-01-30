<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>CUSTOMER Dashboard </title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="assets/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="customer_dashboard.jsp">Welcome ${user.firstname}</a>

            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">

                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading"></div>
                            
                            <div id="layoutSidenav_nav">
                                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                                    <div class="sb-sidenav-menu">
                                        <div class="nav">
                                            <div class="sb-sidenav-menu-heading"></div>
                                            <a class="nav-link" href="customer_dashboard.jsp">
                                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                                Home
                                            </a>
                                            <a class="nav-link" href="ComplaintReg.jsp">
                                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                                Add Grievance
                                            </a>
                                            <a class="nav-link" href="#">
                                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                                Remove Grievance
                                            </a>
                                            <a class="nav-link" href="Feedback.jsp">
                                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                                Add Feedback
                                            </a>
                                        </div>

                                    </div>
                                    <div class="sb-sidenav-footer">
                                        <div class="small">Logged in as:</div>
                                        ${user.username}
                                    </div>
                                </nav>
                            </div>



                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        ${user.username}
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container">
                        <div class="container">
                            <h1>Add a Complaint:</h1>
                            <div class="card">
                                <div class="card-body">
                                    <form action="addcomplaint.action" method="post">

                                        <div class="form-group row">
                                            <label for="compltime" class="col-sm-2 col-form-label">Complaint Time</label>
                                            <div class="col-sm-7">
                                                <input type="text" class="form-control" name="compltime"
                                                       placeholder="Enter Complaint time">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="subject" class="col-sm-2 col-form-label">Complaint Subject</label>
                                            <div class="col-sm-7">
                                                <input type="text" class="form-control" name="subject"
                                                       placeholder="Enter Complaint Subject">
                                            </div>
                                        </div>

                                        <div class=" form-group row">
                                            <label for="description" class="col-sm-2 col-form-label">Complaint Description</label>
                                            <div class="col-sm-7">
                                                <input type="text" class="form-control" name="description"
                                                       placeholder="Enter Complaint Description">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="pid" class="col-sm-2 col-form-label">Pid</label>
                                            <div class="col-sm-7">
                                                <input type="text" class="form-control" name="pid"
                                                       placeholder="Enter Pid">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="ownid" class="col-sm-2 col-form-label">Owned Product</label>
                                            <div class="col-sm-7">
                                                <input type="text" class="form-control" name="ownid"
                                                       placeholder="Enter Owned Product">
                                            </div>
                                        </div>



                                        <button type="submit" class="btn btn-primary">Submit Complaint</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <s:if test="ctr>0">
                            <span style="color: green;"><s:property value="msg" /></span>
                        </s:if>
                        <s:else>
                            <span style="color: red;"><s:property value="msg" /></span>
                        </s:else>
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

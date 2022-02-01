<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">Welcome CSR</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
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
                        <li><a class="dropdown-item" href="login.jsp">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="csr_dashboard.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Services
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cusdefects">customer defects</a>
                                    <a class="nav-link" href="complaint.action">Complaint</a>
                                    <a class="nav-link" href="department.action">Department</a>
                                    <a class="nav-link" href="customer.action">Customer</a>
                                </nav>
                            </div>

                            <div class="sb-sidenav-footer">
                                <div class="small">Logged in as:</div>
                                CSR
                            </div>
                            </nav>
                        </div>
                        <div id="layoutSidenav_content">
                            <main>
                                <div class="container-fluid px-4">
                                    <h1 class="mt-4">Dashboard</h1>
                                    <ol class="breadcrumb mb-4">
                                        <li class="breadcrumb-item active">Dashboard</li>
                                    </ol>
                                    <div class="row">
                                        <div class="col-xl-3 col-md-6">
                                            <div class="card bg-primary text-white mb-4">
                                                <div class="card-body">Customers</div>
                                                <div class="card-footer d-flex align-items-center justify-content-between">
                                                    <a class="small text-white stretched-link" href="customer">View Details</a>
                                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xl-3 col-md-6">
                                            <div class="card bg-warning text-white mb-4">
                                                <div class="card-body">Department</div>
                                                <div class="card-footer d-flex align-items-center justify-content-between">
                                                    <a class="small text-white stretched-link" href="department">View Details</a>
                                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xl-3 col-md-6">
                                            <div class="card bg-success text-white mb-4">
                                                <div class="card-body">Customer Defects</div>
                                                <div class="card-footer d-flex align-items-center justify-content-between">
                                                    <a class="small text-white stretched-link" href="cusdefects">View Details</a>
                                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xl-3 col-md-6">
                                            <div class="card bg-danger text-white mb-4">
                                                <div class="card-body">Complaints</div>
                                                <div class="card-footer d-flex align-items-center justify-content-between">
                                                    <a class="small text-white stretched-link" href="complaint">View Details</a>
                                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <style>
                                        table, td, th {border: 0.5px solid black;}
                                        table {border-collapse: collapse;width: 100%;}
                                        th {height: 10px;}
                                        .button {background-color: #008CBA;color: white;}
                                        .button-delete {background-color: red;color: white;}
                                    </style>
                                    <style>



                                        .button span {
                                            cursor: pointer;
                                            display: inline-block;
                                            position: relative;
                                            transition: 0.5s;
                                        }

                                        .button span:after {
                                            content: '\00bb';
                                            position: absolute;
                                            opacity: 0;
                                            top: 0;
                                            right: -20px;
                                            transition: 0.5s;
                                        }

                                        .button:hover span {
                                            padding-right: 25px;
                                        }

                                        .button:hover span:after {
                                            opacity: 1;
                                            right: 0;
                                        }
                                    </style>
                                    <div class="card mb-4">
                                        <div class="card-header">
                                            <i class="fas fa-table me-1"></i>
                                            DataTable Example
                                        </div>
                                        <div class="card-body">
                                            <s:if test="noData==false">
                                                <table id="datatablesSimple">
                                                    <thead>
                                                        <tr style="background-color: #E0E0E1;">
                                                            <th>Complaint id</th>
                                                            <th>Complaint Time</th>
                                                            <th>Subject</th>
                                                            <th>Description</th>
                                                            <th>Customer id</th> 
                                                            <th>Customer Name</th> 
                                                            <th>Product Name</th> 
                                                            <th>Product Model</th>
                                                            <th>Technician Id</th>
                                                            <th>Technician Name</th> 
                                                            <th>Complaint Status</th>
                                                            <th>Resolution Status</th>

                                                        </tr>
                                                    </thead>
                                                    <s:iterator value="csrcomplaintList">
                                                        <tr>
                                                            <td><s:property value="complid"/></td>
                                                            <td><s:property value="compltime"/></td>
                                                            <td><s:property value="subject"/></td>
                                                            <td><s:property value="description"/></td>
                                                            <td><s:property value="pid"/></td>
                                                            <td><s:property value="firstname"/> <s:property value="lastname"/></td>
                                                            <td><s:property value="prodname"/></td>
                                                            <td><s:property value="prodmodel"/></td>
                                                            <td><s:property value="techid"/></td>
                                                            <td><s:property value="techname"/></td>
                                                            <s:if test="compl_status==0"><td> Initiated </td> </s:if>
                                                            <s:elseif test="compl_status==1"> <td> Accepted </td> </s:elseif>
                                                            <s:else> <td> Rejected </td> </s:else>
                                                            <s:if test="res_status==0"><td> Unresolved </td> </s:if>
                                                            <s:else> <td> Resolved </td> </s:else>


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

<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, shrink-to-fit=no, user-scalable=no">
        <title> My Grievances</title>

        <link rel="shortcut icon" href="assets/images/fav.jpg">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/fontawsom-all.min.css">
        <link rel="stylesheet" href="assets/plugins/image-hover/imagehover.min.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css" />
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link href="assets/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>

    </head>

    <body>
        <!--Navbar -->
        <jsp:include page="navbarCustomer.jsp"/> 



        <!--###################### Slider Starts Here ############################-->

        <div class="page-title titl-2">
            <div class="container">
                <div class="row">
                    <h2>My Grievances</h2>
                    <p> Home <i class="fas fa-angle-double-right"></i> My Grievances </p>
                </div>
            </div>
        </div>








        <!--###################### About Company Starts Here ############################-->
        <section class="with-medical">
            <div class="container">
                <div class="row">
                   
                     <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table me-1"></i>
                            Grievance List
                        </div>

                        <div class="card-body">
                            <table id="datatablesSimple">
                                <thead>
                                    <tr>
                       
                                        <th>Complaint Time</th>
                                        <th>Product</th>
                                        <th>Model</th>
                                        <th>Subject</th>
                                        <th>Description</th>
                                        <th>Technician</th>
                                        <th>Progress</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tfoot>

                                    <tr>
                               
                                        <th>Complaint Time</th>
                                        <th>Product</th>
                                        <th>Model</th>
                                        <th>Subject</th>
                                        <th>Description</th>
                                        <th>Technician</th>
                                        <th>Progress</th>
                                        <th>Status</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <s:iterator value="complaintList">
                                        <tr>
                                       
                                            <td><s:property value="compltime"/></td>
                                            <td><s:property value="prodname"/></td>
                                            <td><s:property value="prodmodel"/></td>
                                            <td><s:property value="subject"/></td>
                                            <td><s:property value="description"/></td>
                                            <td><s:property value="techname"/></td>
                                            <td><s:property value="endprog" /></td>
                                            <s:if test="res_status==0"><td> Unresolved </td> </s:if>
                                            <s:else> <td> Resolved </td> </s:else>
                                                
                                            <!--<td><s:property value="res_status" /></td>-->
                                            

                                        </tr>
                                    </s:iterator>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--###################### Key Features Starts Here ##########################-->
        <div class="key-features container-fluid">
            <div class="container">
                <div class="session-title row">
                    <h2>Key Features</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse venenatis magna odio, eu vehicula augue suscipit ac. Pellentesque quis dui lorem. </p>
                </div>
                <div class="key-row row">
                    <div class="col-md-3">
                        <div class="key-single">
                            <i class="fas fa-fingerprint"></i>
                            <h6>High Security</h6>
                            <p>Sed ligula eros, convallis sit amet ullamcorper sit amet, consequat vel nulla. Maecenas quis convallis dolor. Ut enim lacus, aliquet at neque et,</p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="key-single">
                            <i class="fas fa-user-lock"></i>
                            <h6>Full Device Protection</h6>
                            <p>Sed ligula eros, convallis sit amet ullamcorper sit amet, consequat vel nulla. Maecenas quis convallis dolor. Ut enim lacus, aliquet at neque et,</p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="key-single">
                            <i class="fas fa-video"></i>
                            <h6>Remote Monitoring</h6>
                            <p>Sed ligula eros, convallis sit amet ullamcorper sit amet, consequat vel nulla. Maecenas quis convallis dolor. Ut enim lacus, aliquet at neque et,</p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="key-single">
                            <i class="far fa-folder-open"></i>
                            <h6>Full Backup of Information</h6>
                            <p>Sed ligula eros, convallis sit amet ullamcorper sit amet, consequat vel nulla. Maecenas quis convallis dolor. Ut enim lacus, aliquet at neque et,</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <!--###################### Footer Starts Here ############################-->

        <!--Navbar -->
        <jsp:include page="footerCustomer.jsp"/> 


    </body>
    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="assets/plugins/scroll-nav/js/jquery.easing.min.js"></script>
    <script src="assets/js/script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="assets/js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="assets/js/datatables-simple-demo.js"></script>


</html>
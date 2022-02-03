<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="sessionValidation.jsp"/>
<jsp:useBean id="date" class="java.util.Date" />
<!doctype html>

<%
    response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
    if (request.getSession().getAttribute("validUser") == null) {
        String errormsg = "You are not logged in. Please login first!!";
        request.setAttribute("errormsg", errormsg);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    else if((Integer)request.getSession().getAttribute("roleid") != 3){
        String errormsg = "You are not logged in. Please login first!!";
        request.setAttribute("errormsg", errormsg);
        
        if(session!=null){  
        session.invalidate();
    }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, shrink-to-fit=no, user-scalable=no">
        <title>Register a Grievance</title>

        <link rel="shortcut icon" href="assets/images/fav.jpg">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/fontawsom-all.min.css">
        <link rel="stylesheet" href="assets/plugins/image-hover/imagehover.min.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css" />
    </head>

    <body>

        <!--Navbar -->
    <jsp:include page="navbarCustomer.jsp"/> 

        <!--###################### Slider Starts Here ############################-->

        <div class="page-title titl-2">
            <div class="container">
                <div class="row">
                    
                    <h2>Register Your Grievance</h2>
                    <p> Home <i class="fas fa-angle-double-right"></i> Add Grievance </p>
                </div>
            </div>
        </div>


        <div class="row contact-rooo no-margin">
            <div class="container">
                <div class="row">

                     
                    <div style="padding:20px" class="col-sm-7">
                        
                        <h2 style="font-size:18px">Register Grievance</h2>
                        <form action="addcomplaint.action" method="post">
                        <div class="row cont-row">
                            
                            <div class="col-sm-8"><input type="hidden" class="form-control" name="compltime"
                                                         placeholder="Enter Complaint time" value='${date}' readonly> </div>
                        </div>
                        <div  class="row cont-row">
                            <div  class="col-sm-3"><label>Subject </label><span>:</span></div>
                            <div class="col-sm-8"><input type="text" class="form-control" name="subject"
                                                         placeholder="Enter Complaint Subject"></div>
                        </div>
                        <div  class="row cont-row">
                            <div  class="col-sm-3"><label>Description</label><span>:</span></div>
                            <div class="col-sm-8">
                                <textarea rows="5" placeholder="Describe You Problem" name="description" class="form-control input-sm"></textarea>
                            </div>
                        </div>
                        <div  class="row cont-row">
                            <div  class="col-sm-3"><label>Owned Id</label><span>:</span></div>
                            <div class="col-sm-8">
                                <select class="form-control" name="ownid" required>
                                        <option value="" disabled selected>Select Product</option>
                                        <s:iterator value="ProductOwnedList">
                                            <option value="<s:property value="ownid"/>">
                                                <s:property value="prodname"/>
                                                </option>
                                        </s:iterator>
                                    </select>
                                    </div>
                        </div>

                        <div style="margin-top:10px;" class="row">
                            <div style="padding-top:10px;" class="col-sm-3"><label></label></div>
                            <div class="col-sm-8">
                                <button type = "submit" class="btn btn-success btn-sm">Submit</button>
                                  <s:if test="ctr>0">
                        <div class = "alert alert-success mt-2" role = "alert"><s:property value="msg" /></div>
                    </s:if>
                    <s:elseif test= "ctr==-1">
                        <div class = "alert alert-danger mt-2" role = "alert"><s:property value="msg" /></div>
                    </s:elseif>
                            </div>
                            <div class="col-sm-8">
                           
                            </div>
                        </div>
                            </form>
                    </div>
                         
                    <div class="col-sm-5">

                        <div style="margin:50px" class="serv"> 





                            <h5 style="margin-top:10px;">Register Your Grievance </h5>

                            Fill all the required Details <br>
                           Then simply Submit the form<br><br>
                           Our Technician will get in touch within 24 hours<br><br>
                            for further queries<br>
                            write us on<br> group-b_grievance@group-b.com<br>
                            







                        </div>    


                    </div>

                </div>
            </div>

        </div>

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
  <!--Footer -->
    <jsp:include page="footerCustomer.jsp"/>

    </body>
    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="assets/plugins/scroll-nav/js/jquery.easing.min.js"></script>
    <script src="assets/js/script.js"></script>


</html>
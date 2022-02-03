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
    <title> About us</title>

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
                <h2>About Us</h2>
                <p> Home <i class="fas fa-angle-double-right"></i> About US </p>
            </div>
        </div>
    </div>





    
    

    <!--###################### About Company Starts Here ############################-->
    <section class="with-medical">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-12">
                    <img src="assets/images/about.jpg" alt="">
                </div>
                <div class="col-lg-6 col-md-12 txtr">
                    <h4>About us <br>
                        <span>Online Grievance Redressal</span>
                    </h4>
                    <p>
Grievance Redressal System is an online platform to receive and act on complaints 
reported by our customers , 
enabling prompt actions on any issue raised by them and to avail services more effectively. 
                   Once you raised your complaint our technician will get in touch with you within next 24 hours
                    <br>  </p>
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


</html>
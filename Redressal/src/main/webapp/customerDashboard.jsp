<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="sessionValidation.jsp"/>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, shrink-to-fit=no, user-scalable=no">
    <title> Online Grievance Redressal System</title>

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
<!--slider -->
    <jsp:include page="sliderCustomer.jsp"/>
<!--services -->
    <jsp:include page="servicesCustomer.jsp"/>
<!--about -->
    <jsp:include page="aboutCompany.jsp"/>

    
    

    <!--###################### Key Features Starts Here ##########################-->
    <div class="key-features container-fluid">
        <div class="container">
            <div class="session-title row">
                <h2>Key Features</h2>
                <p> These are the key features of Smart Security </p>
            </div>
            <div class="key-row row">
                <div class="col-md-3">
                    <div class="key-single">
                        <i class="fas fa-fingerprint"></i>
                        <h6>High Security</h6>
                        <p>Make yourself highly secured with our Devices ,Once you purchase our device your security will be maintained by our devices.</p>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="key-single">
                        <i class="fas fa-user-lock"></i>
                        <h6>Full Device Protection</h6>
                        <p>The Complete Device Protection is a 365 day complete post-purchase solution with personalized door-to-door service.We provide the complete Device protection for 2 years when you purchase a device from us.</p>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="key-single">
                        <i class="fas fa-video"></i>
                        <h6>Remote Monitoring</h6>
                        <p>Remote Monitoring (RMON) is a standard specification that facilitates the monitoring of network operational activities through the use of remote devices known as monitors or probes.</p>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="key-single">
                        <i class="far fa-folder-open"></i>
                        <h6>Full Backup of Information</h6>
                        <p>A full backup is the process of creating one or more copies of all organizational data files in a single backup operation to protect them.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--###################### Testimonial Starts Here ############################-->
    <div class="testimonial-cover container-fluid">
        <div class="container test-container">
            <div class="session-title row">
                <h2>Testimonial</h2>
                <p>These are the developers of our website </p>
            </div>
            <div class="test-row row">
                <div class="col-md-3">
                    <div class="test-key">
                        <img src="assets/images/testimonial/pallab.jpg" alt="">

                        <h5>Pallab Tewary</h5>
                        <a href="">Developer</a>

                        <p><i>Hello! This is Pallab Tewary , Pursuing MCA , Worked in this Project as a Developer</i></p>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="test-key">
                        <img src="assets/images/testimonial/anirban.jpg" alt="">

                        <h5>Anirban Das</h5>
                        <a href="">Developer</a>

                        <p>Hello! This is Anirban Das , Pursuing MCA , Worked in this Project as a Developer</p>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="test-key">
                        <img src="assets/images/testimonial/isita.jpg" alt="">

                        <h5>Isita Ghosh</h5>
                        <a href="">Developer</a>

                        <p>Hello! This is Isita Ghosh , Pursuing MCA , Worked in this Project as a Developer</p>
                    </div>
                </div>
                
                <div class="col-md-3">
                    <div class="test-key">
                        <img src="assets/images/testimonial/buddha.jpg" alt="">

                        <h5>Buddhadeb Jena</h5>
                        <a href="">Developer</a>

                        <p>Hello! This is Buddhadeb Jena , Pursuing Btech , Worked in this Project as a Developer</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--###################### Client Details Starts Here ############################-->
    <div class="client-container container-fluid">
        <div class="container">
            <div class="row client-row">
                <div class="col-md-3 col-6 br bb clinent-cover">
                    <img src="assets/images/partner/l1.png" alt="">
                </div>
                <div class="col-md-3 col-6 br bb clinent-cover">
                    <img src="assets/images/partner/l2.png" alt="">
                </div>
                <div class="col-md-3 col-6 br bb clinent-cover">
                    <img src="assets/images/partner/l3.png" alt="">
                </div>
                <div class="col-md-3 col-6 bb clinent-cover">
                    <img src="assets/images/partner/l5.png" alt="">
                </div>
                <div class="col-md-3 col-6 br clinent-cover">
                    <img src="assets/images/partner/l5.png" alt="">
                </div>
                <div class="col-md-3 col-6 br clinent-cover">
                     <img src="assets/images/partner/l3.png" alt="">
                </div>
                <div class="col-md-3 col-6 br clinent-cover">
                     <img src="assets/images/partner/l2.png" alt="">
                </div>
                <div class="col-md-3 col-6 clinent-cover">
                    <img src="assets/images/partner/l1.png" alt="">
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
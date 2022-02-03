<!--###################### Navigation Starts Here ############################-->

<div class="header-container">
    <div class="header-top">
        <div class="container">
            <div class="row">
                <div class="col-lg-7 col-md-12 left-item">
                    <!--                        <ul>
                                                <li><i class="fas fa-envelope-square"></i> sales@smarteyeapps.dcom</li>
                                                <li class="d-none d-sm-block"><i class="fas fa-phone-square"></i> +123 987 887 765</li>
                                            </ul>-->
                </div>
                <div class="col-lg-5 d-none d-lg-block right-item">

                    <ul>

                        <!--                       
                                                <div class="nav-item dropdown">
                                                       <li> <a href ="#" data-toggle = "dropdown" class="nav-item nav-link dropdown-toggle user-action" aria-expanded = "false">Pallab</a> 
                                                        <div class = "dropdown-menu">
                                                        <a href="#" class="dropdown-item">a</a>
                                                        <a href="#" class="dropdown-item">b</a>
                                                        <a href="#" class="dropdown-item">c</a>
                                                        </div>
                                                </div>-->
                        </li>
                        <li>Hi,  ${sessionScope.validUser.getFirstname()}</li>
                        <li><a href="logout"><p style="color: white"><i class="fa fa-sign-out-alt"></i> Signout</p></a></li>
                        <!--                            <li><a><i class="fab fa-linkedin-in"></i></a></li>
                                                    <li> <a><i class="fab fa-pinterest-p"></i></a></li>
                                                    <li><a><i class="fab fa-twitter"></i></a></li>
                                                    <li> <a><i class="fab fa-facebook-f"></i></a></li>-->
                    </ul>
                </div>
            </div>

        </div>
    </div>
    <nav id="menu-jk" class="container-fluid  no-padding">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-12 logo">
                    <img class="log" src="assets/images/logo.png" alt="">
                    <img class="log-gray" src="assets/images/logo-gray.png" alt="">
                    <a data-toggle="collapse" data-target="#nav-head" href="#nav-head"><i class="fas d-block d-md-none small-menu fa-bars"></i></a>
                </div>
                <div id="nav-head" class="col-md-9 nav-div d-none d-md-block">
                    <ul>
                        <li><a class="js-scroll-trigger" href="customerdashboard">Home</a></li>

                        <li class="yc"><a class="js-scroll-trigger" href="ProductOwnedList">Add Grievance</a></li>
                        <li><a class="js-scroll-trigger" href="complaintpid">My Grievances</a></li>
                        <li><a class="js-scroll-trigger" href="aboutUs.jsp">About Us</a></li>
                        <li><a class="js-scroll-trigger" href="contactUs.jsp">Contact Us</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</div>


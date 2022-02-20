<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
    if (request.getSession().getAttribute("validUser") == null) {
        String errormsg = "You are not logged in. Please login first!!";
        request.setAttribute("errormsg", errormsg);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    else if((Integer)request.getSession().getAttribute("roleid") != 1 && (Integer)request.getSession().getAttribute("roleid") != 2 ){
        String errormsg = "You are not logged in. Please login first!!";
        request.setAttribute("errormsg", errormsg);
        
        if(session!=null){  
        session.invalidate();
    }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>

<html>
    <head>
        <meta charset='utf-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link href="assets/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
        <title>Edit Profile</title>
        <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css' rel='stylesheet'>
        <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/fontawesome.min.css">
        
        <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->
        <script type="text/javascript">

            function checkUsername(username)
            {
            	var currUsername = '${sessionScope.validUser.getUsername()}';
            	
                var username = document.getElementById("username").value;
                if(currUsername == username){
                
                	$('#update').attr("disabled",false);
                	return;
                }
                $.ajax({
                    url: 'checkUsername',
                    method: "POST",
                    data: {username: username},
                    success: function (data) {
                    	if(!data.noData){                
                    	    $('#availability').html('<span style="font-size: 80%; color: red;"><i class="fa fa-times"></i> username already exist</span>');        
                    	    $('#update').attr("disabled",true);
                    	   }
                    	   else{   
                    	     $('#availability').html('<span style="font-size: 100%; color: green;"><i class="fa fa-check"></i> username available</span>');
                    	     $('#update').attr("disabled",false);
                    	  }
                    	
                    },
                    error: function (jqXHR, exception) {
                        console.log('Error occured!!');
                        var h = "Error";
                        alert(h);
                    }
                });

                }
                </script>
        <style>

            .form-control:focus {
                box-shadow: none;
                border-color: #BA68C8
            }

            .profile-button {
                background: #BA68C8;
                box-shadow: none;
                border: none
            }

            .profile-button:hover {
                background: #682773
            }

            .profile-button:focus {
                background: #682773;
                box-shadow: none
            }

            .profile-button:active {
                background: #682773;
                box-shadow: none
            }

            .back:hover {
                color: #682773;
                cursor: pointer
            }
            .tabs {
                display: flex;
                flex-wrap: wrap;
                max-width: 100%;
                font-family: sans-serif;
            }

            .tabs__label {
                padding: 10px 16px;
                cursor: pointer;
            }

            .tabs__radio {
                display: none;
            }

            .tabs__content {
                order: 1;
                width: 100%;
                border-bottom: 3px solid #dddddd;
                line-height: 1.5;
                font-size: 0.9em;
                display: none;
            }

            .tabs__radio:checked + .tabs__label {
                font-weight: bold;
                color: #009578;
                border-bottom: 2px solid #009578;
            }

            .tabs__radio:checked + .tabs__label + .tabs__content {
                display: initial;
            }
.field-icon {
  float: right;
  margin-left: -25px;
   margin-right: 15px;
  margin-top: -35px;
  position: relative;
  z-index: 2;
}
        </style>
    </head>
    <body oncontextmenu='return false' class="sb-nav-fixed">
        <%if((Integer)request.getSession().getAttribute("roleid") == 1){%> 
        <jsp:include page="navbar.jsp"/>
        <%} else if((Integer)request.getSession().getAttribute("roleid") == 2){%>
        <jsp:include page="navbarCSR.jsp"/>
        <%}%>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Edit Profile</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Update your profile</li>
                    </ol>
                    
                    <div class="tabs">
                        <input type="radio" class="tabs__radio" name="tabs-example" id="tab1" checked>
                        <label for="tab1" class="tabs__label">Profile</label>
                        <div class="tabs__content">
                                <div class="row">
                                    <div class="col-md-4 border-right">
                                        <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" src="assets/images/profile.png" width="90">
                                            <span class="font-weight-bold">${sessionScope.validUser.getFirstname()} ${sessionScope.validUser.getLastname()}</span>
                                            <span class="text-black-50">${sessionScope.validUser.getEmail()}</span>
                                            <span class="text-black-50">Hello This is ${sessionScope.validUser.getFirstname()} Currently <%if((Integer)request.getSession().getAttribute("roleid") == 1){%> an Admin <%} else{%> a CSR <%}%> of this web page.
                                            </span>

                                        </div>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="p-3 py-5">
                                            <s:if test="ctr>0">
                                                <div class = "alert alert-success mt-2" role = "alert"><s:property value="msg" /></div>
                                            </s:if>
                                            <s:elseif test= "ctr==-1">
                                                <div class = "alert alert-danger mt-2" role = "alert"><s:property value="msg" /></div>
                                            </s:elseif>
                                            <div class="d-flex justify-content-between align-items-center mb-3">
                                                <div class="d-flex flex-row align-items-center back"><i class="fa fa-arrow-left mr-1 mb-1"></i>
                                                    <%if((Integer)request.getSession().getAttribute("roleid") == 1){%><a href="admindashboard"><%} else{%><a href="csrdashboard"><%}%><h6 style="color:black">Back to Dashboard</h6></a>
                                                </div>
                                            </div>
                                            <div class="card-body">
                                                <form action="editprofile" method ="post">
                                                    <div class="form-floating mb-3">
                                                        <input class="form-control" id="username" name="username" type="text" value="${sessionScope.validUser.getUsername()}" placeholder="username" onkeyup="checkUsername(username)" />
                                                        <input class="form-control" id="pid" type="hidden" value="${sessionScope.validUser.getPid()}" name ="pid" />
                                                        <label for="username">Username </label>
                                                         <span id="availability"></span>
                                                    </div>
                                                   
                                                    <%-- <span style="font-size: 80%; color: grey;">username can't be changed right now.</span> --%>
                                                   
                                                    <div class="row mb-3">
                                                        <div class="col-md-6">
                                                            <div class="form-floating mb-3 mb-md-0">
                                                                <input class="form-control" name ="firstname" id="firstname" value="${sessionScope.validUser.getFirstname()}" type="text" placeholder="Enter your first name" />
                                                                <label for="firstname">First name</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-floating">
                                                                <input class="form-control" name ="lastname" id="lastname" value="${sessionScope.validUser.getLastname()}" type="text" placeholder="Enter your last name" />
                                                                <label for="lastname">Last name</label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-floating mb-3">
                                                        <input class="form-control" id="email" value="${sessionScope.validUser.getEmail()}" type="email" name="email" placeholder="name@example.com" />
                                                        <label for="emai;">Email address</label>
                                                    </div>
                                                    <div class="form-floating mb-3">
                                                        <input class="form-control" id="address" name="address" value="${sessionScope.validUser.getAddress()}" type ="text"  placeholder="adreess" />
                                                        <label for="address">Address</label>
                                                    </div>
                                                    <div class="form-floating mb-3">
                                                        <input class="form-control" id="inputEmail" type="number" value="${sessionScope.validUser.getPhno()}" name ="phno" placeholder="Phone Number" />
                                                        <label for="phno">Phone Number</label>
                                                    </div>


                                                    <div class="mt-4 mb-0">
                                                        <div class="d-grid"><input type = "submit" class="btn btn-primary btn-block" id="update" name='update' value="Update Profile"></div>
                                                    </div>
                                                </form>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                        </div>
                    
                    <input type="radio" class="tabs__radio" name="tabs-example" id="tab2">
                    <label for="tab2" class="tabs__label">Change Password</label>
                    <div class="tabs__content">
               
                        <div class="container rounded bg-white">
                            <div class="row">
                                <div class="col-md-4 border-right">
                                    <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" src="assets/images/profile.png" width="90">
                                        <span class="font-weight-bold">${sessionScope.validUser.getFirstname()} ${sessionScope.validUser.getLastname()}</span>
                                        <span class="text-black-50">${sessionScope.validUser.getEmail()}</span>
                                        <span class="text-black-50">Hello This is ${sessionScope.validUser.getFirstname()} Currently <%if((Integer)request.getSession().getAttribute("roleid") == 1){%> an Admin <%} else{%> a CSR <%}%> of this web page.

                                        </span>

                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <h5> Change Your Password</h5>
                                    <div class="p-3 py-5">
                                        <s:if test="ctr>0">
                                            <div class = "alert alert-success mt-2" role = "alert"><s:property value="msg" /></div>
                                        </s:if>
                                        <s:elseif test= "ctr==-1">
                                            <div class = "alert alert-danger mt-2" role = "alert"><s:property value="msg" /></div>
                                        </s:elseif>

                                        <div class="d-flex justify-content-between align-items-center mb-3">

                                            <div class="d-flex flex-row align-items-center back"><i class="fa fa-arrow-left mr-1 mb-1"></i>

                                                <%if((Integer)request.getSession().getAttribute("roleid") == 1){%><a href="admindashboard"><%} else{%><a href="csrdashboard"><%}%><h6 style="color:black">Back to Dashboard</h6></a>
                                            </div>
                                        </div>

                                        <div class="card-body">
                                            <form action="updatepassword" method ="post" autocomplete="off">
                                                <div class="form-floating mb-3">
                                                    <input class="form-control" id="input" name="username" type="text" value="${sessionScope.validUser.getUsername()}" placeholder="username" readonly/>
                                                    <input class="form-control" id="pid" type="hidden" value="${sessionScope.validUser.getPid()}" name ="pid" />

                                                    <label for="username">Username</label>
 													<span style="font-size: 80%; color: grey;">username can't be changed.</span>
                                                </div>
                                                <span id ="availability"></span>
                                               

                                                <div class="form-floating mb-3">
                                                <!-- Fake password field to avoid autofilled -->
                                                <input id="password" style="display:none" type="password" name="fakepasswordremembered">
                                                    <input class="form-control"  autocomplete="new-password" id="assword" name="assword"  type ="password" value="" placeholder="********" />
                                                    <label for="newpassword">New password</label>                                                    
                                                </div>

                                                <div class="form-floating mb-3">
                                                    <input class="form-control" id="password" name="password"  type ="password"  placeholder="********" />
                                                    <label for="newpassword">Confirm Password</label>
                                                </div>

                                                <div class="mt-4 mb-0">
                                                    <div class="d-grid"><input type = "submit" class="btn btn-primary btn-block" id="update" name='update' value="Update Password"></div>
                                                </div>
                                            </form>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
</div>
                </div>
                </main>
        </div>

<script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'></script>
<script type='text/javascript' src=''></script>
<script type='text/javascript' src=''></script>
<script type='text/Javascript'></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="assets/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="assets/demo/chart-area-demo.js"></script>
<script src="assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="assets/js/datatables-simple-demo.js"></script>
</body>
</html>
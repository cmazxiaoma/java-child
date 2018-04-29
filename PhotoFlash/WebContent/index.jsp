<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>时光流影</title>

        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="templatemo">
        
        <link href='http://fonts.useso.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.useso.com/css?family=Dancing+Script' rel='stylesheet' type='text/css'>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
          <link rel="shortcut icon" href="background/logo.ico" type="image/x-icon" />

</head>
<body>
<!-- Header -->
        <div class="templatemo-container">
            <div class="templatemo-block-left">
                <div class="templatemo-header-left">
                    <div class="templatemo-header-text-wrap">
                        <div class="templatemo-header-text">
                            <h1 class="text-uppercase templatemo-site-name"><span class="gold-text"><b>Photo</b></span> </h1>
                            <hr class="templatemo-header-hr">
                            <p class="text-uppercase templatemo-slogan">Picture for Fashion</p>
                        </div>
                    </div>
                    <div class="templatemo-header-left-overlay"></div>
                    
                </div>
            </div>
            <div class="templatemo-block-right">
                <div class="templatemo-header-right">
                    <div class="templatemo-header-right-overlay"></div>
                    <div class="mobile-menu-icon">
                        <i class="fa fa-bars"></i>
                    </div>
                </div>
            </div>
        </div> <!-- end Header -->
  <!-- "New Picture" -->
        <section class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="text-uppercase">New picture</h2>
                    <hr class="templatemo-section-header-hr">
                    <p class="text-uppercase templatemo-section-subheader">团队 PhotoFlash</p>
                </div>
            </div>
            <div class="row">
            
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 text-center">
                    <div class="new-arrival-container">
                    <a href="login.jsp">
                        <div class="new-arrival-overlay">
                            <h3 class="text-uppercase new-arrival-title">
                                <span class="font-script">Login</span>
                                <span class="smaller-text">PhotoFlash</span>
                            </h3>
                        </div>
                        <img src="img/new-1.jpg" alt="New Arrival 1" class="img-responsive"/>
                        
                    </a>
                    </div>
                </div>
                
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 text-center">
                    <div class="new-arrival-container">
                    <a href="<c:url value='user/main.jsp'/>">
                        <div class="new-arrival-overlay">
                            <h3 class="text-uppercase new-arrival-title">
                                <span class="smaller-text bordered-text">Enter</span>
                                <span><b class="font-script">PhotoFlash</b></span>
                            </h3>
                        </div>
                        <img src="img/new-2.jpg" alt="New Arrival 2" class="img-responsive">
                    </a>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 text-center">
                    <div class="new-arrival-container">
                    <a href="register.jsp">
                        <div class="new-arrival-overlay">
                            <h3 class="text-uppercase new-arrival-title">
                                <span class="font-script">Register</span>
                                <span class="smaller-text">PhotoFlash</span>
                            </h3>
                        </div>
                        <img src="img/new-3.jpg" alt="New Arrival 3" class="img-responsive">
                        </a>
                    </div>
                    
                </div>
            </div>
        </section> <!-- end "New Picture" -->
		<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >手机网站模板</a></div>
        <!-- "Pricture Type" -->
        <section class="templatemo-gray-bg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h2 class="text-uppercase">Picture Type</h2>
                        <hr class="templatemo-section-header-hr">
                        <p class="text-uppercase templatemo-section-subheader">团队 PhotoFlash</p>
                    </div>
                </div>
                <div class="row">
                    <!-- Left block, images -->
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 text-center">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div class="product-type-container">
                                    <div class="product-type-overlay">
                                        <div class="product-type-info">
                                            <i class="fa fa-search fa-2x gold-text"></i>
                                            <h3 class="gold-text text-uppercase">写点什么</h3>
                                            <p class="text-uppercase white-text">大家看 不然不要这个</p>
                                        </div>
                                    </div>
                                    <img src="img/type1.jpg" alt="Product Type 1" class="product-type-img img-responsive">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div class="product-type-container">
                                    <div class="product-type-overlay">
                                        <div class="product-type-info">
                                            <i class="fa fa-search fa-2x gold-text"></i>
                                            <h3 class="gold-text text-uppercase">写点什么</h3>
                                            <p class="text-uppercase white-text">大家看 不然不要这个</p>
                                        </div>
                                    </div>
                                    <img src="img/type2.jpg" alt="Product Type 2" class="product-type-img img-responsive">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div class="product-type-container">
                                    <div class="product-type-overlay">
                                        <div class="product-type-info">
                                            <i class="fa fa-search fa-2x gold-text"></i>
                                            <h3 class="gold-text text-uppercase">写点什么</h3>
                                            <p class="text-uppercase white-text">大家看 不然不要这个o</p>
                                        </div>
                                    </div>
                                    <img src="img/type3.jpg" alt="Product Type 3" class="product-type-img img-responsive">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div class="product-type-container">
                                    <div class="product-type-overlay">
                                        <div class="product-type-info">
                                            <i class="fa fa-search fa-2x gold-text"></i>
                                            <h3 class="gold-text text-uppercase">写点什么</h3>
                                            <p class="text-uppercase white-text">大家看 不然不要这个</p>
                                        </div>
                                    </div>
                                    <img src="img/type4.jpg" alt="Product Type 4" class="product-type-img img-responsive">
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Right block, text -->
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                        <div class="gold-border">
                            <div class="product-type-message">
                                <h3 class="text-uppercase gray-text product-type-message-title"><b>关于照片类型</b></h3>
                                <p class="gray-text">关于照片类型is free responsive template from templatemo.com website. Feel free to download, customize and use this template for your websites. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit.</p>
                                <p class="gray-text">关于照片类型Sed non  mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris in erat justo.</p>
                                <p class="gray-text">关于照片类型Vivamus condimentum vel sem sed sagittis. Duis non sapien egestas, eleifend felis vel, consequat quam.</p>
                                <p class="text-uppercase gold-text"><i>你们组织语言Mauris in erat justo</i></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section> <!-- end Picture Type -->

        <!-- "About Our" -->
        <section class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="text-uppercase">About Our</h2>
                    <hr class="templatemo-section-header-hr">
                    <p class="text-uppercase templatemo-section-subheader">团队 PhotoFlash</p>
                </div>
            </div>
            
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 margin-bottom-10 text-center">
                    <h3 class="text-uppercase"><span class="gold-text">团队</span>精神</h3>
                    <p>说一下团队精神Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, netmabh.</p>
                    <a href="#" class="text-uppercase btn-gray-bordered">没用就删掉这个</a>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 margin-bottom-10 text-center">
                    <img src="img/team1.jpg" alt="Men fashion 1" class="img-fashion gold-border">
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 margin-bottom-10 text-center">
                    <img src="img/team2.jpg" alt="Men fashion 2" class="img-fashion gold-border">
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 margin-bottom-10 text-center">
                    <img src="img/team3.jpg" alt="Men fashion 3" class="img-fashion gold-border">
                </div>
            </div><hr>
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 margin-bottom-10 text-center">
                    <h3 class="text-uppercase"><span class="gold-text">团队</span> 什么鬼？</h3>
                    <p>什么东西？Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, netmabh.</p>
                    <a href="#" class="text-uppercase btn-gray-bordered">同上</a>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 margin-bottom-10 text-center">
                    <img src="img/work1.jpg" alt="Women fashion 1" class="img-fashion gold-border">
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 margin-bottom-10 text-center">
                    <img src="img/work2.jpg" alt="Women fashion 2" class="img-fashion gold-border">
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 margin-bottom-10 text-center">
                    <img src="img/work3.jpg" alt="Women fashion 3" class="img-fashion gold-border">
                </div>
            </div>
        </section> <!-- end "Our Products" -->

        
       
        <!-- JS -->
        <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
        <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->

    </body>
</html>

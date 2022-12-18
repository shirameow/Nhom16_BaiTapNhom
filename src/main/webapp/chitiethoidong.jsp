<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<!-- <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png"> -->
	<!-- <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png"> -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Admin</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="${pageContext.request.contextPath}/css/2.bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet"/> 

    <!--  Paper Dashboard core CSS    -->
    <link href="${pageContext.request.contextPath}/css/paper-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="${pageContext.request.contextPath}/css/demo.css" rel="stylesheet" /> 


    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/css/themify-icons.css" rel="stylesheet">

</head>
<body>

<div class="wrapper">
 <!-- header -->
 <%@ include file="/views/header_admin.jsp" %>
 <!-- end header -->


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Danh sách thành viên </h4>
                                
                                <div class="text-right" >
								    <a href="them-thanh-vien-HD">  
								    	<button type="submit" class="btn btn-info btn-fill btn-wd">Thêm thành viên</button>
								    </a> 
								</div>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                    	<th>Mã HD</th>
                                    	<th>MaGV</th>
                                    	<th>Tên Giảng Viên</th>
                                    	<th>Tên Hội Đồng</th>
                                    	<th></th>
                                    	<th></th>
                                    </thead>
                                    <tbody>
                                    
                                    <c:forEach items="${listGVHD}" var="tthd" >
                                    	<tr>
                                    		
                                        	<td>${tthd.getMaHD()}</td>
                                        	<td>${tthd.getMaGV()}</td>
                                        	<td>${tthd.getTenGV()}</td>
                                        	<td>${tthd.getTenHoiDong()}</td>
                                        	<%-- <td><a href="xem-thong-tin-tai-khoan-Admin?Username=${acc.getUsername()}">Xem chi tiết</a></td>  --%>
                                        	<td>
                                        		<div class="text-center" >
												    <a href="xoa-thanh-vien-hd?maGV=${tthd.getMaGV()}">  
												    	<button type="submit" class="btn btn-info btn-fill btn-wd">Xóa</button>
												    </a> 
												</div>
                                        	</td> 
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
								<c:if test="${messXGVHD != null}">
						<h3 class="" style="text-align: center;color: #f44336;">${messXGVHD}</h3>
					</c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<div class="text-center" >
    <a href="hoi-dong"> 
    	<button type="submit" class="btn btn-info btn-fill btn-wd">Quay lại</button>
    </a> 
</div>	
<!-- 
<div class="text-center" >
    <a href="loai-san-pham-admin"> 
    	<button type="submit" class="btn btn-info btn-fill btn-wd">Loại sản phẩm</button>
    </a> 
</div>
 -->
<!-- footer -->  
  <%@ include file="/views/footer_admin.jsp" %>
<!-- end footer -->  


    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="assets/js/bootstrap-checkbox-radio.js"></script>

	<!--  Charts Plugin -->
	<script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="assets/js/paper-dashboard.js"></script>

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>


</html>

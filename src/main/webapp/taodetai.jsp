<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<!-- <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png"> -->
<!-- <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png"> -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Đề tài</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href="${pageContext.request.contextPath}/css/2.bootstrap.min.css"
	rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet" />

<!--  Paper Dashboard core CSS    -->
<link href="${pageContext.request.contextPath}/css/paper-dashboard.css"
	rel="stylesheet" />


<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="${pageContext.request.contextPath}/css/demo.css"
	rel="stylesheet" />


<!--  Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Muli:400,300'
	rel='stylesheet' type='text/css'>
<link href="${pageContext.request.contextPath}/css/themify-icons.css"
	rel="stylesheet">

</head>
<body>

	<div class="wrapper">
		<!-- header -->
		<%@ include file="/views/header_admin.jsp"%>
		<!-- end header -->

		<form action="tao-de-tai" method="post">
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="header">
									<h4 class="title">Thông tin các đề tài</h4>
									<!-- <div class="text-right" style="margin-right: 50px;" >
						       <button type="submit" class="btn btn-info btn-fill btn-wd">Xác nhận thêm</button> 
						   </div> -->
								</div>
								 <div class="content table-responsive table-full-width">
									<table class="table table-striped">
										<thead>
											<th>Mã đề tài</th>
											<th>Tên Đề Tài</th>
											<th>Giảng Viên</th>
										</thead>
										<tbody>
										 <c:forEach items="${listDT}" var="dt" >
                                    	<tr>
                                        	<td>${dt.getMaDeTai()}</td>
                                        	<td>${dt.getTenDeTai()}</td>
                                        	<td>${dt.getGiangVien()}</td>
                                        </tr>
                                    </c:forEach>
										</tbody>
									</table>
								</div>
								<c:choose>
								<c:when test="${trangthaiDK==1}">
								<div class="header">
									<h4 class="title">Tạo đề tài</h4>
									<div class="text-right" style="margin-right: 50px;">
										<button type="submit" class="btn btn-info btn-fill btn-wd">Tạo đề tài</button>
									</div>
								</div>
								<div class="content table-responsive table-full-width">
									<table class="table table-striped">
										<thead>
											<th></th>
											<th></th>
											<th></th>
										</thead>
										<tbody>
											<tr>
												<td>Tên đề tài</td>
												<td>
													<div class="row">
														<div class="col-md-12">
															<input type="text"
																class="col-md-12 form-control border-input"
																placeholder="" value="" name="tendt">
														</div>
													</div>
												</td>
												<td></td>
												<td></td>
											</tr>
										</tbody>
									</table>
									<c:if test="${messTDT != null}">
										<h5 class="" style="text-align: center; color: #f44336;">${messTDT}</h5>
									</c:if>
								</div>
								</c:when>
								<c:otherwise>
								<div class="header">
									<h4 class="title">Hiện không nằm trong thời gian đăng kí đề tài.</h4>
									<div class="text-right" style="margin-right: 50px;">
									</div>
								</div>
								<div class="content table-responsive table-full-width">
									<table class="table table-striped">
									
									</table>
								</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<div class="text-center">
			<a href="home">
				<button type="submit" class="btn btn-info btn-fill btn-wd">Quay
					lại</button>
			</a>
		</div>
		<div style="margin-bottom: 20px;"></div>

		<!-- footer -->
		<%@ include file="/views/footer_admin.jsp"%>
		<!-- end footer -->
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
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js"></script>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="assets/js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>


</html>
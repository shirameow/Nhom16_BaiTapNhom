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

<title>ĐĂNG KÝ ĐỀ TÀI</title>

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


		<div class="content">
			<div class="container-fluid">

				<div class="row">

					<div class="col-md-12">
						<div class="card">
							<div class="header">
								<h4 class="title">Nhóm ${nhom.getMaNhom()}:
									${nhom.getTenNhom()}</h4>
								<p class="category">Liên hệ: ${nhom.getLienHe() }</p>
							</div>
							<div class="header">
								<h4 class="title">Danh sách thành viên</h4>
							</div>
							<div class="content table-responsive table-full-width">
								<table class="table table-striped">
									<thead>
										<th>STT</th>
										<th>Mã thành viên</th>
										<th>Tên thành viên</th>
										<th></th>
										<th></th>
									</thead>

									<tbody>
										<c:set var="STT" value="${0}"></c:set>
										<c:forEach items="${listThanhVienNhom}" var="tv">
											<tr>
												<c:set var="STT" value="${STT+1}" />
												<td>${STT}</td>
												<td>${tv.getId()}</td>
												<td>${tv.getHoten()}</td>
												<td><c:if test="${tv.getNhomTruong() == 1 }">Nhóm trưởng</c:if></td>
												<td></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<c:if test="${mess != null}">
									<h5 class="" style="text-align: center; color: #f44336;">${mess}</h5>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="text-center">
				<a href="quanly-detai">
					<button type="submit" class="btn btn-info btn-fill btn-wd">Quay
						lại</button>
				</a>
			</div>
		</div>


		<!-- footer -->
		<%@ include file="/views/footer_admin.jsp"%>
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
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js"></script>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="assets/js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>


</html>

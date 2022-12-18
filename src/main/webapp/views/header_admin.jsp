<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="sidebar" data-background-color="white" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="trang-chu-admin" class="simple-text">
                   Tài Khoản: ${account.username}
                </a>
            </div>

            <ul class="nav">
                <li >
                    <a href="home">
                        <i class="ti-panel"></i>
                        <p>Trang chủ</p>
                    </a>
                </li>
               <!--  <li>
                    <a href="thong-tin-khach-hang">
                        <i class="ti-user"></i>
                        <p>Thông tin giảng viên</p>
                    </a>
                </li> -->
                <li>
                    <a href="thongtin-taikhoan">
                        <i class="ti-view-list-alt"></i>
                        <p>Thông tin tài khoản</p>
                    </a>
                </li>
                <c:if test="${account.role.equals('Sinh Viên') }">
                <li>
                    <a href="loai-san-pham-admin">
                        <i class="ti-text"></i>
                        <p>Thông tin nhóm</p>
                    </a>
                </li>
                <li>
                    <a href="danh-sach-gop-y-admin">
                        <i class="ti-pencil-alt2"></i>
                        <p>Đăng kí nhóm</p>
                    </a>
                </li>
                <li>
                    <a href="danh-sach-hoa-don-admin">
                        <i class="ti-map"></i>
                        <p>Đăng kí đề tài</p>
                    </a>
                </li>
               	</c:if>
               	<c:if test="${account.role.equals('Giảng Viên') }">
                <li>
                    <a href="thongtin-detai">
                        <i class="ti-text"></i>
                        <p>Tạo đề tài</p>
                    </a>
                </li>
               	</c:if>
               	 	<c:if test="${account.role.equals('Admin') }">
                <li>
                    <a href="quanli-taikhoan">
                        <i class="ti-text"></i>
                        <p>Quản lý tài khoản</p>
                    </a>
                </li>
                <li>
                    <a href="quan-li-DDK">
                        <i class="ti-text"></i>
                        <p>Đóng,Mở đăng kí</p>
                    </a>
                </li>
                <li>
                    <a href="hoi-dong">
                        <i class="ti-text"></i>
                        <p>Quản lí hội đồng</p>
                    </a>
                </li>
               	</c:if>
               	   <li>
                    <a href="dang-xuat">
                        <i class="ti-view-list-alt"></i>
                        <p>Đăng xuất</p>
                    </a>
                </li>
                <!-- <li>
                    <a href="notifications.html">
                        <i class="ti-bell"></i>
                        <p>Notifications</p>
                    </a>
                </li> -->
				<!-- <li class="active-pro">
                    <a href="upgrade.html">
                        <i class="ti-export"></i>
                        <p>Upgrade to PRO</p>
                    </a>
                </li> -->
            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                  <!--   <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button> -->
                    <img src ="images/desktop.jpg">
                    <a class="navbar-brand" href="#">ĐĂNG KÍ ĐỀ TÀI</a>
                </div>
                <!-- <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-panel"></i>
								<p>Thống kê</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="ti-bell"></i>
                                    <p class="notification">5</p>
									<p>Thông báo</p>
									<b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Thông báo 1</a></li>
                                <li><a href="#">Thông báo 2</a></li>
                                <li><a href="#">Thông báo 3</a></li>
                                <li><a href="#">Thông báo 4</a></li>
                                <li><a href="#">Thông báo khác</a></li>
                              </ul>
                        </li>
						<li>
                            <a href="#">
								<i class="ti-settings"></i>
								<p>Cài đặt</p>
                            </a>
                        </li>
                    </ul>

                </div> -->
            </div>
        </nav>
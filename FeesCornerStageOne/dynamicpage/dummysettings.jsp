<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./resources/js/jquery-2.1.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Settings Page</title>

<script type="text/javascript">
$(function(){
	
	
$('.tab').click(function(){
	  $('.tab').removeClass('active');
	  $(this).addClass('active');
	});

});

</script>
<style>
/* CSSTerm.com Simple CSS menu */
.menu_simple ul {
	margin: 0;
	padding: 0;
	width: 185px;
	list-style-type: none;
}

.menu_simple ul li a {
	text-decoration: none;
	color: white;
	padding: 10.5px 11px;
	background-color: #005555;
	display: block;
}

.menu_simple ul li a:visited {
	color: white;
}

.menu_simple ul li a:hover,.menu_simple ul li .current {
	color: white;
	background-color: #5FD367;
}

/* body {
	margin: 0px;
	background: #FCFCFC;
}

.header {
	height: 50px;
	background: #F0F0F0;
	border: 1px solid #CCC;
	width: 1340px;
	margin: 0px auto;
}

.content {
	width: 1340px;
	background: #F0F0F0;
	border: 1px solid #CCC;
	height: 2000px;
	margin: 20px auto;
} */


.tabs {
  height:45px;
  padding: 0 0 0 0;
  overflow:visible;
}
.tab {
  width:200px;
  height:45px;
  overflow:hidden;
  float:left;
  margin:0 -15px 0 0;
}


.tab-box {
  height:50px;
  background: #fff;
  border-radius: 4px;
  border:1px solid #ccc;
  margin:0 10px 0;
  box-shadow: 0 0 2px  #fff inset;


 -webkit-transform: perspective(100px) rotateX(30deg);
 -moz-transform: perspective(100px) rotateX(30deg);
  
}

.tab.active {
  z-index:40;
  position:relative;
  padding-bottom:1px;
}
.tab.active .tab-box{
  background-color: #eee;
  @include background-image(linear-gradient(top, #ccc , #ddd 3%, rgba(#eee, 0.5)  ));
  box-shadow: 0 0 2px 0 #fff inset;
}

.content {
  z-index:1;
  padding:100px;
  border:1px solid #ccc;
  background:#eee;
  position:relative;
  
}

.clear {
 clear:both;
}
</style>
</head>
<body>
	<div class="header"></div>
	<div class="content">
		<div class="menu_simple" style="width: 200px; float: left;">
			<ul>
				<li><a href="#">Academics</a></li>
				<li><a href="#">Finance</a></li>
				<li><a href="#">HR Management </a></li>
				<li><a href="#" id="hostel">Hostel</a></li>
				<li><a href="gotosettings" id="transport">Transport</a></li>
				<li><a href="#settings" id="settings"> Settings</a></li>
			</ul>
		</div>
</div>
		<div class="tabs">
  <div class="tab"><div class="tab-box"></div></div>
  <div class="tab"><div class="tab-box"></div></div>
  <div class="tab active"><div class="tab-box"></div></div>
  <div class="tab"><div class="tab-box"></div></div>

</div>
	




</body>
</html>
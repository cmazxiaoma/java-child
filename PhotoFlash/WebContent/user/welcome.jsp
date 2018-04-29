<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/lrtk.css"/>
<script type="text/javascript" src="../JS/jquery.min.js"></script>
<script type="text/javascript" src="../JS/jquery.devrama.slider.js"></script>
<style type="text/css">
	.example-animation {
		color: #FFF;
		font-size: 60px;
	}
</style>
</head>
<body>
<!-- 代码 开始 -->
<div class="example-animation">
	<div data-lazy-background="../background/1.jpg">
		<h3 data-pos="['0%', '110%', '0%', '5%']" data-duration="700" data-effect="move">
			Welcome
		</h3>
		<div data-pos="['-30%', '25%', '40%', '25%']" data-duration="700" data-effect="move">
			It is of
		</div>
		<div data-pos="['56%', '-40%', '56%', '11%']" data-duration="700" data-effect="move">
			high quality
		</div>
		<div data-pos="['23%', '110%', '23%', '42%']" data-duration="700" data-effect="move">
		</div>
	</div>
	<div data-lazy-background="../background/g1.jpg">
		<h3 data-pos="['0%', '8%']" data-duration="1000" data-effect="fadein">
			Welcome
		</h3>
		<div data-pos="['44%', '15%']" data-duration="700" data-effect="fadein">
			You're always
		</div>
		<div data-pos="['66%', '11%']" data-duration="700" data-effect="fadein">
			there for me
		</div>
	</div>	 
		
</div>
<script type="text/javascript">
$(document).ready(function(){
	$('.example-animation').DrSlider(); //Yes! that's it!
});
</script>
<!-- 代码 结束 -->
</body>
</html>
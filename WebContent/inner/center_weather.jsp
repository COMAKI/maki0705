<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#w {
	width: 250px;
	height: 700px;
	margin-left: 300px;
	float: left;
	color: white;
	border: 1px solid white;
}
#f {
	width: 250px;
	height: 700px;
	position: relative;
	float: left;
	color: white;
	border: 1px solid white;
}
#m {
	width: 250px;
	height: 700px;
	position: relative;
	float: left;
	border: 1px solid white;
}
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript" charset="utf-8"></script>
<script>
function wdisplay(data){
	var w = $(data).find('yweather\\:condition,condition');			// xml의 yweather:condition을 가져오기.
	var code = w.attr('code');										// 가져온 전체 tag에서 temp, text, code, date 속성 가져오기.
	var date = w.attr('date');
	var temp = w.attr('temp');
	var text = w.attr('text');
	var result = '';
	result += '<img src="http://l.yimg.com/a/i/us/we/52/' + code + '.gif"/>'; 
	result += '<h4>' + date + '<h4>'; 
	result += '<h4>' + temp + '<h4>'; 
	result += '<h4>' + text + '<h4>'; 
	$('#w').html(result);
};
function fdisplay(data){
	
	var w = $(data).find('yweather\\:forecast,forecast'); 
	var result = '';
	var cnt = 0;
	
	$(w).each(function(index, item){
					
		var code = $(item).attr('code');
		var date = item.getAttribute('date');
		var temp = item.getAttribute('temp');
		var text = item.getAttribute('text');
		result += '<img src="http://l.yimg.com/a/i/us/we/52/' + code + '.gif"/>'; 
		result += '<h5>' + date + '<h5>'; 
		result += '<h5>' + temp + '<h5>'; 
		result += '<h5>' + text + '<h5>'; 		
		cnt++;
		if(cnt == 5){
			$('#f').html(result);
			return;
		};
	});
};
function mdisplay(center){
	var div = document.querySelector('#m');
	var map = new google.maps.Map(div,{
		mapTypeId:google.maps.MapTypeId.ROADMAP, 
		zoom:15,
		center:center
	});	
	
};

function getWhether(){						// 날씨정보를 요청하는 함수.
	
	var wurl = 'https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22seoul%22)%20%20and%20u%3D%27c%27&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys';
	// Open API

	$.ajax({
		url: wurl,
		success:function(data){
			wdisplay(data);
			fdisplay(data);
		},
		error:function(){}
	});
};

$(document).ready(function(){
	$('button').click(function(){
		var center = new google.maps.LatLng(37.500084, 127.037727);
		getWhether();
		mdisplay(center);
	});
});
</script>
</head>
<body>
<button>Weather</button>
<div id="w"></div>			<!--현재날씨  -->
<div id="f"></div>			<!-- 주간날씨 -->
<div id="m"></div>			<!-- 맵 -->
</body>
</html>
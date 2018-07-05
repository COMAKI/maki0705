<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<style>
	.product_img{
		height:200px;
		width:200px;
	}
</style>


<div id="center" class="content-wrapper">
<h1>Product Detail Page</h1>
<img class="product_img" src="img/${detailp.imgname }"><br>
ID: ${detailp.id }<br>
NAME: ${detailp.name }<br>
PRICE: ${detailp.price }<br>
REGDATE: ${detailp.regdate }<br>
<a href="product.mc?cmd=delete&id=${detailp.id }">DELETE</a>
<a href="product.mc?cmd=update&id=${detailp.id }">UPDATE</a>
</div>



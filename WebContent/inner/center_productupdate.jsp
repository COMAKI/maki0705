<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<style>
	.product_img{
		height:200px;
		width:200px;
	}
</style>


 <div class="content-wrapper">
 <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Product Detail Page</div>
      <div class="card-body">
        <img class="product_img" src="img/${detailp.imgname }"><br>
		ID: ${detailp.id }<br>
		NAME: ${detailp.name }<br>
		PRICE: ${detailp.price }<br>
		REGDATE: ${detailp.regdate }<br>
		<a href="main.mc?view=productupdate&id=${detailp.id }">UPDATE</a>
		<a href="product.mc?cmd=delete&id=${detailp.id }">DELETE</a>
      </div>
    </div>
  </div>
  </div>
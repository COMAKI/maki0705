<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<script type="text/javascript">
	$(document).ready(function(){
		$('#loginbutton').click(function(){
			$('#loginform').attr('method','post');
			$('#loginform').attr('action','loginout.mc');
			$('#loginform').submit();
			console.log('hiroo');
		});
	});

</script>


 <div class="content-wrapper">
<div class="container">
   <div class="card card-login mx-auto mt-5">
     <div class="card-header">Login</div>
     <div class="card-body">
       <form id="loginform" >
         <div class="form-group">
           <label for="exampleInputEmail1">Email address</label>
           <input name="id" class="form-control" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="Enter email">
         </div>
         <div class="form-group">
           <label for="exampleInputPassword1">Password</label>
           <input name="pwd" class="form-control" id="exampleInputPassword1" type="password" placeholder="Password">
         </div>
         <div class="form-group">
           <div class="form-check">
             <label class="form-check-label">
               <input class="form-check-input" type="checkbox"> Remember Password</label>
           </div>
         </div>
         <a id="loginbutton" class="btn btn-primary btn-block">Login</a>
       </form>
       <div class="text-center">
         <a class="d-block small mt-3" href="register.html">Register an Account</a>
         <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
       </div>
       <c:if test="${loginstate == 'fail'}">
       		<h1>login fail</h1>
       </c:if>
       
     </div>
     
   </div>
  </div>
</div>


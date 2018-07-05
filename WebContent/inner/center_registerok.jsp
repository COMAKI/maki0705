<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<script>

$(document).ready(function(){
	$('#regbtn2864').click(function(){		
		$('#regform2864').attr('method','post');
		$('#regform2864').attr('action','register.mc');
		$('#regform2864').submit();	
		console.log('register form is being sent');
	});	
});
	

</script>


 <div class="content-wrapper">
 <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        
        <div class="text-center">
        	<h3>Registration Successful</h3>
        </div>
      </div>
    </div>
  </div>
  </div>
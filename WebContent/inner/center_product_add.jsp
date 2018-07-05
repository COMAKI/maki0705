<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<script>
function register76(f){
	var c = confirm('등록 하시겠습니까?');
	if(c == true){
		f.method='POST';
		f.action='product.mc?cmd=add';
		f.submit();
	}
};
</script>

 <div class="content-wrapper">
 <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register a Product</div>
      <div class="card-body">
        <form enctype="multipart/form-data">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Product Name</label>
                <input class="form-control" name="name" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Enter name">
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Product Price</label>
                <input class="form-control" name="price" id="exampleInputLastName" type="number" aria-describedby="nameHelp" placeholder="Enter Price in Numbers">
              </div>
            </div>
          </div>
         <div class="form-group">
            <label for="exampleConfirmPassword">Upload Image</label>
            <input class="form-control" type="file" name="imgname" id="exampleConfirmPassword">  
          </div>
        <input class="btn btn-primary btn-block" type="button" value="REGISTER" onclick="register76(this.form);">
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="login.html">Login Page</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
 </div>

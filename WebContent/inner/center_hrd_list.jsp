<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#main_center {
	width: 700px;
	height: 300px;
	margin: 0 auto;
	background: white;
	text-align: center;
}

td:first-child {
	width: 200px;
}
</style>

<div id="main_center">
	<h1>PRODUCT LIST</h1>
	<a href="hrd.mc?cmd=add"><button>getdata</button></a>
	<table>
		<tr>
			<th>TITLE</th>
			<th>TITLEICON</th>
		</tr>
		<c:if test="${hrdlist} != null">
			<c:forEach var="it" items="${hrdlist}">
				<tr>
					<td>${it.title }</td>
					<td>${it.titleIcon}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</div>
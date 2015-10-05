<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is the zoo!</title>
<style>
	div{outline:1px solid red;}
	.nav li{display:inline;}
	table {border: solid 1px;}
</style>
</head>
<body>
${content}
${hello}
	<div>
		<ul class="nav" style="list-style:none;">
			<li>首页</li>
			<li>特价</li>
			<li>更多</li>
		</ul>
	<hr>
	</div>
		<div style="float:left;">
		<ul>
			<li>加入购物车</li>
			<li>查看详情</li>
			<li>更多</li>
		</ul>
		</div>
		<div style="float:left">
				<c:choose>
					<c:when test="${content eq 'main'}">
					<table>
						<tr>
							<td>name</td><td>weight</td><td>height</td><td>age</td>
						</tr>
						<c:forEach var="animal" items="${animals}">	
							<tr><sf:form method="delete" action="${animal.name}"><td>${animal.name}</td><td>${animal.weight}</td><td>${animal.height }</td><td>${animal.age }</td><td><button>删除</button></sf:form></td></tr>					
						</c:forEach>
					</table>						
					</c:when>
					
					<c:when test="${content eq 'show'}">
					<table>
						<tr>
							<td>name</td><td>weight</td><td>height</td><td>age</td>
						</tr>
						<tr>							
							<td>${animal.name}</td><td>${animal.weight}</td><td>${animal.height }</td><td>${animal.age }</td>				
						</tr>
					</table>						
					</c:when>
					
					<c:when test="${content eq 'new'}">
					
					<sf:form method='post' modelAttribute="animal" enctype="application/json">
						<fieldset>
							<label for="animal_name">name:</label>
							<sf:input path="name" id="animal_name"/><br>
							<label for="animal_weight">weight:</label>
							<sf:input path="weight" id="animal_weight"/><br>
							<label for="animal_height">height:</label>
							<sf:input path="height" id="animal_height"/><br>
							<label for="animal_age">age:</label>
							<sf:input path="age" id="animal_age"/><br>	
							<button>提交</button>				
						</fieldset>
					
					</sf:form>
										
					</c:when>
				
				</c:choose>
		</div>
	<div>
	
	</div>
</body>
</html>
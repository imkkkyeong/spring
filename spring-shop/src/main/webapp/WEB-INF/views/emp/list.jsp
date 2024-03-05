<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/tags.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" ></script>
<title>인사관리 - 인사목록</title>
</head>
<body>
<%@include file="../common/navbar.jsp" %>
	<div class="container">
		<div class="row mb-3">
			<div class="col-12">
				<h1 class="fs-3">인사관리 - 인사목록</h1>
				<table class="table">
					<colgroup>
						<col width="10%">
						<col width="10%">
						<col width="15%">
						<col width="15%">
						<col width="10%">
						<col width="10%">
						<col width="30%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>이메일</th>
							<th>연봉</th>
							<th>부서번호</th>
							<th>입사일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="emp" items="${empList }">
	                        <tr>
	                           <td>${emp.no }</td>
	                           <td>${emp.name }</td>
	                           <td>${emp.tel }</td>
	                           <td>${emp.email }</td>
	                           <td>${emp.salary }</td>
	                           <td>${emp.dept.no }</td>
	                           <td>${emp.hireDate }</td>
	                        </tr>
	                     </c:forEach>
					</tbody>
				</table>
				<div class="row-mb-3">
				<div class="col-12">
					<div class="text-end">
						<a href="create" class="btn btn-primary">인사 등록</a>
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>
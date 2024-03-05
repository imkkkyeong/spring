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
<title>부서관리 - 부서목록</title>
</head>
<body>
<%@include file="../common/navbar.jsp" %>
	<div class="container">
		<div class="row mb-3">
			<div class="col-12">
				<h1 class="fs-3">부서관리 - 부서목록</h1>
				<table class="table">
					<colgroup>
						<col width="20%">
						<col width="20%">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>팩스번호</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dept" items="${deptList }">
	                        <tr>
	                           <td>${dept.no }</td>
	                           <td>${dept.name }</td>
	                           <td>${dept.tel }</td>
	                           <td>${dept.fax }</td>
	                        </tr>
	                     </c:forEach>
					</tbody>
				</table>
				<div class="row-mb-3">
				<div class="col-12">
					<div class="text-end">
						<a href="create" class="btn btn-primary">부서 등록</a>
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>
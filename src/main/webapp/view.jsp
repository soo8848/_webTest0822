<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<div
			class="p-3 text-primary-emphasis bg-danger-subtle border border-secondary-subtle rounded-3">
			<table class="table table-bordered border border-warning-subtle">
				<tbody>
					<tr>
						<th class="bg-warning">제목</th>
						<td>${msg.title}</td>
					</tr>
					<tr>
						<th class="bg-warning">작성자</th>
						<td>${msg.writer}</td>
					</tr>
					<tr>
						<th class="bg-warning">작성일시</th>
						<td>${msg.regtime}</td>
					</tr>
					<tr>
						<th class="bg-warning">조회수</th>
						<td>${msg.hits}</td>
					</tr>
					<tr>
						<th class="bg-warning">내용</th>
						<td>${msg.content}</td>
					</tr>
				</tbody>
			</table>

			<div class="mt-3">
				<input class="btn btn-outline-secondary rounded-pill px-3"
					type="button" class="btn btn-warning me-2" value="목록보기"
					onclick="location.href='list'"> <input type="button"
					class="btn btn-success me-2" value="수정"
					onclick="location.href='write?num=${param.num}'"> <input
					type="button" class="btn btn-danger" value="삭제"
					onclick="location.href='delete?num=${param.num}'">
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>

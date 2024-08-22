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
<style>
.container {
	padding-top: 50px;
}
</style>
</head>
<body>
	<div class="container">
		<div
			class="p-3 bg-danger-subtle border border-secondary-subtle rounded-3">
			<form method="post" action="${action}">
				<div class="row gy-4">
					<div class="col-md-6">
						<table class="table table-bordered">
							<tbody>
								<tr>
									<th scope="row" class="table-warning">제목</th>
									<td><input type="text" class="form-control" name="title"
										maxlength="80" value="${msg.title}"></td>
								</tr>
								<tr>
									<th scope="row" class="table-warning">작성자</th>
									<td><input type="text" class="form-control" name="writer"
										maxlength="20" value="${msg.writer}"></td>
								</tr>
								<tr>
									<th scope="row" class="table-warning">내용</th>
									<td><textarea class="form-control" name="content"
											rows="10">${msg.content}</textarea></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<div class="text-center mt-3">
					<input type="submit" class="btn btn-success me-2" value="저장">
					<input type="button" class="btn btn-danger" value="취소"
						onclick="history.back()">
				</div>
			</form>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시판 작성</title>
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
			<h1 class="text-center">
				<span class="badge text-bg-danger">게시판</span>
			</h1>
			<table
				class="table table-bordered table-hover table-striped table-white border border-warning">
				<thead>
					<tr>
						<th class="table-warning">번호</th>
						<th class="table-warning">제목</th>
						<th class="table-warning">작성자</th>
						<th class="table-warning">작성일시</th>
						<th class="table-warning">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="msg" items="${msgList}">
						<tr>
							<td>${msg.num}</td>
							<td style="text-align: left;"><a
								href="view?num=${msg.num}&page=${param.page}"> ${msg.title}
							</a></td>
							<td>${msg.writer}</td>
							<td>${msg.regtime}</td>
							<td>${msg.hits}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-center my-4">
				<c:forEach var="pgn" items="${pgnList}">
					<a class="btn btn-link" href="list?page=${pgn.pageNo}"> <c:choose>
							<c:when test="${pgn.curPage}">
								<u>${pgn.display}</u>
							</c:when>
							<c:otherwise>
                                ${pgn.display}
                            </c:otherwise>
						</c:choose>
					</a>&nbsp;
                </c:forEach>
			</div>

			<div class="text-center">
				<input type="button" class="btn btn-success" value="글쓰기"
					onclick="location.href='write'">
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/slick.jsp" %>
	<section id="services">
		<div class="section-content">
			<div class="container services">
				<div class="services-header text-center py-5">
					<h1 class="diplay-5">韓国アイドル（${years}年代)</h1>
					<div class="divider korea"></div>
				</div>
				<div id="slick-slide" class="services-body">
					<c:forEach var="n" items="${list}" varStatus="vs">
						<div class="services-col mx-2 my-3">
							<div class="card" >
								<a href="#${fn:substringBefore(n.groupName,'.')}"> <img src="${n.filePath}" alt=""
									class="card-img-top" />
								</a>
								<div class="card-body">
									<h4 class="card-title">${fn:substringBefore(n.groupName,'.')}</h4>
									<p class="card-text fw-light mb-4">デビュー年：${n.year} </p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>

	<div class="container-fulid">
		<div class="row justify-content-center">
		<c:forEach var="n" items="${list}">
			<div class="card m-2" style="width: 18rem;">
				<img src="${n.filePath}" class="card-img-top" alt="...">
				<div class="card-body" id="${fn:substringBefore(n.groupName,'.')}">
					<label class="card-title fs-4">${fn:substringBefore(n.groupName,'.')}</label>
					<p class="card-text"></p>
					<a href="#" class="btn btn-primary">Go</a>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.slim.min.js"
		integrity="sha512-yBpuflZmP5lwMzZ03hiCLzA94N0K2vgBtJgqQ2E1meJzmIBfjbb7k4Y23k2i2c/rIeSUGc7jojyIY5waK3ZxCQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
		integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script src="${pageContext.request.contextPath}/js/app.js"></script>
	<script src="${pageContext.request.contextPath}/js/slick.js"></script>

</body>
</html>
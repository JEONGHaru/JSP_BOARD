<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/slick.jsp"%>
<div id="services">
	<div class="section-content">
		<div class="container services">
			<div class="services-header text-center py-5">
				<h1 class="diplay-5">韓国アイドル（${years}年代)</h1>
				<div class="col divider korea"></div>
				<%-- <c:if test="${principal.userGrade == 9 }"> --%>
					<form class="row" action="korea/upload?year=${years}&gen=${gender}" method="POST"
						enctype="multipart/form-data">
						<div class="col-auto">
							<input class="form-control m-1" type="text" name="debut" placeholder="デビューxxxx年xx月xx日"
							 value="年月日">
							<input class="form-control m-1" type="text" name="groupName" placeholder="groupName">
							<input class="form-control m-1" type="file" name="image">
						</div>
						<div class="col-auto mx-0">
							<button class="btn btn-primary" type="submit">登録</button>
						</div>
					</form>
		<%-- 		</c:if>  --%>
			</div>
			<div id="slick-slide" class="services-body">
				<c:forEach var="n" items="${list}" varStatus="vs">
					<div class="services-col mx-2 my-3">
						<div class="card">
							<a href="#${fn:substringBefore(n.groupName,'.')}"> <img
									src="${n.filePath}" alt="" class="card-img-top" />
								</a>
							<div class="card-body">
								<h4 class="card-title">${n.groupName}</h4>
								<p class="card-text fw-light mb-4">デビュー年：${n.debut}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

<div class="container-fulid">
	<div class="row justify-content-center">
		<c:forEach var="n" items="${list}" varStatus="vs">
			<div class="card m-2 myCard" style="width: 18rem;">
				<img src="${n.filePath}" class="card-img-top" id="myImage" data-bs-toggle="modal"
					data-bs-target="#exampleModal${vs.index }">
				<div class="card-body" id="${n.groupName}">
					<label class="card-title fs-4">${n.groupName}</label>
					<p class="card-text"></p>
					<div class="d-flex flex-column">
					<form class=""action="delete?imageID=${n.imageID}&filePath=${n.filePath}" method="POST">
					<button class="btn" type="submit"><i class="fa-solid fa-trash-can"></i></button>
					</form>
					<c:if test="${empty principal}">
						<div class="fs-3 align-self-end"><span>${n.likeCount}</span><a onclick="login()"><i class="fa-regular fa-heart p-1"  style="color:red; cursor:poinnter"></i></a></div>	
					</c:if>
					<c:if test="${not empty principal}">
						<c:if test="${n.liked}">
					<div class="fs-3 align-self-end"><span id="count${n.imageID}">${n.likeCount}</span><a id="like" idx="${n.imageID}"><input type="hidden" id="user" value="${principal.userID }"/><i class="fa-regular fa-heart p-1" id="heart${n.imageID}"  style="color:red; cursor:poinnter"></i></a></div>
					</c:if>
					<c:if test="${!n.liked}">
					<div class="fs-3 align-self-end"><span id="count${n.imageID}">${n.likeCount}</span><a id="like" idx="${n.imageID}"><input type="hidden" id="user" value="${principal.userID }"/><i class="fa-solid fa-heart p-1" id="heart${n.imageID}"  style="color:red; cursor:poinnter"></i></a></div> 
					</c:if>
					</c:if>
					</div>
				</div>
			</div>
			<div class="modal fade" id="exampleModal${vs.index }" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<input type="hidden" id="imageID" value="${n.imageID }" />
							<h1 class="modal-title fs-4" id="exampleModalLabel">${n.groupName }</h1>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body"><img src="${n.filePath }" class="card-img-top">
						<c:if test="${empty principal}">
						<div class="fs-3 align-self-end"><span>${n.likeCount}</span><a onclick="login()"><i class="fa-regular fa-heart p-1"  style="color:red; cursor:poinnter"></i></a></div>	
			
						</c:if>
						<c:if test="${not empty principal}">
						<c:if test="${n.liked}">
						<div class="fs-3 align-self-end"><span id="mCount${n.imageID}">${n.likeCount}</span><a id="like" idx="${n.imageID}"><i class="fa-regular fa-heart p-1" id="mHeart${n.imageID}"  style="color:red; cursor:poinnter"></i></a></div>
						</c:if>
						<c:if test="${!n.liked}">
						<div class="fs-3 align-self-end"><span id="mCount${n.imageID}">${n.likeCount}</span><a id="like" idx="${n.imageID}"><i class="fa-solid fa-heart p-1" id="mHeart${n.imageID}"  style="color:red; cursor:poinnter"></i></a></div> 	
						</c:if>
						</c:if>
						</div>
						<div class="modal-footer">
					
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<script type="text/javascript">



function login(){
	alert('ログインしてください');
}


$(document).on('click',"#like",function(){
	let imageID = $(this).attr('idx');
	let userID = $("#user").val();
	let likeCount = parseInt($("#count"+imageID).text());
	if($(this).children('i').attr('class') == 'fa-regular fa-heart p-1'){
		$.ajax({
			type:"POST",
			url: "/album/likeAdd",
			data: "imageID="+imageID+"&userID="+userID,
			contentType: "application/x-www-form-urlencoded"
		}).done(function(data){
			if(data === '-1'){
				alert('いいねは一回しかできません');
				history.back();
			}else{
				parseInt($("#count"+imageID).text(likeCount+1));
				parseInt($("#mCount"+imageID).text(likeCount+1));
				
				$("#heart"+imageID).attr('class','fa-solid fa-heart p-1');
				$("#mHeart"+imageID).attr('class','fa-solid fa-heart p-1');
			}
		})
		
	}else if($(this).children('i').attr('class') == 'fa-solid fa-heart p-1'){
		$.ajax({
			type:"POST",
			url: "/album/likeCancel",
			data: "imageID="+imageID+"&userID="+userID,
			contentType: "application/x-www-form-urlencoded"
		}).done(function(data){
			if(data == '-1'){
				alert('いいねキャンセルは一回しかできません');
				history.back();
			}else{
				
				parseInt($("#count"+imageID).text(likeCount-1))
				parseInt($("#mCount"+imageID).text(likeCount-1))
			
				$("#heart"+imageID).attr('class','fa-regular fa-heart p-1');
				$("#mHeart"+imageID).attr('class','fa-regular fa-heart p-1');
			}
			
	})
	}
});

</script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
	integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="${pageContext.request.contextPath}/js/slick.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
</body>
</html>
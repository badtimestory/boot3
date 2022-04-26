<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<c:import url="../template/header.jsp"></c:import>
<c:import url="../template/header_script.jsp"></c:import>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>

	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-secondary" role="alert">
				  <h4>${board} WRITE</h4>
			</div>
		</div>
		<form action="./add" method="POST" enctype="multipart/form-data">
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">TITLE</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="title">
			    </div>
			</div>
			
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">WRITER</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="writer">
			    </div>
			</div>
		  
			<div class="row mt-3">
				<label class="col-sm-2 col-form-label">CONTENTS</label>
				<div class="col-sm-10">
					<textarea id="contents" class="form-control" name="contents"></textarea>
				</div>
			</div>
			
			<div id="fileResult">
			
			</div>
			
			<div class="row mt-3 justify-content-between">
				<button id="fileAdd" type="button" class="btn col-2 btn-secondary">FILE ADD</button>
				<button class="btn col-2 btn-outline-primary">WRITE</button>
			</div>
		</form>
	</div>
<script type="text/javascript">

	//textarea id
	$('#contents').summernote({
		height: 400,
		placeholder: '내용을 입력하세요',
		callbacks: {
			onImageUpload:function(files) {
				let formData = new FormData();
				formData.append("files", files[0]);
				
				// /board/summerFileUpload
				$.ajax({
					type:"POST",
					url:"./summerFileUpload",
					processData:false,
					contentType:false,
					data:formData,
					success:function(data) {
						console.log(data.trim());
						$('#contents').summernote('editor.insertImage', data.trim());						
					}
				});
			},	// end of onImageUpload
			onMediaDelete:function(files) {
				let fileName = $(files[0]).attr('src');
				console.log(fileName.trim());
				$.ajax({
					type:"GET",
					url:"./summerFileDelete",
					data: {
						fileName:fileName
					},
					success:function(data) {
						console.log('삭제확인: ' + data.trim());
					}
				})
			}
		}
	});
	
	let count = 0;
	
	$('#fileAdd').click(function() {
		if(count > 4) {
			alert('파일은 최대 5개까지 첨부가능합니다.');
			return;
		}
		
		let result = '<div class="input-group mt-3">';
		result = result + '<label class="col-sm-1 col-form-label">FILE</label>';
		result = result + '<div class="col-sm-10">';
		result = result + '<input type="file" class="form-control" name="files">';
		result = result + '<button class="btn btn-outline-secondary del" type="button" id="button-addon2">X</button>'
		result = result + '</div>';
		result = result + '</div>';
		$('#fileResult').append(result);
		count++;
	});
	
	// FileResult 안에 del을 click 했을 때
	$('#fileResult').on('click', ".del", function(){
		$(this).parent().parent().remove();
		count--;
	})
</script>

</body>
</html>
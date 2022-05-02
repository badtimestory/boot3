/**
 * 
 */
 	function summernoteInit(selector, code) {
	$('#'+selector).summernote({
		height: 400,
		placeholder: '내용을 입력하세요',
		callbacks: {
			onImageUpload:function(files) {
				let formData = new FormData();
				formData.append("files", files[0]);
				console.log($(":file"));
				console.log($(".note-image-input").val())
				// /board/summerFileUpload
				$.ajax({
					type:"POST",
					url:"./summerFileUpload",
					data:formData,
					processData:false,
					contentType:false,
					success:function(data) {
						console.log(data.trim());
						$('.note-image-input').val('');
						$('#'+selector).summernote('editor.insertImage', data.trim());
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
		
		$('#'+selector).summernote('code', code);
	}	
 	
		
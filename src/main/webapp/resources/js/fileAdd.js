/**
 * 글 작성시 첨부파일을 관리하는 JS
 */
 	let count = 0;
 
 	function fileDeleteInit() {
		$('.del').click(function() {
			let check = window.confirm("삭제하시겠습니까?");
			
			if(!check) {
				return;
			}
			
			let fileNum = $(this).attr('data-num');
			let selector = $(this);
			// console.log(this);	// event.target 클릭한 element
			console.log(selector);

			$.ajax({
				type:"POST",
				url:"./fileDelete",
				data:{
					fileNum:fileNum
				},
				success:function(data){
					// console.log(this);	// ajax 객체
					console.log(selector);
					if(data.trim() == '1') {
						$(selector).parent().remove();
						count--;						
					} else {
						alert("파일 삭제를 실패했습니다");
					}
				},
				error:function() {
					alert("파일 삭제 실패");
				}
			});
		});
	}
 
	function fileAddInit(c) {
	 	
	 	count = c
	 	
		$('#fileAdd').click(function() {
			if(count > 4) {
				alert('파일은 최대 5개까지 첨부가능합니다.');
				return;
			}
			
			let result = '<div class="mt-3 input-group">';
			result = result + '<input name="files" type="file" class="form-control files" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">'
			result = result + '<button class="btn btn-outline-secondary del" type="button" id="inputGroupFileAddon04">X</button>'
			result = result + '</div>';
			$('#fileResult').append(result);
			count++;
		});
		
		// FileResult 안에 del을 click 했을 때
		$('#fileResult').on('click', ".del", function(){
			$(this).parent().remove();
			count--;
		});		
	}
	 
	 
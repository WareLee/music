$(document).ready(function() {
	// 登录或注册
	loginorreg();
	
	// 
	bindingchange();
});

function bindingchange(){
	$('.changeToRegister').toggle(
			function(){
				$('.loginSystemTitle').text('注册系统');
				$('.loginSubmit').attr('value','注册');
				$(this).text('登陆>>');
				
			},function(){
				$('.loginSystemTitle').text('登陆系统');
				$('.loginSubmit').attr('value','登陆');
				$(this).text('注册>>');
			}
	);
}

// 登录或者注册
function loginorreg(){
	$('input.loginSubmit').click(
		function(){
			var value=$(this).val();
			var theurl='';
			var username=$('#username').val();
			var password=$('#password').val();
			if(value=='登陆'){
				theurl="/music/login.action";
			}else if(value=='注册'){
				theurl="/music/register.action";
			}
			if(theurl!=''){
				$.ajax({
					type: "POST", // 请求类型,是POST还是GET
					url: theurl, // 请求得url地址
					async: true, // 是否异步
					data: 'username=' + username+'&password='+password, // 请求的参数数据
					success: function(result) { // 请求成功后执行该函数
						
						if(result.code>0){	// 登录成功
							$.cookie('username', result.username, { expires: 7 });
							$.cookie('userId', result.userId, { expires: 7 }); 
							$.cookie('token', result.token, { expires: 7 }); 
							$.cookie('lastTime', result.lastTime, { expires: 7 });
							$.cookie('sessionSid', result.sessionSid, { expires: 7 }); 
							
							window.location.href='/music/index.html';
						}else{
							$('#username').css('border-color','darkred');
							$('#password').css('border-color','darkred');
						}
					},
					error: function() { // 请求失败后执行该函数
						alert("登录失败");
					}
				});
			}
			
		}
	);
}
		
		
		
		

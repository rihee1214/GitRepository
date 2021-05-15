
$("#inputusername").blur(function(){
	const check = $("#inputusername").val();
	if(check.length<6){
		return;
	}else if(check.length>15){
		return;
	}
	$.ajax({
		type:"get",
		url: "./idcheck",
		data:{
			userName:check
		},
		success:function(data){
			$("#result").text(data);
			if(data=='사용할 수 없는 아이디 입니다.'){
				$("#result").css("color","red");
			}else{
				$("#result").css("color","blue");
			}
		},
		
	});
});

$("#inputusername").focus(function(){
	$("#result").empty();
});

$("#joinCheck").click(function(){
	const formtag = $("#regist-member");
	const checkid = formtag.find("input[name='userName']").val();
	const patternid = new RegExp(formtag.find("input[name='userName']").attr("pattern"));
	const checkpw = formtag.find("input[name='password']").val();
	const patternpw = new RegExp(formtag.find("input[name='password']").attr("pattern"));
	const checkname = formtag.find("input[name='name']").val();
	const patternname = new RegExp(formtag.find("input[name='name']").attr("pattern"));
	const checkemail = formtag.find("input[name='email']").val();
	const patternemail = new RegExp(formtag.find("input[name='email']").attr("pattern"));
	const checkphone = formtag.find("input[name='phone']").val();
	const patternphone = new RegExp(formtag.find("input[name='phone']").attr("pattern"));
	
	if(!patternid.test(checkid)){
		alert("아이디을 다시 확인해 주세요.");
		return;
	}else if(!patternpw.test(checkpw)){
		alert("비밀번호를 다시 확인해 주세요.");
		return;
	}else if(!patternname.test(checkname)){
		alert("이름을 다시 확인해 주세요.");
		return;
	}else if(!patternemail.test(checkemail)){
		alert("이메일을 다시 확인해 주세요.");
		return;
	}else if(!patternphone.test(checkphone)){
		alert("전화번호를 다시 확인해 주세요.");
		return;
	}
	
	formtag.submit();
});
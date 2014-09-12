// JavaScript Document
$(window).bind("load",function(){
//切换
$(".students-choice").click(function(){
	$(".students-choice").css("color","#f7941f").css("background","#fff");
	$(".teacher-choice").css("color","#fff").css("background","#f7941f");
	$("#register-teacher").hide();
	$("#register-student").show();
	})
$(".teacher-choice").click(function(){
	$(".teacher-choice").css("color","#f7941f").css("background","#fff");
	$(".students-choice").css("color","#fff").css("background","#f7941f");
	$("#register-student").hide();
	$("#register-teacher").show();
	})
//表单验证
$("form").elements[0].reset();
$("form").elements[1].reset();
//用户名验证
userNameChack("register-student");
userNameChack("register-teacher");
function userNameChack(formName){
$("form").getForm(formName).form("zhuce_user").bind("focus",function(){
	$("#"+formName+" .info_user").show();
	$("#"+formName+" .succ_user").hide();
	$("#"+formName+" .error_user").hide();
	$("#"+formName+" .error_repeat").hide();
	$("#"+formName+" .user_wait").hide();
	}).bind("blur",function(){
		$("form").getForm(formName).form("zhuce_user").value(trim($("form").getForm(formName).form("zhuce_user").value()));
		if($("form").getForm(formName).form("zhuce_user").value()==""){
			$("#"+formName+" .info_user").hide();
		}else if(/^[0-9a-z_]{4,20}$/.test($("form").getForm(formName).form("zhuce_user").value())){
			$("#"+formName+" .info_user").hide();
			$("#"+formName+" .user_wait").show();
			ajax({
				method:"post",
				async:true,
				url:"/translation/escape/servlet/JudgeServlet",
				data:{
					username:$("form").getForm(formName).form("zhuce_user").value(),
					},
				success:function(req){
						if(req){
							$("#"+formName+" .user_wait").hide();
							$("#"+formName+" .succ_user").show();
							}else{
							$("#"+formName+" .user_wait").hide();
							$("#"+formName+" .error_repeat").show();	
								
								}
					
					}
				})
			
				
		}else{
			$("#"+formName+" .error_user").show();
			$("#"+formName+" .succ_user").hide();
			$("#"+formName+" .info_user").hide();
			$("#"+formName+" .error_repeat").hide();
				}
		})
}
//密码验证
passChack("register-student");
passChack("register-teacher");
function passChack(formName){
$("form").getForm(formName).form("zhuce_mima").bind("focus",function(){
	$("#"+formName+" .info_pass").show();
	$("#"+formName+" .succ_pass").hide();
	$("#"+formName+" .error_pass").hide();
}).bind("blur",function(){
	if($("form").getForm(formName).form("zhuce_mima").value()==""){
		$("#"+formName+" .info_pass").hide();
		$("#"+formName+" .succ_pass").hide();
		$("#"+formName+" .error_pass").hide();
	}else if(this.checkUp()){
		$("#"+formName+" .info_pass").hide();
		$("#"+formName+" .succ_pass").show();
		$("#"+formName+" .error_pass").hide();
	}else{
		$("#"+formName+" .info_pass").hide();
		$("#"+formName+" .succ_pass").hide();
		$("#"+formName+" .error_pass").show();
		}
	
		
			})

$("form").getForm(formName).form("zhuce_mima").elements[0].checkUp=function(){
	var value=$("form").getForm(formName).form("zhuce_mima").value();
	var length=value.length;
	var code_length=0;
	//6-20 个字符
	if(length>=6&&length<=20){
		$("#"+formName+" .quan1").html("●").css("color","green")
	}else{
		$("#"+formName+" .quan1").html("○").css("color","#666")
	}
	//只能包含大小写字母、数字和非空格字符
	if(length>0&&!/\s/.test(value)){
		$("#"+formName+" .quan2").html("●").css("color","green")
	}else{
		$("#"+formName+" .quan2").html("○").css("color","#666")	
			}
	// 大、小写字母、数字、非空字符，2种以上
	if(/[\d]/.test(value)){
		code_length++
		}	
	if(/[a-z]/.test(value)){
		code_length++
		}
	if(/[A-Z]/.test(value)){
		code_length++
		}
	if(/[^0-9a-zA-Z]/.test(value)){
		code_length++
		}
	if(code_length>=2){
		$("#"+formName+" .quan3").html("●").css("color","green")
	}else{
		$("#"+formName+" .quan3").html("○").css("color","#666")	
			}	
	//安全级别
	if(code_length>=3&&length>=10){
		$("#"+formName+" .anquan1").css("color","green");
		$("#"+formName+" .anquan2").css("color","green");
		$("#"+formName+" .anquan3").css("color","green");
		$("#"+formName+" .anquan4").html("高").css("color","green");
	}else if(code_length>=2&&length>=8){
		$("#"+formName+" .anquan1").css("color","#f60");
		$("#"+formName+" .anquan2").css("color","#f60");
		$("#"+formName+" .anquan3").css("color","#ccc");
		$("#"+formName+" .anquan4").html("中").css("color","#f60");
	}else if(length>=1){
		$("#"+formName+" .anquan1").css("color","maroon");
		$("#"+formName+" .anquan2").css("color","#ccc");
		$("#"+formName+" .anquan3").css("color","#ccc");
		$("#"+formName+" .anquan4").html("低").css("color","maroon");
	}else{
		$("#"+formName+" .anquan1").css("color","#ccc");
		$("#"+formName+" .anquan2").css("color","#ccc");
		$("#"+formName+" .anquan3").css("color","#ccc");
		$("#"+formName+" .anquan4").html("").css("color","#ccc");		
		}
		if(length>=6&&length<=20&&!/\s/.test(value)&&code_length>=2){
		return true;
		}
		return false;
	}
$("form").getForm(formName).form("zhuce_mima").bind("keyup",$("form").getForm(formName).form("zhuce_mima").elements[0].checkUp)
	}
//确认密码
passSure("register-student");
passSure("register-teacher");
function passSure(formName){
$("form").getForm(formName).form("querenmima").bind("focus",function(){
	$("#"+formName+" .info_sure").show();
	$("#"+formName+" .succ_sure").hide();
	$("#"+formName+" .error_sure").hide();
	}).bind("blur",function(){
		if($("form").getForm(formName).form("querenmima").value()==""){
			$("#"+formName+" .info_sure").hide();
			}else if($("form").getForm(formName).form("querenmima").value()==$("form").getForm(formName).form("zhuce_mima").value()){
			$("#"+formName+" .info_sure").hide();
			$("#"+formName+" .succ_sure").show();
			$("#"+formName+" .error_sure").hide();
		}else{
			$("#"+formName+" .info_sure").hide();
			$("#"+formName+" .succ_sure").hide();
			$("#"+formName+" .error_sure").show();
			}
		})
}
//学历
$("form").getForm("register-teacher").form("teducation_bg").bind("focus",function(){
	$("#register-teacher .error_bg").hide();
	}).bind("blur",function(){
	if($("form").getForm("register-teacher").form("teducation_bg").value()=="0"){
	$("#register-teacher .error_bg").show();	
		}
	})
//教授语言
$("form").getForm("register-teacher").form("teach-which").bind("focus",function(){
	$("#register-teacher .error_tw").hide();
	}).bind("blur",function(){
	if($("form").getForm("register-teacher").form("teach-which").value()=="0"){
	$("#register-teacher .error_tw").show();	
		}
	})
//毕业院校
$("form").form("graduate").bind("focus",function(){
	$(".info_ans").show();
	$(".succ_ans").hide();
	$(".error_ans").hide();
	}).bind("blur",function(){
		$("form").form("graduate").value(trim($("form").form("graduate").value()));
		if($("form").form("graduate").value()==""){
			$(".info_ans").hide();
		}else if(/^.{2,20}$/.test($("form").form("graduate").value())){
			$(".succ_ans").show();
			$(".info_ans").hide();
			$(".error_ans").hide();	
		}else{
			$(".error_ans").show();
			$(".succ_ans").hide();
			$(".info_ans").hide();
				}
		})
//邮箱验证
emailChack("register-student");
emailChack("register-teacher");
function emailChack(formName){
$("form").getForm(formName).form("zhuce_email").bind("focus",function(){
	if($("form").getForm(formName).form("zhuce_email").value().indexOf("@")==-1){	
	$("#"+formName+" .all_email").show();}//补全系统
	$("#"+formName+" .info_email").show();
	$("#"+formName+" .succ_email").hide();
	$("#"+formName+" .error_email").hide();
	}).bind("blur",function(){
		$("#"+formName+" .all_email").hide();//补全系统
		$("#"+formName+" .all_email li").css("background","none").css("color","#666");
		$("form").getForm(formName).form("zhuce_email").elements[0].index=undefined;
		$("form").getForm(formName).form("zhuce_email").value(trim($("form").getForm(formName).form("zhuce_email").value()));
		if($("form").getForm(formName).form("zhuce_email").value()==""){
			$("#"+formName+" .info_email").hide();
		}else if(/^[\w\.\-]+@[\w\-]+(\.[a-zA-Z]{2,4}){1,2}$/.test($("form").getForm(formName).form("zhuce_email").value())){
			$("#"+formName+" .succ_email").show();
			$("#"+formName+" .info_email").hide();
			$("#"+formName+" .error_email").hide();	
		}else{
			$("#"+formName+" .error_email").show();
			$("#"+formName+" .succ_email").hide();
			$("#"+formName+" .info_email").hide();
				}
		})
		
		
//键入时显示列表
$("form").getForm(formName).form("zhuce_email").bind("keyup",function(eve){
	var event=getEvent(eve);
	target=getTarget(event);
	$("#"+formName+" .all_email li").css("background","none").css("color","#666");
	//实时监控
	if($("form").getForm(formName).form("zhuce_email").value().indexOf("@")==-1){	
	$("#"+formName+" .all_email").show();
	$("#"+formName+" .all_email li span").html($("form").getForm(formName).form("zhuce_email").value())
	}else{
		$("#"+formName+" .all_email").hide();
		
		}
	if(event.keyCode==40){
		if(target.index==undefined||target.index>=$("#"+formName+" .all_email li").elements.length-1){target.index=0;}else{target.index++;}
		$("#"+formName+" .all_email li").getElement(target.index).css("backgroundColor","#E5EDF2").css("color","#369");
		}
	if(event.keyCode==38){
		if(target.index==undefined||target.index<=0){target.index=$("#"+formName+" .all_email li").elements.length-1;}else{target.index--;}
		$("#"+formName+" .all_email li").getElement(target.index).css("backgroundColor","#E5EDF2").css("color","#369");	
		}
	if(event.keyCode==13){
		
		$("form").getForm(formName).form("zhuce_email").value($("#"+formName+" .all_email li").getElement(target.index).text());
		$("#"+formName+" .all_email li").css("background","none").css("color","#666");
		$("form").getForm(formName).form("zhuce_email").elements[0].index=undefined;
		$(".all_email").hide();
		}
	})
	
//悬停邮箱列表,点击
$("#"+formName+" .all_email li").hover(function(eve){
	var event=getEvent(eve);
	var target=getTarget(event);
	$("#"+formName+" .all_email li").css("background","none").css("color","#666");
		$("form").getForm(formName).form("zhuce_email").elements[0].index=undefined;
	$(target).css("backgroundColor","#E5EDF2").css("color","#369");
	},function(eve){
	var event=getEvent(eve);
	var target=getTarget(event);
	$(target).css("background","none").css("color","#666");
		})
		
$("#"+formName+" .all_email li").bind("mousedown",function(eve){//为什么不使用click事件，因为click事件是鼠标点击释放后才触发，当鼠标点下是已经出发了blur事件了，列表框已经隐藏了，所以我们要绑定为mouseover事件
	var event=getEvent(eve);
	var target=getTarget(event);
	$("form").getForm(formName).form("zhuce_email").value($(target).text())

	
	})
}
//手机号码
telChack("register-student");
telChack("register-teacher");
function telChack(formName){
	$("form").getForm(formName).form("tel-num").bind("focus",function(){
	$("#"+formName+" .info_tel").show();
	$("#"+formName+" .succ_tel").hide();
	$("#"+formName+" .error_tel").hide();
	}).bind("blur",function(){
	$("form").getForm(formName).form("tel-num").value(trim($("form").getForm(formName).form("tel-num").value()));
	if($("form").getForm(formName).form("tel-num").value()==""){
		$("#"+formName+" .info_tel").hide();	
	}else if(/^[18]\d{10}$/.test($("form").getForm(formName).form("tel-num").value())){
		$("#"+formName+" .info_tel").hide();
		$("#"+formName+" .succ_tel").show();
		$("#"+formName+" .error_tel").hide();
	}else{
		$("#"+formName+" .info_tel").hide();
		$("#"+formName+" .succ_tel").hide();
		$("#"+formName+" .error_tel").show();
		}
		})
	}

//出生日期
$("form").getForm("register-teacher").form("day").bind("focus",function(){
	$("#register-teacher .error_birth").hide();
	}).bind("blur",function(){
	if($("form").getForm("register-teacher").form("day").value()=="0"){
	$("#register-teacher .error_birth").show();	
		}
	})
var year=$("form").form("year");
var month=$("form").form("month");
var day=$("form").form("day");
var day30=[4,6,9,11];
var day31=[1,3,5,7,8,10,12];
//注入年
for(var i=1950,y=new Date().getFullYear();i<=y;i++){
	year.elements[0].add(new Option(i,i),undefined);
	
	}
//注入月
for(var i=1;i<=12;i++){
	month.elements[0].add(new Option(i,i),undefined);
	}

year.bind("change",innerDay);
month.bind("change",innerDay);
//注入日
function innerDay(){
	clearDay(day.elements[0]);
	
	if(year.elements[0].value!=0&&month.elements[0].value!=0){
		if(inArray(day30,month.elements[0].value)){
			for(var i=1;i<=30;i++){
			day.elements[0].add(new Option(i,i),undefined);
			}
		}else if(inArray(day31,month.elements[0].value)){
			for(var i=1;i<=31;i++){
			day.elements[0].add(new Option(i,i),undefined);
			}
		}else{
			if((parseInt(year.elements[0].value)%4==0&&parseInt(year.elements[0].value)%100!=0)||parseInt(year.elements[0].value)%400==0){
				for(var i=1;i<=29;i++){
					day.elements[0].add(new Option(i,i),undefined);
			}
			}else{
					for(var i=1;i<=28;i++){
					day.elements[0].add(new Option(i,i),undefined);
			}
				}
			}
		
	}
	
	}
//清空日
function clearDay(dayselectbox){
	for(var i=0,len=dayselectbox.options.length;i<len;i++){
		dayselectbox.remove(1)
		}
	
	}
function inArray(array,value){
	for(var i=0;i<array.length;i++){
		if(array[i]==value){return true;}
		}
		return false;
	}
//备注字数限制
var ex=parseInt($(".word_count span").html());
$("form").form("beizhu").bind("keyup",check_word)
	//清空多余字
$(".word_over span").getElement(1).click(function(){
	$("form").form("beizhu").value($("form").form("beizhu").value().substring(0,ex));
	check_word();
	})
$("form").form("beizhu").bind("paste",function(){
	setTimeout(check_word,50)
	})
function check_word(){
	var num=$("form").form("beizhu").value().length;
	if(num<=ex){
		$(".word_over").css("display","none");
		$(".word_count").css("display","block");
		$(".word_count span").html(ex-num);
		return true;
	}else{
		$(".word_over").css("display","block");
		$(".word_count").css("display","none");
		$(".word_over span").getElement(0).html(Math.abs(ex-num));//取绝对数
		return false;
		}
	}
$("form").getForm("register-student").form("sub").click(function(){
	var flag=true;
	if(!/^(\w){4,20}$/.test($("form").getForm("register-student").form("zhuce_user").value())){
		$("#register-student .error_user").show();
		flag=false;
	}
	if(!$("form").getForm("register-student").form("zhuce_mima").elements[0].checkUp()){
		$("#register-student .error_pass").show();
		flag=false;
		}
	if(!$("form").getForm("register-student").form("querenmima").value()==$("form").getForm("register-student").form("zhuce_mima").value()){
		$("#register-student .error_sure").show();
		flag=false;
		}
	if(!/^[\w\.\-]+@[\w\-]+(\.[a-zA-Z]{2,4}){1,2}$/.test($("form").getForm("register-student").form("zhuce_email").value())){
		$("#register-student .error_email").show();
		flag=false;
		}
	if(!/^1\d{10}$/.test($("form").getForm("register-student").form("tel-num").value())){
		$("#register-student .error_tel").show();
		flag=false;
		}
	if(flag){
	$("form").getForm("register-student").elements[0].submit();
	}
	})
$("form").getForm("register-teacher").form("sub").click(function(){
	var flag=true;
	if(!/^[0-9a-z_]{4,20}$/.test($("form").getForm("register-teacher").form("zhuce_user").value())){
		$("#register-teacher .error_user").show();
		flag=false;
	}
	if(!$("form").getForm("register-teacher").form("zhuce_mima").elements[0].checkUp()){
		$("#register-teacher .error_pass").show();
		flag=false;
		}
	if(!$("form").getForm("register-teacher").form("querenmima").value()==$("form").getForm("register-teacher").form("zhuce_mima").value()){
		$("#register-teacher .error_sure").show();
		flag=false;
		}
	if(!/^[\w\.\-]+@[\w\-]+(\.[a-zA-Z]{2,4}){1,2}$/.test($("form").getForm("register-teacher").form("zhuce_email").value())){
		$("#register-teacher .error_email").show();
		flag=false;
		}
	if(!/^1\d{10}$/.test($("form").getForm("register-teacher").form("tel-num").value())){
		$("#register-teacher .error_tel").show();
		flag=false;
		}
	if($("form").getForm("register-teacher").form("teach-which").value()=="0"){
		$("#register-teacher .error_tw").show();
		flag=false;
		}
	if($("form").getForm("register-teacher").form("teducation_bg").value()=="0"){
		$("#register-teacher .error_bg").show();
		flag=false;
		}
	if(!/^.{2,20}$/.test($("form").form("graduate").value())){
		$("#register-teacher .error_ans").show();
		flag=false;
		}
	if($("form").getForm("register-teacher").form("day").value()==0){
		$("#register-teacher .error_birth").show();
		flag=false;
		}
	if(!check_word()){
		flag=false;
		}
	if(flag){
	$("form").getForm("register-teacher").elements[0].submit();
	}
	})







})
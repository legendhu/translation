// JavaScript Document
//个人信息附近按钮
addEvent(window,"load",function(){
//选项卡按钮样式	
	var self_info_nav=$('.self-info-put li');
	self_info_nav.hover(navOver,navOut);
	
	function navOver(){
		$(this).css('background','#fabe77').css('borderLeft','solid 10px #f7941f').css('color','#fff');
		};
	function navOut(){
		$(this).css('background','url(images/bottom.jpg) no-repeat bottom center').css('borderLeft','none').css('color','#666');
			};
	cardShow(0,self_info_nav.elements[0]);		
	self_info_nav.click(function(){
		self_info_nav.hover(navOver,navOut);
		var index=$(this).index();
		cardShow(index,this);
		
		
		});
//选项卡
	function cardShow(index,element){
		$('.info-show .card').css('display','none').getElement(index).css('display','block');
		
		self_info_nav.css('background','url(images/bottom.jpg) no-repeat bottom center').css('borderLeft','none').css('color','#666');
		$(element).css('background','#d9edeb');
		removeEvent(element,'mouseover',navOver);
		removeEvent(element,'mouseout',navOut);
	}

//发表言论框
var forms=document.forms;
	for(var i=0,len=forms.length;i<len;i++){
		forms[i].reset();
		}
	$('.form .zhuangtai').bind('focus',function(){
		$(this).css('background','url(images/dasd.jpg) no-repeat left top');
	}).bind('blur',function(){
		if(this.value==''){
			$(this).css('background','url(images/vbnv.jpg) no-repeat left top');
			}		
		});	
		
//按钮	
	$('.form .fabiao').hover(function(){
			$(this).css('background','url(images/anniu2.png) no-repeat left top');
		},function(){
			$(this).css('background','url(images/anniu1.png) no-repeat left top');
		});
	$().getForm('form1').form('fabu').click(function(){
			if($().getForm('form1').form('zhuangtai').value()!=''&&check_word1()){
				document.forms['form1'].submit();	
				return true;
				}
				return false;
		});
	//字数限制
		//发布信息
	var ex=parseInt($(".form1 .word_count span").html());
	$(".form1").form("zhuangtai").bind("keyup",check_word1)
		//清空多余字
	$(".form1 .word_over span").getElement(1).click(function(){
		$(".form1").form("zhuangtai").value($(".form1").form("zhuangtai").value().substring(0,ex));
		check_word1();
		})
	$(".form1").form("zhuangtai").bind("paste",function(){
		setTimeout(check_word1,50)
		});
	function check_word1(){
		var num=$(".form1").form("zhuangtai").value().length;
		if(num<=ex){
			$(".form1 .word_over").css("display","none");
			$(".form1 .word_count").css("display","block");
			$(".form1 .word_count span").html(ex-num);
			return true;
		}else{
			$(".form1 .word_over").css("display","block");
			$(".form1 .word_count").css("display","none");
			$(".form1 .word_over span").getElement(0).html(Math.abs(ex-num));//取绝对数
			return false;
			}
		}

//个人信息
//学历
$("form").getForm("register-teacher").form("teducation_bg").bind("focus",function(){
	$("#gerenxinxi-box .error_bg").hide();
	}).bind("blur",function(){
	if($("form").getForm("register-teacher").form("teducation_bg").value()=="0"){
	$("#gerenxinxi-box .error_bg").show();	
		}
	})
//教授语言
$("form").getForm("register-teacher").form("teach-which").bind("focus",function(){
	$("#gerenxinxi-box .error_tw").hide();
	}).bind("blur",function(){
	if($("form").getForm("register-teacher").form("teach-which").value()=="0"){
	$("#gerenxinxi-box .error_tw").show();	
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

$("form").getForm("register-teacher").form("zhuce_email").bind("focus",function(){
	if($("form").getForm("register-teacher").form("zhuce_email").value().indexOf("@")==-1){	
	$("#gerenxinxi-box .all_email").show();}//补全系统
	$("#gerenxinxi-box .info_email").show();
	$("#gerenxinxi-box .succ_email").hide();
	$("#gerenxinxi-box .error_email").hide();
	}).bind("blur",function(){
		$("#gerenxinxi-box .all_email").hide();//补全系统
		$("#gerenxinxi-box .all_email li").css("background","none").css("color","#666");
		$("form").getForm("register-teacher").form("zhuce_email").elements[0].index=undefined;
		$("form").getForm("register-teacher").form("zhuce_email").value(trim($("form").getForm("register-teacher").form("zhuce_email").value()));
		if($("form").getForm("register-teacher").form("zhuce_email").value()==""){
			$("#gerenxinxi-box .info_email").hide();
		}else if(/^[\w\.\-]+@[\w\-]+(\.[a-zA-Z]{2,4}){1,2}$/.test($("form").getForm("register-teacher").form("zhuce_email").value())){
			$("#gerenxinxi-box .succ_email").show();
			$("#gerenxinxi-box .info_email").hide();
			$("#gerenxinxi-box .error_email").hide();	
		}else{
			$("#gerenxinxi-box .error_email").show();
			$("#gerenxinxi-box .succ_email").hide();
			$("#gerenxinxi-box .info_email").hide();
				}
		})
		
		
//键入时显示列表
$("form").getForm("register-teacher").form("zhuce_email").bind("keyup",function(eve){
	var event=getEvent(eve);
	target=getTarget(event);
	$("#gerenxinxi-box .all_email li").css("background","none").css("color","#666");
	//实时监控
	if($("form").getForm("register-teacher").form("zhuce_email").value().indexOf("@")==-1){	
	$("#gerenxinxi-box .all_email").show();
	$("#gerenxinxi-box .all_email li span").html($("form").getForm("register-teacher").form("zhuce_email").value())
	}else{
		$("#gerenxinxi-box .all_email").hide();
		
		}
	if(event.keyCode==40){
		if(target.index==undefined||target.index>=$("#gerenxinxi-box .all_email li").elements.length-1){target.index=0;}else{target.index++;}
		$("#gerenxinxi-box .all_email li").getElement(target.index).css("backgroundColor","#E5EDF2").css("color","#369");
		}
	if(event.keyCode==38){
		if(target.index==undefined||target.index<=0){target.index=$("#gerenxinxi-box .all_email li").elements.length-1;}else{target.index--;}
		$("#gerenxinxi-box .all_email li").getElement(target.index).css("backgroundColor","#E5EDF2").css("color","#369");	
		}
	if(event.keyCode==13){
		
		$("form").getForm("register-teacher").form("zhuce_email").value($("#gerenxinxi-box .all_email li").getElement(target.index).text());
		$("#gerenxinxi-box .all_email li").css("background","none").css("color","#666");
		$("form").getForm("register-teacher").form("zhuce_email").elements[0].index=undefined;
		$(".all_email").hide();
		}
	})
	
//悬停邮箱列表,点击
$("#gerenxinxi-box .all_email li").hover(function(eve){
	var event=getEvent(eve);
	var target=getTarget(event);
	$("#gerenxinxi-box .all_email li").css("background","none").css("color","#666");
		$("form").getForm("register-teacher").form("zhuce_email").elements[0].index=undefined;
	$(target).css("backgroundColor","#E5EDF2").css("color","#369");
	},function(eve){
	var event=getEvent(eve);
	var target=getTarget(event);
	$(target).css("background","none").css("color","#666");
		})
		
$("#gerenxinxi-box .all_email li").bind("mousedown",function(eve){//为什么不使用click事件，因为click事件是鼠标点击释放后才触发，当鼠标点下是已经出发了blur事件了，列表框已经隐藏了，所以我们要绑定为mouseover事件
	var event=getEvent(eve);
	var target=getTarget(event);
	$("form").getForm("register-teacher").form("zhuce_email").value($(target).text())

	
	})

//手机号码

	$("form").getForm("register-teacher").form("tel-num").bind("focus",function(){
	$("#gerenxinxi-box .info_tel").show();
	$("#gerenxinxi-box .succ_tel").hide();
	$("#gerenxinxi-box .error_tel").hide();
	}).bind("blur",function(){
	$("form").getForm("register-teacher").form("tel-num").value(trim($("form").getForm("register-teacher").form("tel-num").value()));
	if($("form").getForm("register-teacher").form("tel-num").value()==""){
		$("#gerenxinxi-box .info_tel").hide();	
	}else if(/^1\d{10}$/.test($("form").getForm("register-teacher").form("tel-num").value())){
		$("#gerenxinxi-box .info_tel").hide();
		$("#gerenxinxi-box .succ_tel").show();
		$("#gerenxinxi-box .error_tel").hide();
	}else{
		$("#gerenxinxi-box .info_tel").hide();
		$("#gerenxinxi-box .succ_tel").hide();
		$("#gerenxinxi-box .error_tel").show();
		}
		})
//备注字数限制
var ex=parseInt($("#gerenxinxi-box .word_count span").html());
$("form").form("beizhu").bind("keyup",check_word)
	//清空多余字
$("#gerenxinxi-box .word_over span").getElement(1).click(function(){
	$("form").form("beizhu").value($("form").form("beizhu").value().substring(0,ex));
	check_word();
	})
	//防止粘贴
$("form").form("beizhu").bind("paste",function(){
	setTimeout(check_word,50)//因为粘贴事件会在内容粘贴到文本框之前触发，当时字还没有输入进文本框，所以会发现没有检测，所以我们延迟一点时间触发
	})
function check_word(){
	var num=$("form").form("beizhu").value().length;
	if(num<=ex){
		$("#gerenxinxi-box .word_over").css("display","none");
		$("#gerenxinxi-box .word_count").css("display","block");
		$("#gerenxinxi-box .word_count span").html(ex-num);
		return true;
	}else{
		$("#gerenxinxi-box .word_over").css("display","block");
		$("#gerenxinxi-box .word_count").css("display","none");
		$("#gerenxinxi-box .word_over span").getElement(0).html(Math.abs(ex-num));//取绝对数
		return false;
		}
	}
//提交
$("form").getForm("register-teacher").form("sub").click(function(){
	var flag=true;
	if(!/^[\w\.\-]+@[\w\-]+(\.[a-zA-Z]{2,4}){1,2}$/.test($("form").getForm("register-teacher").form("zhuce_email").value())){
		$("#gerenxinxi-box .error_email").show();
		flag=false;
		}
	if(!/^1\d{10}$/.test($("form").getForm("register-teacher").form("tel-num").value())){
		$("#gerenxinxi-box .error_tel").show();
		flag=false;
		}
	if($("form").getForm("register-teacher").form("teach-which").value()=="0"){
		$("#gerenxinxi-box .error_tw").show();
		flag=false;
		}
	if($("form").getForm("register-teacher").form("teducation_bg").value()=="0"){
		$("#gerenxinxi-box .error_bg").show();
		flag=false;
		}
	if(!/^.{2,20}$/.test($("form").form("graduate").value())){
		$("#gerenxinxi-box .error_ans").show();
		flag=false;
		}
	if($("form").getForm("register-teacher").form("day").value()==0){
		$("#gerenxinxi-box .error_birth").show();
		flag=false;
		}
	if(!check_word()){
		flag=false;
		}
	if(flag){
	$("form").getForm("register-teacher").elements[0].submit();
	}
	})
//头像上传
	//头像上传
	$(document.forms['photo-send']['selected-photo']).bind('change',function(){
		document.forms['photo-send'].submit();
		})	
		$('#touxiangfasong').click(function(){
			ajax({
				method:"post",
				async:true,
				url:"/translation/front/servlet/UpLoadServlet",
				success:function(req){
					alert(req);
					location.reload(true);
					}
				})
		})	
	$('#fasongquxiao').click(function(){
			location.reload(true);
		})

		
		
//修改密码
	$('.xiugaimimaform .xiugaitijiao').hover(function(){
			$(this).css('background','url(images/anniu2.png) no-repeat left top');
		},function(){
			$(this).css('background','url(images/anniu1.png) no-repeat left top');
		});		
		
	//密码验证

	$("form").getForm('xiugaimimaform').form("gaihoumima").bind("focus",function(){
		$(".xiugaimimaform .info_pass").show();
		$(".xiugaimimaform .succ_pass").hide();
		$(".xiugaimimaform .error_pass").hide();
	}).bind("blur",function(){
		if($("form").getForm('xiugaimimaform').form("gaihoumima").value()==""){
			$(".xiugaimimaform .info_pass").hide();
			$(".xiugaimimaform .succ_pass").hide();
			$(".xiugaimimaform .error_pass").hide();
		}else if(checkUp()){
			$(".xiugaimimaform .info_pass").hide();
			$(".xiugaimimaform .succ_pass").show();
			$(".xiugaimimaform .error_pass").hide();
		}else{
			$(".xiugaimimaform .info_pass").hide();
			$(".xiugaimimaform .succ_pass").hide();
			$(".xiugaimimaform .error_pass").show();
			}
		
			
				});
				
	function checkUp(){
		var value=$("form").getForm('xiugaimimaform').form("gaihoumima").value();
		var length=value.length;
		var code_length=0;
		//6-20 个字符
		if(length>=6&&length<=20){
			$(".xiugaimimaform .quan1").html("●").css("color","green")
		}else{
			$(".xiugaimimaform .quan1").html("○").css("color","#666")
		}
		//只能包含大小写字母、数字和非空格字符
		if(length>0&&!/\s/.test(value)){
			$(".xiugaimimaform .quan2").html("●").css("color","green")
		}else{
			$(".xiugaimimaform .quan2").html("○").css("color","#666")	
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
			$(".xiugaimimaform .quan3").html("●").css("color","green")
		}else{
			$(".xiugaimimaform .quan3").html("○").css("color","#666")	
				}	
		//安全级别
		if(code_length>=3&&length>=10){
			$(".xiugaimimaform .anquan1").css("color","green");
			$(".xiugaimimaform .anquan2").css("color","green");
			$(".xiugaimimaform .anquan3").css("color","green");
			$(".xiugaimimaform .anquan4").html("高").css("color","green");
		}else if(code_length>=2&&length>=8){
			$(".xiugaimimaform .anquan1").css("color","#f60");
			$(".xiugaimimaform .anquan2").css("color","#f60");
			$(".xiugaimimaform .anquan3").css("color","#ccc");
			$(".xiugaimimaform .anquan4").html("中").css("color","#f60");
		}else if(length>=1){
			$(".xiugaimimaform .anquan1").css("color","maroon");
			$(".xiugaimimaform .anquan2").css("color","#ccc");
			$(".xiugaimimaform .anquan3").css("color","#ccc");
			$(".xiugaimimaform .anquan4").html("低").css("color","maroon");
		}else{
			$(".xiugaimimaform .anquan1").css("color","#ccc");
			$(".xiugaimimaform .anquan2").css("color","#ccc");
			$(".xiugaimimaform .anquan3").css("color","#ccc");
			$(".xiugaimimaform .anquan4").html("").css("color","#ccc");		
			}
			if(length>=6&&length<=20&&!/\s/.test(value)&&code_length>=2){
			return true;
			}
			return false;
		}
	$("form").getForm('xiugaimimaform').form("gaihoumima").bind("keyup",checkUp);	
			
	//确认密码
	
	$("form").getForm('xiugaimimaform').form("querengaihoumima").bind("focus",function(){
		$(".xiugaimimaform .info_sure").show();
		$(".xiugaimimaform .succ_sure").hide();
		$(".xiugaimimaform .error_sure").hide();
		}).bind("blur",function(){
			if($("form").getForm('xiugaimimaform').form("querengaihoumima").value()==""){
				$(".xiugaimimaform .info_sure").hide();
				}else if($("form").getForm('xiugaimimaform').form("querengaihoumima").value()==$("form").getForm('xiugaimimaform').form("gaihoumima").value()){
				$(".xiugaimimaform .info_sure").hide();
				$(".xiugaimimaform .succ_sure").show();
				$(".xiugaimimaform .error_sure").hide();
			}else{
				$(".xiugaimimaform .info_sure").hide();
				$(".xiugaimimaform .succ_sure").hide();
				$(".xiugaimimaform .error_sure").show();
				}
			});		
	//确认修改
	$(".xiugaimimaform .xiugaitijiao").click(function(){
		var flag=true;
		if(document.forms.xiugaimimaform.yuashimima.value==""){
			flag=false;
			alert("当前密码不能为空！")
			}
		if(!checkUp()){
			flag=false;
			$(".xiugaimimaform .error_pass").show()
			}
		if($("form").getForm('xiugaimimaform').form("querengaihoumima").value()!=$("form").getForm('xiugaimimaform').form("gaihoumima").value()){
			flag=false;
			$(".xiugaimimaform .error_sure").show();
			}
		if(flag){
		var fun=arguments.callee;
		removeEvent(this,'click',arguments.callee);
		$(".xiugaimima .xiugai_wait").show();
		this.style.cursor="default"
		var that=this;
		ajax({
			method:"post",
		async:true,
		url:"/translation/servlet/ChangePassServlet",
		data:{
			pass1:this.form.yuashimima.value,
			pass2:this.form.gaihoumima.value
		},
		success:function(req){
			if(/^success$/.test(req)){
				$(".xiugaimima .xiugai_wait").hide();
				addEvent(that,'click',fun);
				location.reload(true);
				
			}else if(/^no user$/.test(req)){
				$(".xiugaimima .xiugai_wait").hide();
				addEvent(that,'click',fun);
				$(".login_box").css("display","block").center(350,400);
				$("#screen").lock().css("display","block").opacityChange({target:30,type:1});
				
			}else{
			$(".xiugaimima .xiugai_wait").hide();
			addEvent(that,'click',fun);
			alert(req)
			}
			}
			});
		}
		
		})			
		
		//设置密保
	//获取问题
		var ques=[];

			ajax({
				method:"get",
				async:true,
				url:"/translation/shasha/passQue.json",
				success:function(req){
					var jsonque=eval("("+req+")");
					for(i in jsonque){
						ques.push(jsonque[i]);
						}
					$('#que').addOption(ques);
					}
				});
	//提交
	$('#daan').bind('focus',function(){
			$('.mimabaohu .daan span').css('color','green').html('请输入4到20字答案');
		}).bind('blur',function(){
			if(!(this.form.daan.value.length>=2&&this.form.daan.value.length<=20)){
				$('.mimabaohu .daan span').css('color','red').html('答案不符合要求');	
				}else{
					$('.mimabaohu .daan span').css('color','green').html('可用');
					}
			});
	$('#que').bind('focus',function(){
			$('.mimabaohu .que span').html('');	
		}).bind('blur',function(){
			if(this.form.que.value==0){
				$('.mimabaohu .que span').css('color','red').html('请选择问题');	
				}else{
					$('.mimabaohu .que span').html('');
					}
					
				})		
	$('.mimabaohu .tijiaomibao').hover(function(){
			$(this).css('background','url(images/anniu2.png) no-repeat left top');
		},function(){
			$(this).css('background','url(images/anniu1.png) no-repeat left top');
		}).click(function(){
			var flag=true;
			if(this.form.que.value==0){
				flag=false;
				$('.mimabaohu .que span').css('color','red').html('请选择问题');
				}
			if(!(this.form.daan.value.length>=2&&this.form.daan.value.length<=20)){
				flag=false;
				$('.mimabaohu .daan span').css('color','red').html('答案不符合要求');
				}
				if(flag==true){
					document.forms.mimabaohu.submit();
					}
		});	
	//修改价格
	$('.kechengtijiao input').hover(function(){
			$(this).css('background','url(images/anniu2.png) no-repeat left top');
		},function(){
			$(this).css('background','url(images/anniu1.png) no-repeat left top');

		}).bind('click',function(){
			if($('#xiugaikechengjiage').value()==""){
				alert('修改价格为空！');
				return false;	
			}
			if(!/^\d+$/.test($('#xiugaikechengjiage').value())){
				alert('请输入数字！');
				return false;
				}
			if(parseInt($('#xiugaikechengjiage').value())<30){
				alert('设置的价格不能低于30元！');
				return false;	
			}
			if(confirm("确认要修改？")){
			}else{
				return false;
				}
			document.forms.kechengjiage.submit();
		});
//填充选项卡

	document.getElementById("teducation_bg").options[getOpIndex(document.getElementById("teducation_bg"),education_in)].selected=true;
	document.getElementById("teach-which").options[getOpIndex(document.getElementById("teach-which"),language_in)].selected=true;
function getOpIndex(ele,val){
	var op=ele.options;
	for(var i=1,len=op.length;i<len;i++){
		if(op[i].value==val){
			return i;
		}
		return 0
	}
}

		
})

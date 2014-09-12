// JavaScript Document
//封装ajax
function createXHR(){
	if(typeof XMLHttpRequest!="undefined"){
		return new XMLHttpRequest();
	}else if(typeof ActiveXObject!="undefined"){
		var versions=["MSXML2.XMLHttp.6.0","MSXML2.XMLHttp.3.0","MSXML2.XMLHttp"];
		for(var i=0;i<versions.length;i++){
			try{
			return new ActiveXObject(versions[i])	
			}catch(ex){//跳过
			}	
			}
	}else{throw new Error("您的系统不支持XHR对象")}
		
	
	}
function params(data){
	var arr=[];
	for(i in data){
		arr.push(encodeURIComponent(i)+"="+encodeURIComponent(data[i]))
		}
	return arr.join("&");
	};
function ajax(obj){
	var xhr=createXHR();
	obj.url=obj.url+"?rand="+Math.random();
	obj.data=params(obj.data);
	if(obj.method=="get"){
		obj.url=(obj.url.indexOf("?")==-1)?obj.url+"?"+obj.data:obj.url+"&"+obj.data
		}
	if(obj.async==true){
		xhr.onreadystatechange=function(){
		if(xhr.readyState==4){
			callBack()
			}
		}
	}
	xhr.open(obj.method, obj.url, obj.async);
	if(obj.method=="post"){
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send(obj.data)
		}else{
			xhr.send(null)
			}
	if (obj.async == false) {
		callBack();
}
	
	function callBack(){
		if((xhr.status>=200&&xhr.status<300)||xhr.status==304){
				obj.success(xhr.responseText);
			}else{
				alert("数据返回失败！状态代码：" + xhr.status + "，状态信息:" + xhr.statusText)
				}
		}
	}

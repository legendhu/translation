//连缀
function Lianzhui(arg){
	this.elements=[];
	/*如果元素组写在外面Lianzhui.prototype.elements=[]这样会使每个Lianzhui实例都能重写它,因为之后用的都是push方法添加给elements数组，所以操作的是原型对象中的elements，而不是又为每个实例又重新添加elements属性,所以	下面这样写颜色最后都为绿色     
	$().getId("odiv").css("color","red");
	$().getClass("zi").css("color","blue")*/
	if(typeof arg=="object"){
		this.elements[0]=arg;
		}else if(typeof arg=="string"){
	if(arg.indexOf(" ")==-1){//单个选择器
		switch(arg.charAt(0)){
			case "#":
			this.elements.push(this.getId(arg.substring(1)));
			break;
			case ".":
			this.elements=this.getClass(arg.substring(1));
			break;
			default:
			this.elements=this.getTag(arg)
			}
		}
     
     if(arg.indexOf(" ")!=-1){//但是这样的选择器不好，可能会重复选择同一个元素，比如div嵌套div里有一个class为‘aa’的元素只有一个，但会出现$('div .aa').length==2，是因为两个div首先都被收录到parentnode中再选‘aa’，所以有两个。
	     var strs=arg.split(" ");
	     var node=[];//装父节点,且是一个数组，因为后面要用到length
	     var chidElements=[];
	     for(var i=0;i<strs.length;i++){
		     if(node.length==0){
			     node.push(document);
			     }
		     switch(strs[i].charAt(0)){
			case "#":
			chidElements=[];
			chidElements.push(this.getId(strs[i].substring(1)));
			node=chidElements;
			break;
			case ".":
			chidElements=[];
			for(var j=0;j<node.length;j++){
		 	var tem=this.getClass(strs[i].substring(1),node[j]);
			for(var k=0;k<tem.length;k++){
				chidElements.push(tem[k]);
				}
			}
			node=chidElements;
			break;
			default:
			chidElements=[];
			for(var j=0;j<node.length;j++){
		 	var tem=this.getTag(strs[i],node[j]);
			for(var k=0;k<tem.length;k++){
				chidElements.push(tem[k]);
				}
			}
			node=chidElements;
			}
		     }
	     
	     this.elements=node;
	     
	     }
		}
	     //获取elements数组长度
	     this.length=this.elements.length;
	};



//后代子选择器
Lianzhui.prototype.find=function(arg){
	var childElements=[];
		for(var i=0;i<this.elements.length;i++){
			
		switch(arg.charAt(0)){
			case "#":
			childElements.push(this.getId(arg.substring(1)))
			break;
			case ".":
			var tem1=this.getClass(arg.substring(1),this.elements[i]);
			for(var j=0;j<tem1.length;j++){
				childElements.push(tem1[j])
				}
			break;
			default:
				var tem2=this.getTag(arg,this.elements[i]);
			for(var j=0;j<tem2.length;j++){
				childElements.push(tem2[j])
				}
			}
		
		}
	this.elements=childElements;
	return this;
	//获取elements数组长度
	this.length=this.elements.length;
	}

//创建连缀实例
function $(arg){
	return new Lianzhui(arg);
	}

//获得id节点

Lianzhui.prototype.getId=function(id){
     return document.getElementById(id);
	}

//获得name节点数组

Lianzhui.prototype.getName=function(name){
	var tags=document.getElementsByName(name);
	for(var i=0;i<tags.length;i++){
		this.elements.push(tags[i])
		}
	
	return this;
	}

//获取tag节点数组


Lianzhui.prototype.getTag=function(tag,parentnode){
	var node=null;
	if(parentnode!=undefined){
		node=parentnode;
		}else{
			node=document;
			}
		
	
	var tags=node.getElementsByTagName(tag);
	/*for(var i=0;i<tags.length;i++){
		tem.push(tags[i])
		}*/
	return tags;
	}

//获取class节点数组
Lianzhui.prototype.getClass=function(className,parentnode){
		var node=null;
	if(parentnode!=undefined){
		node=parentnode;
		}else{
			node=document;
			}
		var element=[];
	var all=node.getElementsByTagName("*");
	for(var i=0;i<all.length;i++){
		//if(all[i].className==className){
		if(new RegExp("(\\s|^)"+className+"(\\s|$)").test(all[i].className)){
			element.push(all[i]);	
		}
	}
	return element;
}
//获取表单
Lianzhui.prototype.getForm=function(name){
	var tem=[];
	tem.push(document.forms[name]);//通过getElementsByTagName()获取的HTMLCollection在chrome中不能使用按名称访问项；所以换为此方法获取form
	this.elements=tem;
	return this;
	}
//获取表单字段
Lianzhui.prototype.form=function(name){
	var element=[];
	for(var i=0;i<this.elements.length;i++){
		element.push(this.elements[i]);
	}
	this.elements=element;//这块有点蒙，好像是nodelist不是普通的数组不能重写；所以得重新把他们传给另一个数组再传回来就变成普通的数组了；
	for(var i=0;i<this.elements.length;i++){
		this.elements[i]=this.elements[i][name];
		if(typeof this.elements[i]=="undefined"){
			this.elements.splice(i,1);
			i--;
			}
		}
		return this;
	}
//获取表单字段value值
Lianzhui.prototype.value=function(value){
	
	for(var i=0;i<this.elements.length;i++){
	    if(arguments.length==0){
			return this.elements[i].value;
			}
		else{
		this.elements[i].value=value;
		}
		}
		return this
		}

//innerHTML
Lianzhui.prototype.html=function(html){
	
	for(var i=0;i<this.elements.length;i++){
	    if(arguments.length==0){
			return this.elements[i].innerHTML;
			}
		else{
		this.elements[i].innerHTML=html;
		}
		}
		return this
		}
//innerText
Lianzhui.prototype.text=function(text){
	
	for(var i=0;i<this.elements.length;i++){
	    if(arguments.length==0){
			return getText(this.elements[i]);
			}
		else{
		setText(this.elements[i],text)
		}
		}
		return this
		}

//获取节点属性
//获取节点属性
Lianzhui.prototype.attr=function(attr,value){
	if(arguments.length==1){
	return this.elements[0].getAttribute(attr);
	}else if(arguments.length==2){
		this.elements[0].setAttribute(attr,value)
		}
	return this;
	}
//获取父节点中某子节点的索引
Lianzhui.prototype.index=function(){
	var children=this.elements[0].parentNode.children;//childNodes有的浏览器包含空格的的文本节点，children只包含实际节点
	for(var i=0;i<children.length;i++){
		if(this.elements[0]==children[i]){
			return i
			}
		}
	}
		
//添加css

Lianzhui.prototype.css=function(attr,value){
	for(var i=0;i<this.elements.length;i++){
	if(arguments.length==1){
		if(typeof window.getComputedStyle=="function"){
			return window.getComputedStyle(this.elements[i],null)[attr];
			}else if(typeof this.elements[i].currentStyle=="object"){
				return this.elements[i].currentStyle[attr];
		}
		}else{
		this.elements[i].style[attr]=value;
	}}
	return this;
	}
	
	
//为节点注册点击事件
Lianzhui.prototype.click=function(func){
	for(var i=0;i<this.elements.length;i++){
	addEvent(this.elements[i],"click",func)
	}
	return this;
	}
//为元素注册事件
Lianzhui.prototype.bind=function(event,fn){
	for(var i=0;i<this.elements.length;i++){
	addEvent(this.elements[i],event,fn);
	}
	return this;
	
	}
//获取元素组中的单个元素
Lianzhui.prototype.getElement = function (num) {
var element = this.elements[num];
this.elements = [];
this.elements[0] = element;
return this;
}

//显示
Lianzhui.prototype.show=function(){
	for(var i=0;i<this.elements.length;i++){
		this.elements[i].style.display="block"
	}
	return this;
	}
	
	
	
	
//隐藏
Lianzhui.prototype.hide=function(){
	for(var i=0;i<this.elements.length;i++){
		this.elements[i].style.display="none"
	}
	return this;
	}

//鼠标滑入滑出
Lianzhui.prototype.hover=function(over,out){
	for(var i=0;i<this.elements.length;i++){
		addEvent(this.elements[i],"mouseover",over)
		addEvent(this.elements[i],"mouseout",out)
		}
	
	return this;
		}
		
//事件切换
Lianzhui.prototype.next=function(){
	for(var i=0;i<this.elements.length;i++){
		(function(element,arg){
		var num=0;//计数器
		addEvent(element,"click",function(eve){
			arg[num].call(element);
			num=(++num)%arg.length;//这是一个闭包，在闭包内可以外面的变量
		})
			})(this.elements[i],arguments)//因为闭包是用的是外部函数运行完毕后所保留的值，所以需要这样把element和num的是保留住，相当于快照；
			}
	
	return this;
	
	}
	

//设置物体居中

Lianzhui.prototype.center=function(height,width){
	for(var i=0;i<this.elements.length;i++){
	var login_height=(document.documentElement.clientHeight-height)/2;
	var login_width=(document.documentElement.clientWidth-width)/2;
  	var scrollY=(document.body.scrollTop>=document.documentElement.scrollTop)?document.body.scrollTop:document.documentElement.scrollTop;
	var scrollX=(document.body.scrollLeft>=document.documentElement.scrollLeft)?document.body.scrollLeft:document.documentElement.scrollLeft;
      this.elements[i].style.top=login_height+scrollY+"px";
	this.elements[i].style.left=login_width+scrollX+"px";
	}
	return this;
	}
//锁屏功能
Lianzhui.prototype.lock=function(){
	for(var i=0;i<this.elements.length;i++){
	var height=(document.body.scrollHeight>=document.documentElement.scrollHeight)?document.body.scrollHeight:document.documentElement.scrollHeight;
	var width=(document.body.scrollWidth>=document.documentElement.scrollWidth)?document.body.scrollWidth:document.documentElement.scrollWidth;
	this.elements[i].style.height=height+"px";
	this.elements[i].style.width=width+"px";
		
	}
	return this;
	}
	
	
	
//保持位置
Lianzhui.prototype.keepPosition=function(){
	for(var i=0;i<this.elements.length;i++){
		var element=this.elements[i];
		if(element.offsetLeft+element.offsetWidth>document.documentElement.clientWidth){
			element.style.left=document.documentElement.clientWidth-element.offsetWidth+"px";
			}
		if(element.offsetTop+element.offsetHeight>document.documentElement.clientHeight){
			element.style.top=document.documentElement.clientHeight-element.offsetHeight+"px";
			}
       
		}
	return this;
	}


//直线运动
Lianzhui.prototype.change=function(obj){
	for(var i=0;i<this.elements.length;i++){
	var element=this.elements[i]
	
	var attr=obj['attr']== 'x'?'left':obj['attr']== 'y'?'top':obj['attr']== "w"?"width":obj['attr']=="h"?"height":obj['attr']!=undefined?obj['attr']:"left"
	var start = obj['start'] != undefined ? obj['start']:parseInt(getStyle(element,attr));
	var t = obj['t'] != undefined ? obj['t'] : 30;
	var step = obj['step'] != undefined ? obj['step'] : 10;
	var target =obj['diff']!=undefined?obj['diff'] + start:obj['target']!=undefined?obj['target']:0;
	var speed=obj["speed"]!=undefined?obj["speed"]:10;
	var type=obj['type']==0?"constant":obj['type']==1?"buffer":"buffer";
	var fn=obj['fn'];
	var mul=obj["mul"];//设置同步动画必须type为1
	
	
	clearInterval(element.timer);
	if(start>target){step=-step};
	element.style[attr] = start + 'px';
	if(mul==undefined){
		mul={};
		mul[attr]=target;
		}
	element.timer=setInterval(function(){
		var boll=true;
		for(i in mul){
			attr=i=="x"?"left":i=="y"?"top":i=="w"?"width":i=="h"?"height":i!=undefined?i:"left"
			target=mul[i]

		if(type=="buffer"){
		var temp = (target - parseInt(getStyle(element,attr))) / speed;
		step =temp > 0 ? Math.ceil(temp) : Math.floor(temp);
		}
	element.style[attr]=parseInt(getStyle(element,attr))+step+"px";
	if(step==0){element.style[attr]=target+"px";
	}else if(step>0&&parseInt(getStyle(element,attr))>=target){
		element.style[attr]=target+"px";
	}else if(step<0&&parseInt(getStyle(element,attr))<=target){
		element.style[attr]=target+"px";
		}else{boll=false;}
			//$("#aa").elements[0].innerHTML+=parseInt(getStyle(element,attr))+","+step+","+boll+"<br/>"
		}
	if(boll){
		clearInterval(element.timer);
		if(fn!=undefined)fn();
	}
	
	},t)
		}
	return this
	}









//渐变效果
Lianzhui.prototype.opacityChange=function(obj){
	for(var i=0;i<this.elements.length;i++){
		var element=this.elements[i]//因为调用setInterval方法的是window
		clearInterval(element.timer2);//第一次window.timer2是undefined第二次才有值，只要是对象存在就不会抛出错误，如果直接写timer2虽然算是window的属性但是会跑出错误,又因为涉及多个动画同时间段进行用一个ID是不行的，所以用element.timer2每个元素用一个ID；
		var step=obj['step']!=undefined?obj['step']:3;
		var target=obj['target']!=undefined?obj['target']:100;
		var start=obj['start']!=undefined?obj['start']:parseFloat(getStyle(element,"opacity"))*100;
		var t=obj['t']!=undefined?obj['t']:50;
		var speed=obj['speed']!=undefined?obj['speed']:8;
		var type=obj['type']==0?"constant":obj['type']==1?"buffer":"constant";
		var fn=obj['fn']
		
		
		element.style.opacity=start/100;
		element.style.filter="alpha(opacity="+start+")";
	if(start>target){step=-step}
		element.timer2=setInterval(function(){
		if(type=="buffer"){
		if(step>0){
		step=Math.ceil((target-parseFloat(getStyle(element,"opacity"))*100)/speed)
		}else{
		step=Math.floor((target-parseFloat(getStyle(element,"opacity"))*100)/speed)
			}
		}
	//计算样式返回的值都是字符串,所以要用parseFloat先转换Number类型
			//document.getElementById("header").innerHTML+=parseFloat(getStyle(element,"opacity"))+","+step+"--"+parseFloat(getStyle(element,"opacity"))*100+"--"+(parseFloat(getStyle(element,"opacity"))*100+step)/100+"<br>"
		
		element.style.opacity=(parseFloat(getStyle(element,"opacity"))*100+step)/100;
		if(parseFloat(getStyle(element,"opacity"))<0.01){element.style.opacity=0}//解决了大问题，因为chremo计算到最后会出现0.00999999999999-1=3.5454564e9这样element.style.opacity不能写入，所以不行，所以要在此加一个判断，不能加在前面，因为如果是从0增加透明度的话会一直是0。
		element.style.filter="alpha(opacity="+(parseFloat(getStyle(element,"opacity"))*100+step)+")";
		if(step>0&&parseFloat(getStyle(element,"opacity"))>=target/100){
			element.style.opacity=target/100;
			element.style.filter="alpha(opacity="+target+")";
			clearInterval(element.timer2);
			if(fn!=undefined)fn();
			}else if(step<0&&parseFloat(getStyle(element,"opacity")/*chrome这块不行减少的时候一直第一是0.009999999,因为0.01=+0.009=0.01000000009*/)<=target/100){
				element.style.opacity=target/100;
			element.style.filter="alpha(opacity="+target+")";
			clearInterval(element.timer2);
			if(fn!=undefined)fn();
				}
	
		},t)
	
	
		}
	return this
	}
	
//透明度设置
Lianzhui.prototype.opacity=function(num){
	for(var i=0;i<this.elements.length;i++){
	this.elements[i].style.opacity=num/100;
	this.elements[i].style.filter="alpha(opacity="+num+")";
		}
	return this
	}
//向选项卡注入选项
Lianzhui.prototype.addOption=function(optionvalue){//参数为数组
	for(var i=0;i<this.elements.length;i++){
		for(var j=0,len=optionvalue.length;j<len;j++){
			this.elements[i].add(new Option(optionvalue[j],optionvalue[j]),undefined);
			}
		}
	return this
	
	}

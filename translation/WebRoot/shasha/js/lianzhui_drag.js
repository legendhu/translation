// JavaScript Document

//拖拽功能
Lianzhui.prototype.move=function(id){
	for(var i=0;i<this.elements.length;i++){
			var _this=this.elements[i];
	addEvent(this.elements[i],"mousedown",function(eve){
	var Event=getEvent(eve);
	var target=getTarget(Event);
	//preventDefault(Event);//兼容早期火狐浏览器中空块不能拖动
	if(target.id==id){
	var detaX=Event.clientX-_this.offsetLeft;
	var detaY=Event.clientY-_this.offsetTop;
	_this.style.cursor="move"
	
	function fn(ev){
		if (_this.setCapture) {
    		 _this.setCapture();//兼容ie浏览器鼠标移到浏览器外部后鼠标事件失效
     		 }
		var Event2=getEvent(ev);
		var left=Event2.clientX-detaX
		var top=Event2.clientY-detaY
		if(left<0){
			left=0;
			}else if(left+_this.offsetWidth>document.documentElement.clientWidth){
		left=document.documentElement.clientWidth-_this.offsetWidth};
		if(top<0){
			top=0;
			}else if(top+_this.offsetHeight>document.documentElement.clientHeight){
				top=document.documentElement.clientHeight-_this.offsetHeight;
				}
		_this.style.left=left+"px";
		_this.style.top=top+"px";
		}
		
	addEvent(document,"mousemove",fn)
	
	function fuc(){
	
		removeEvent(document,"mousemove",fn);
		_this.style.cursor="auto";
		removeEvent(document,"mouseup",fuc);
		if (_this.releaseCapture) {
			_this.releaseCapture();
				}//兼容ie浏览器鼠标移到浏览器外部后鼠标事件失效
		
		}
		addEvent(document,"mouseup",fuc)
		}
	
	})
	}
	return this;
	}
	
	
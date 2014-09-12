// JavaScript Document
//轮播
addEvent(window,"load",function(){
$(".ad strong").hover(function(){
	$(this).css("background","#000");
},function(){
	$(this).css("background","none");
});
	//前一个
function prvIndex(index,len){
	var prv=index==0?len-1:index-1;
	return prv;
	}
	//下一个
function nextIndex(index,len){
	var next=(index+1)%len;
	return next;
	} 
	//轮播初始化
$(".ad li").getElement(0).css("left","0");
var lunbo_index=0; 
var length=$(".ad li").length;
	//手动轮播
$(".ad .gt").click(function(){
	if(parseInt(getStyle($(".ad li").getElement(lunbo_index).elements[0],"left"))==0){
		clearInterval(timer);
		lunbo();
		timer=setInterval(lunbo,3000);
	}
	});
$(".ad .lt").click(function(){
	if(parseInt(getStyle($(".ad li").getElement(lunbo_index).elements[0],"left"))==0){
			clearInterval(timer);
		$(".ad li").getElement(prvIndex(lunbo_index,length)).css("left","670px").change({attr:"x",target:0,type:1,speed:7});
		$(".ad li").getElement(lunbo_index).change({attr:"x",target:-670,type:1,speed:7});
		lunbo_index=prvIndex(lunbo_index,length);
		timer=setInterval(lunbo,3000);
		}
	});
//自动轮播
var timer=setInterval(lunbo,3000);
function lunbo(){
	$(".ad li").getElement(nextIndex(lunbo_index,length)).css("left","-670px").change({attr:"x",target:0,type:1,speed:7});
	$(".ad li").getElement(lunbo_index).change({attr:"x",target:670,type:1,speed:7});
	lunbo_index=nextIndex(lunbo_index,length);
	}
//广告位
	$('.xuanfyguanggao .guanbi').click(function(){
		$(this.parentNode).hide();
		})

});
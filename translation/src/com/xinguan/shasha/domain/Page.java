package com.xinguan.shasha.domain;
//分页
import java.util.List;

public class Page {
	private int total;//总记录数
	private int showCount = 12;//每页展示数量
	private int pageCount;//显示页码
	private int num = 1;//展示第*页
	private int start = 0;//起始查询数
	private List list = null;//存储页面数据的list
	private int begin;//开始页码
	private int end;//结束页码
	private int length = 5;//固定展示*页码
	
	//构造方法
	public Page(){}
	
	public Page(int total,int num){
		//根据总数算出显示多少页
		this.total=total;
		if(total%this.showCount==0){
			pageCount = this.total/this.showCount;
		}else{
			pageCount =this.total/this.showCount + 1;
		}
		//根据第*页算出从第*数据开始查询
		this.num = num;
		this.start = (this.num-1)*this.showCount;
		//根据当前页码算出begin，end
		if(this.pageCount>this.length){
			this.begin = num-((this.length-1)/2);
			this.end = num +((this.length-1)/2);
			if(this.begin<1){
				this.begin=1;
				this.end =this.length;
			}
			if(this.end>this.pageCount){
				this.begin = this.pageCount-this.length;
				this.end=this.pageCount;
			}
		}else{
			this.begin = 1;
			this.end = pageCount;
		}
	}
	
	public Page(int total,int num,int showCount){
		//根据总数算出显示多少页
		this.showCount = showCount;
		this.total= total;
		if(total%showCount==0){
			pageCount = this.total/showCount;
		}else{
			pageCount =this.total/showCount + 1;
		}
		//根据第*页算出从第*数据开始查询
		this.num = num;
		this.start = (this.num-1)*this.showCount;
		//根据当前页码算出begin，end
		if(this.pageCount>this.length){
			this.begin = num-((this.length-1)/2);
			this.end = num +((this.length-1)/2);
			if(this.begin<1){
				this.begin=1;
				this.end =this.length;
			}
			if(this.end>this.pageCount){
				this.begin = this.pageCount-this.length;
				this.end=this.pageCount;
			}
		}else{
			this.begin = 1;
			this.end = pageCount;
		}
	}
	
	//Getters  and Setters....
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getShowCount() {
		return showCount;
	}
	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
}

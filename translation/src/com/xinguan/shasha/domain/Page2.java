package com.xinguan.shasha.domain;

import java.util.List;

public class Page2 {
	private int totalrecord;//总记录数
	private int pagesize=10;//每夜显示的记录数
	private int totalpage;//页码数
	private int startindex;//从数据库哪个地方开始取值
	private List list;//把某一页的数据封装在list中
	private int pagenum;//记录当前页码号
	private int forEachBegin;//jsp页面foreach标签循环的开始页码
	private int forEachEnd;//jsp页面foreach标签循环的结束页码
	private int forEachlength = 10;//jsp页面一共显示的页码数
	
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	
	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getForEachBegin() {
		return forEachBegin;
	}

	public void setForEachBegin(int forEachBegin) {
		this.forEachBegin = forEachBegin;
	}

	public int getForEachEnd() {
		return forEachEnd;
	}

	public void setForEachEnd(int forEachEnd) {
		this.forEachEnd = forEachEnd;
	}

	public int getForEachlength() {
		return forEachlength;
	}

	public void setForEachlength(int forEachlength) {
		this.forEachlength = forEachlength;
	}

	public Page2(){};
	
	public Page2(int pagenum,int totalrecord){
		this.pagenum = pagenum;
		this.totalrecord = totalrecord;
		if(this.totalrecord%pagesize==0){
			totalpage = this.totalrecord/pagesize;
		}else{
			totalpage = this.totalrecord/pagesize+1;
		}
		
		//根据页码算出startindex的值
		startindex = (pagenum-1)*pagesize;
		if(totalpage<=10){
			forEachBegin = 1;
			forEachEnd = totalpage;
		}else{
			if(totalpage>10){
		
				forEachBegin = pagenum-4;
				forEachEnd = pagenum+5;
				if(forEachBegin<1){
					forEachBegin = 1;
					forEachEnd = 10;
				}
				if(forEachEnd>totalpage){
					forEachEnd = totalpage;
					forEachBegin = totalpage-10+1;
				}
			}
		}
		
	}

}
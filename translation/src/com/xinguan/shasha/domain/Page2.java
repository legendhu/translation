package com.xinguan.shasha.domain;

import java.util.List;

public class Page2 {
	private int totalrecord;//�ܼ�¼��
	private int pagesize=10;//ÿҹ��ʾ�ļ�¼��
	private int totalpage;//ҳ����
	private int startindex;//�����ݿ��ĸ��ط���ʼȡֵ
	private List list;//��ĳһҳ�����ݷ�װ��list��
	private int pagenum;//��¼��ǰҳ���
	private int forEachBegin;//jspҳ��foreach��ǩѭ���Ŀ�ʼҳ��
	private int forEachEnd;//jspҳ��foreach��ǩѭ���Ľ���ҳ��
	private int forEachlength = 10;//jspҳ��һ����ʾ��ҳ����
	
	
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
		
		//����ҳ�����startindex��ֵ
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
package com.xinguan.shasha.domain;
//��ҳ
import java.util.List;

public class Page {
	private int total;//�ܼ�¼��
	private int showCount = 12;//ÿҳչʾ����
	private int pageCount;//��ʾҳ��
	private int num = 1;//չʾ��*ҳ
	private int start = 0;//��ʼ��ѯ��
	private List list = null;//�洢ҳ�����ݵ�list
	private int begin;//��ʼҳ��
	private int end;//����ҳ��
	private int length = 5;//�̶�չʾ*ҳ��
	
	//���췽��
	public Page(){}
	
	public Page(int total,int num){
		//�������������ʾ����ҳ
		this.total=total;
		if(total%this.showCount==0){
			pageCount = this.total/this.showCount;
		}else{
			pageCount =this.total/this.showCount + 1;
		}
		//���ݵ�*ҳ����ӵ�*���ݿ�ʼ��ѯ
		this.num = num;
		this.start = (this.num-1)*this.showCount;
		//���ݵ�ǰҳ�����begin��end
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
		//�������������ʾ����ҳ
		this.showCount = showCount;
		this.total= total;
		if(total%showCount==0){
			pageCount = this.total/showCount;
		}else{
			pageCount =this.total/showCount + 1;
		}
		//���ݵ�*ҳ����ӵ�*���ݿ�ʼ��ѯ
		this.num = num;
		this.start = (this.num-1)*this.showCount;
		//���ݵ�ǰҳ�����begin��end
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

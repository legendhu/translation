package com.xinguan.shasha.dao.jdbc;

import com.xinguan.shasha.domain.Score;
import com.xinguan.shasha.domain.Teacher;

public interface IScoreDao {

	/*��ѯteacher��score
	 *����score
	 */
	public int select(Teacher teacher);
	
	/*��ѯscore���ж�score����teacherusername���Զ�Ӧ��studentusername�Ƿ����
	 * ���ڣ�����flase  �������ύ
	 * �����ڣ�����true  �����ύ
	 */
	public boolean select(Score score);
	
	/*
	 * ����teacher��:score  ���score��teacherusername��studentusername 
	 */
	public boolean updateUser(Teacher teacher,Score score);

	
	/*����Ա���score��teacher��
	 * ������ʦusername����score
	 */
	public boolean updateAdmin(Teacher teacher);
	
	

	
}

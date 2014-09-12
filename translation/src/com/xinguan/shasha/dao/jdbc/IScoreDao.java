package com.xinguan.shasha.dao.jdbc;

import com.xinguan.shasha.domain.Score;
import com.xinguan.shasha.domain.Teacher;

public interface IScoreDao {

	/*查询teacher表：score
	 *返回score
	 */
	public int select(Teacher teacher);
	
	/*查询score表：判断score表中teacherusername属性对应的studentusername是否存在
	 * 存在：返回flase  不可以提交
	 * 不存在：返回true  可以提交
	 */
	public boolean select(Score score);
	
	/*
	 * 更新teacher表:score  添加score表teacherusername和studentusername 
	 */
	public boolean updateUser(Teacher teacher,Score score);

	
	/*管理员添加score至teacher表
	 * 根据老师username更新score
	 */
	public boolean updateAdmin(Teacher teacher);
	
	

	
}

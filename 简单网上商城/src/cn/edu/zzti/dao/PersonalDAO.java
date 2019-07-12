package cn.edu.zzti.dao;

import cn.edu.zzti.entity.PersonalInfo;

/** 
 * @author 作者 E-mail: 
 * @version 创建时间：2017年5月14日 下午9:18:20 
 * 类说明 
 */
public interface PersonalDAO {
	public PersonalInfo getPersonalInfo(String username);
	public void setPersonalInfo(String username,PersonalInfo p);

}

package cn.edu.zzti.dao.impl.constance;

import cn.edu.zzti.dao.PersonalDAO;
import cn.edu.zzti.entity.PersonalInfo;
import cn.edu.zzti.entity.User;

/** 
 * @author 作者 E-mail: 
 * @version 创建时间：2017年5月14日 下午9:20:18 
 * 类说明 
 */
public class PersonalDAOImplConstance implements PersonalDAO{

	
	@Override
	public PersonalInfo getPersonalInfo(String username) {
		if(username!=null&&!"".equals(username)){
			return UserDAOImplConstance.userList.get(username).getPi();
		}
		return null;
	}

	@Override
	public void setPersonalInfo(String username,PersonalInfo p) {
		User u = UserDAOImplConstance.userList.get(username);
		if(u!=null){
			u.setPi(p);
		}
		
	}

}

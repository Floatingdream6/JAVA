package cn.edu.zzti.dao.impl.constance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zzti.dao.UserDAO;
import cn.edu.zzti.entity.PersonalInfo;
import cn.edu.zzti.entity.User;

public class UserDAOImplConstance implements UserDAO {
	static Map<String,User> userList = new HashMap<String,User>();

	static{
		for(int i=0;i<5;i++){
			User user = new User("admin"+i,"admin"+i);
			if(i==0){
				user.setPi(new PersonalInfo(20, "女", "河南省中原区", "67698021", "test.@163.com", "中原工学院", "硕士", "计算机应用"));
			}else{
				user.setPi(null);
			}
			userList.put("admin"+i,user);
		}
	}

	@Override
	public List<User> getAll() {
		return new ArrayList<User>(userList.values());
	}

	@Override
	public User findUser(String username, String password) {
		Collection<User> c = userList.values();
		for(User u: c){
			if(u.getUsername().equals(username)&&u.getPassword().equals(password)){
				return u;
			}
		}
		return null;
	}

	@Override
	public int insertUser(User u) {
		userList.put(u.getUsername(), u);
		return 1;
	}

	@Override
	public int deleteUser(String id) {
		userList.remove(id);
		return 1;
	}

	@Override
	public User getUserByName(String username) {
		return userList.get(username);
	}
}

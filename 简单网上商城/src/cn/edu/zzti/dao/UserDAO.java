package cn.edu.zzti.dao;

import java.util.List;

import cn.edu.zzti.entity.User;

public interface UserDAO {
	/**
	 * 获得系统中的所有用户
	 * @return
	 */
	public List<User> getAll();
	/**
	 * 用于登录校验
	 * @param username
	 * @param password
	 * @return
	 */
	public User findUser(String username,String password);
	/**
	 * 在系统中创建一个用户的信息
	 * @param u
	 * @return
	 */
	public int insertUser(User u);
	/**
	 * 根据用户的id删除一个用户
	 * @param id
	 * @return
	 */
	public int deleteUser(String id);
	/**
	 * 通过用户名获得一个用户的详细信息
	 * @param username
	 * @return
	 */
	public User getUserByName(String username);

}

package com.board.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class UserDao {

	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public UserDao() {
		session = sqlsession_f.openSession(true);
	}
	
	public UserDto selectUserById(String id) {
		return session.selectOne("UserMapper.selectUserById", id);
	}

	public UserDto selectUserByIdAndPassword(String id, String password) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("password", password);
		return session.selectOne("UserMapper.selectUserByIdAndPassword", params);
	}

	public int getNumUsers() {
		return session.selectOne("UserMapper.getNumUsers");
	}

	public List<UserDto> selectList(int start, int listSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("listSize", listSize);
		return session.selectList("UserMapper.selectList", map);
	}

	public UserDto selectOne(int userNum) {
		return session.selectOne("UserMapper.selectOne", userNum);
	}

	public void insertOne(UserDto user) {
		session.insert("UserMapper.insertUser", user);
	}

	public void updateOne(UserDto user) {
		session.update("UserMapper.updateUser", user);
	}

	public boolean deleteOne(int userNum) {
		try {
			session.delete("UserMapper.deleteUser", userNum);
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}

	public int countUsers() {
		return session.selectOne("UserMapper.countUsers");
	}
}

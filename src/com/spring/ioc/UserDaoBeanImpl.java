package com.spring.ioc;

public class UserDaoBeanImpl implements IUserDaoBean{

	public UserDaoBeanImpl(){
		System.out.println("本类对象被创建了!...");
	}
	@Override
	public void showUserInfo() {
		System.out.println("调用显示所有用户的方法.....");
	}
}

package com.spring.ioc;

public class UserDaoBeanImpl implements IUserDaoBean{

	public UserDaoBeanImpl(){
		System.out.println("������󱻴�����!...");
	}
	@Override
	public void showUserInfo() {
		System.out.println("������ʾ�����û��ķ���.....");
	}
}

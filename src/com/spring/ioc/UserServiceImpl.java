package com.spring.ioc;

public class UserServiceImpl {

	//����UserDaoBeanImplʵ��  ��û��spring�����ǹ����ʱ��,���еĶ������Ƕ�Ҫ�Լ�new����,���򽫳��ֿ�ָ���쳣!
	IUserDaoBean bean;
	
	public UserServiceImpl(){
		this.bean = bean;
	}
	
	
	public void setBean(IUserDaoBean bean) {
		this.bean = bean;
	}


	public UserServiceImpl(IUserDaoBean bean){
		this.bean = bean;
	}
	public UserServiceImpl(IUserDaoBean bean,Integer id){
		System.out.println("���ô���������:"+"id:="+id);
		this.bean = bean;
	}
	public UserServiceImpl(IUserDaoBean bean,Integer id,String name){
		System.out.println("���ô���������:"+"id:="+id+" name:="+name);
		this.bean = bean;
	}
	
	public void show(){
		bean.showUserInfo();
	}
}

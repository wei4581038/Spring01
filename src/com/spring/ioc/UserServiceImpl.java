package com.spring.ioc;

public class UserServiceImpl {

	//创建UserDaoBeanImpl实例  在没有spring帮我们管理的时候,所有的对象我们都要自己new出来,否则将出现空指针异常!
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
		System.out.println("调用带两个参数:"+"id:="+id);
		this.bean = bean;
	}
	public UserServiceImpl(IUserDaoBean bean,Integer id,String name){
		System.out.println("调用带三个参数:"+"id:="+id+" name:="+name);
		this.bean = bean;
	}
	
	public void show(){
		bean.showUserInfo();
	}
}

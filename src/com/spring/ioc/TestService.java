package com.spring.ioc;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {

	@Test
	public void testUserService(){
		
		IUserDaoBean bean = new UserDaoBeanImpl();
		//创建service对象的实例
		
		//控制反转IOC:把紫的原来对象的控制权交给外部对象来创建及维护的过程
		//依赖注入:在对象运行期间把一个他依赖的对象注入到该对象中
		
		//使用IOC(控制反转)管理对象,[构造函数注入方式]
		UserServiceImpl userServiceImpl = new UserServiceImpl(bean);
		userServiceImpl.show();
		
		//也可以使用set的方式进行依赖注入
		userServiceImpl.setBean(bean);
		userServiceImpl.show();
		
		///
		//通过反射创建UserDaoBeanImpl对象实例
		try {
			IUserDaoBean userDao = (UserDaoBeanImpl) Class.forName("com.spring.ioc.UserDaoBeanImpl").newInstance();
			userDao.showUserInfo();
			Map<String,Object> objectBean = new HashMap<String,Object>();
			//把ID作为key,把class通过反射生成的对象作为value
			objectBean.put("userDao", userDao);
			userDao = (UserDaoBeanImpl)objectBean.get("userDao");
			userDao.showUserInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void initSpringContext(){
		//实例化Spring容器  注意:包是org.springframework.context.ApplicationContext下的
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		//现在我们怎么知道这个bean.xml的对象是否已经被创建了呢?我们在UserDaoBeanImpl去创建一个构造函数,看看构造函数是否已经被调用就可以了!
		System.out.println("applicationContext:="+applicationContext);
		IUserDaoBean userDao = (UserDaoBeanImpl)applicationContext.getBean("userDao");
		userDao.showUserInfo();
		//我们现在可以把bean.xml这个文件看成一个工厂,只要你把想要让spring来管理的对象配置在bean.xml文件中,
		//就可以通过applicationContext来得到你想要的方法,不需要再去new接口的实现类
		UserServiceImpl userServiceImpl = (UserServiceImpl) applicationContext.getBean("UserService");
		//userServiceImpl.setBean(userDao);
		userServiceImpl.show();
		System.out.println("----------通过setter方法进行注入----------------");
		UserServiceImpl userServiceImpl1 = (UserServiceImpl)applicationContext.getBean("UserService1");
		userServiceImpl1.show();
	}
}

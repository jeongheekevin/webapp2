package com.multicampus.biz.user;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		ClassPathXmlApplicationContext container = 
			new ClassPathXmlApplicationContext("springConfig.xml");
		
		// 2. 컨테이너로부터 테스트할 객체를 Lookup한다.
		UserService userService = 
			(UserService) container.getBean("userService");
		
		// 3. 검색한 객체의 메소드 테스트
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		} else {
			System.out.println("로그인 실패!!!");
		}
	}
}






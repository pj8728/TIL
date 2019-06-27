# spring homework 예제

1. Homework.java

~~~ java
package exam2;

public class Homework {
	private String homeworkName;
	public Homework(String homeworkName) {
		super();
		this.homeworkName = homeworkName;
	}
	public String getHomeworkName() {
		return homeworkName;
	}
	public void setHomeworkName(String homeworkName) {
		this.homeworkName = homeworkName;
	}	
}

~~~

2. Student.java

~~~ java
package exam2;

public class Student {
	private String name;
	private Homework myHomework;
	public Student() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Homework getMyHomework() {
		return myHomework;
	}
	public void setMyHomework(Homework myHomework) {
		this.myHomework = myHomework;
	}
	@Override
	public String toString() {
		return name+"는 "+myHomework+"를 학습합니다.";
	}
}

~~~

3. work.xml

~~~ xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<bean id="h1" class="exam2.Homework">
	<constructor-arg name="homeworkName" value="국어"/></bean>
<bean id="h2" class="exam2.Homework">
	<constructor-arg name="homeworkName" value="영어"/></bean>
<bean id="h3" class="exam2.Homework">
	<constructor-arg name="homeworkName" value="수학"/></bean>
<bean id="st1" class="exam2.Student">
	<property name="name" value="둘리"/>
	<property name="myHomework" ref="h1"/></bean>
<bean id="st2" class="exam2.Student">
	<property name="name" value="또치"/>
	<property name="myHomework" ref="h2"/></bean>
<bean id="st3" class="exam2.Student">
	<property name="name" value="도우너"/>
	<property name="myHomework" ref="h3"/></bean>
</beans>

~~~

4. StudyApp.java

~~~ java
package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exam2.Student;

public class StudyApp {

	public static void main(String[] args) {
		ApplicationContext factory = 
			       new ClassPathXmlApplicationContext("exam2/work.xml");
		
		Student st1 = factory.getBean("st1", Student.class); 
		System.out.println(st1.getName()+"는 "+st1.getMyHomework().getHomeworkName()+"를 학습합니다.");
			
		Student st2 = factory.getBean("st2", Student.class);
		System.out.println(st2.getName()+"는 "+st2.getMyHomework().getHomeworkName()+"를 학습합니다.");
		
		Student st3 = factory.getBean("st3", Student.class);
		System.out.println(st3.getName()+"는 "+st3.getMyHomework().getHomeworkName()+"를 학습합니다.");
			
		((ClassPathXmlApplicationContext)factory).close();
	}
}

~~~


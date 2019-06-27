# spring 인사 예제

1. MorningGreetingImpl.java

   ~~~ java
   package exam1;
   
   public class MorningGreetingImpl implements Greeting {
   	public void greet() {
   		System.out.println("상쾌한 아침입니다.");
   	}
   }
   ~~~

2. AfternoonGreetingImpl.java

~~~ java
package exam1;

public class AfternoonGreetingImpl implements Greeting {
	public void greet() {
		System.out.println("즐거운 오후되세요.");		
	}
}

~~~

3. EveningGreetingImpl.java

~~~ java
package exam1;

public class EveningGreetingImpl implements Greeting{
	public void greet() {
		System.out.println("편안한 저녁되세요.");		
	}
}
~~~

4. NightGreetingImpl.java

~~~ java
package exam1;

public class NightGreetingImpl implements Greeting{
	public void greet() {
		System.out.println("안녕히 주무세요");
	}
}
~~~

5. Greeting.java

~~~ java
package exam1;

public interface Greeting {
	public void greet();
}
~~~

6. timegreet.xml

~~~ xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<bean id="morning" class="exam1.MorningGreetingImpl"></bean>
<bean id="afternoon" class="exam1.AfternoonGreetingImpl"></bean>
<bean id="evening" class="exam1.EveningGreetingImpl"></bean>
<bean id="night" class="exam1.NightGreetingImpl"></bean>
<bean id="local" class="java.time.LocalDateTime" factory-method="now"></bean>

</beans>

~~~

7. GreetingTest.java

~~~ java
package exam1;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam1/timegreet.xml");
		LocalDateTime local=(LocalDateTime)factory.getBean("local");

		int time = local.getHour();
		
		Greeting test = null;
		if(time>=6 && time<12) {
			test = (Greeting)factory.getBean("morning");
		}else if(time>=12 && time<17) {
			test = (Greeting)factory.getBean("afternoon");
		}else if(time>=17 && time<22) {
			test = (Greeting)factory.getBean("evening");
		}else {
			test = (Greeting)factory.getBean("night");
		}
		
		test.greet();
		((ClassPathXmlApplicationContext)factory).close();
	}
}

~~~


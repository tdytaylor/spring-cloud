package com.taylor.cloud;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // 底层用Junit SpringJUnit4ClassRunner
@SpringBootTest(classes = {CloudSpringBootApplication.class}) // 启动整个Springboot项目
public class SpringBootTestDemo {

}

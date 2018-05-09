package report_web;

import com.report.common.pojo.User;
import com.report.common.util.WDWUtil;
import com.report.mapper.UserMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TestSpringMyBatis {

    private ApplicationContext act;
    //private ItemService itemService;


    @Before
    public void  init(){
        act = new ClassPathXmlApplicationContext("classpath:spring/springmvc.xml");

    }


    public static void main(String[] args) {
        // System.out.println(getToken("o3U191rYvmWjdz9NEFE2hjtkPVjE"));
        // System.out.println(tokenEncode("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1MjQ4ODIzOTI3OTksInBheWxvYWQiOiJcIm8zVTE5MXJZdm1XamR6OU5FRkUyaGp0a1BWakVcIiJ9.BaDHJeIc7edicHIhzq0LhU0_ojUHfNtwJ6-Ln2mQTa4"));

        //System.out.println(tokenEncode("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1MjQ4MjQwOTY4NjIsInBheWxvYWQiOiJudWxsIn0._wH8BY3sfDC6MSakpTT-wdgKJDmEP_GsKN1bQvWpljI"));

        System.out.println(WDWUtil.isExcel2003(".xsls"));

    }


    @Test
    @Transactional
    public void test() {
        String[] beanDefinitionNames = act.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println("===========" + name);
        }
        UserMapper userMapper = (com.report.mapper.UserMapper) act.getBean("userMapper");


        User user = new User();
        List<User> users = userMapper.selectUserByPaging(user);


        System.out.println(users);

    }

}
    /*public   static   void  main(String[] args)   {
        PropertyConfigurator.configure( "G:/kangmei/report_parent/report_web/src/main/resources/properties/log4j.properties" );
        Logger logger  =  Logger.getLogger(TestSpringMyBatis.class  );
        logger.debug( " debug " );
         logger.error( " error " );
     } */




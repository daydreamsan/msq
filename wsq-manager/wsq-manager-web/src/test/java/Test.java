import accountserv.IAccount;
import accountdao.AccountManpper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wsq.account.controller.RegistController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationcontext-*.xml", "classpath*:springmvc-servlet.xml"})
public class Test {
    // web层测试
    @Autowired
    private RegistController registController;
    @org.junit.Test
    public void test() {
        String s = registController.handler();
        System.out.println(s);
    }

    // service层测试
    @Autowired
    @Qualifier("useraccount")
    private IAccount account;

    @org.junit.Test
    public void test2() {
        System.out.println("test2");
        Integer count = this.account.countWithUid(71);
        System.out.println(count);
    }

    // dao层测试
    @Autowired
    private AccountManpper dao;

    @org.junit.Test
    public void test3() {
        int user = this.dao.findUser(71);
        System.out.println(user);
    }
}

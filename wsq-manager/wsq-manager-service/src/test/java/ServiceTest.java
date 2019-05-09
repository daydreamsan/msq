import accountserv.IAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 这里也单元测试成功了
// classpath*:applicationcontext-*.xml
// 这种方式可以查找applicationcontext-service.xml与applicationcontext-dao.xml两个配置文件
// classpath*: 查找当前classes目录，也查找其它jar包中的classes目录
// classpath: 只查找当前的classes目录

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationcontext-*.xml")
public class ServiceTest {
    @Autowired
    @Qualifier("useraccount")
    private IAccount accountservice;
    @Test
    public void test0() {
        Integer count = this.accountservice.countWithUid(71);
        System.out.println("count: " + count);
        this.accountservice.save("aaaaaa");
    }
}

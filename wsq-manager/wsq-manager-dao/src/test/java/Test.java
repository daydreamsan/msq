import accountdao.AccountManpper;
import accountdao.WordMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 不容易啊，spring+mybatis进行单元测试终于成功了
// @ContextConfiguration告诉spring去类目录下找applicationcontext-dao.xml文件
// 在执行被@Test注解修改的方法时，会生成target目录，该目录下会有classes文件夹，
// classes文件夹下会有applicationcontext-dao.xml文件
// 而这一切，都是maven工程的目录结构标准化的
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationcontext-dao.xml")
public class Test {
    private AccountManpper dao;
    private WordMapper wordDao;

    public WordMapper getWordDao() {
        return wordDao;
    }

    @Autowired
    public void setWordDao(WordMapper wordDao) {
        System.out.println("bind word dao");
        this.wordDao = wordDao;
    }

    public AccountManpper getDao() {
        return dao;
    }

    @Autowired
    public void setDao(AccountManpper dao) {
        this.dao = dao;
    }

    @org.junit.Test
    public void test01() {
        int i = this.dao.findUser(71);
        System.out.println(i);
    }

    @org.junit.Test
    public void test02() {
        int t = this.wordDao.queryWord(71);
        System.out.println(t);
    }
}

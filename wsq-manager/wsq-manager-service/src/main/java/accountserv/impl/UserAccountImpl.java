package accountserv.impl;

import accountserv.IAccount;
import accountdao.AccountManpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("useraccount")
public class UserAccountImpl implements IAccount {
    private AccountManpper dao;

    public AccountManpper getDao() {
        return dao;
    }

    @Autowired
    public void setDao(AccountManpper dao) {
        this.dao = dao;
    }

    @Override
    public Integer countWithUid(Integer uid) {
        System.out.println("user accountserv impl");
        return this.dao.findUser(71);
    }

    @Override
    // 事务中不能用try catch，否则就不回滚了.java.lang.ArithmeticException
    @Transactional(propagation = Propagation.REQUIRED,
                rollbackFor = {java.lang.RuntimeException.class,
                    java.lang.ArithmeticException.class})
    public boolean save(String word) {
        try {
            this.dao.insertWord(word, 100000);
            System.out.println("异常了兄弟");
            return true;
        } catch (Exception e) {
            System.out.println("出错了");
            e.printStackTrace();
            return false;
        }
    }
}

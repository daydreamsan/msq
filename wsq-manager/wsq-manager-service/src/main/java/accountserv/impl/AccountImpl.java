package accountserv.impl;

import accountserv.IAccount;
import accountdao.AccountManpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountImpl implements IAccount {
    private AccountManpper dao;
    public AccountManpper getDao() {
        return dao;
    }
    @Autowired
    public void setDao(AccountManpper dao) {
        // idea在这里报警说没有IAccountDao相关的实现类。
        // 因为mybatis会通过动态代理的方式创建实现类，
        // 所以在运行过程中其实是会有IAccountDao的实现类的
        this.dao = dao;
    }
    @Override
    public Integer countWithUid(Integer uid) {
        return dao.findUser(uid);
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public boolean save(String word) {
        return false;
    }
}

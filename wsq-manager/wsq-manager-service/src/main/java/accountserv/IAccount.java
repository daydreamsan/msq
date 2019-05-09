package accountserv;

public interface IAccount {
    Integer countWithUid(Integer uid);
    boolean save(String word);
}

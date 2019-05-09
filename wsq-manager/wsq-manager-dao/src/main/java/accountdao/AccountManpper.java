package accountdao;

import org.apache.ibatis.annotations.Param;

public interface AccountManpper {
    int findUser(Integer uid);

    /* @Param注解可以用来绑定多个参数，这样就不用写VO了 */
    boolean insertWord(@Param("word") String word, @Param("id") Integer id);
}

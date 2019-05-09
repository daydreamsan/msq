import com.alibaba.fastjson.JSONObject;
import pojo.Animal;

public class Test {
    @org.junit.jupiter.api.Test
    public void service() {
        Animal animal = new Animal();
        animal.setName("hh");
        String s = JSONObject.toJSONString(animal);
        System.out.println(s);
    }
}

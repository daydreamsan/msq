import com.alibaba.fastjson.JSONObject;
import pojo.Animal;

public class Test {
    @org.junit.jupiter.api.Test
    public void test1() {
        Animal animal = new Animal();
        animal.setAge(10);
        animal.setName("xiao bai tu");
        String jsonString = JSONObject.toJSONString(animal);
        System.out.println(jsonString);

        JSONObject parse = (JSONObject) JSONObject.parse(jsonString);
        Animal animal1 = JSONObject.toJavaObject(parse, Animal.class);
        System.out.println(animal1.getClass().getName());
        System.out.println(animal1);
    }
}

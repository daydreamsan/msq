package wsq.account.controller;

import accountserv.IAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.Animal;
import wsq.account.domain.Result;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class RegistController {
    @Qualifier("useraccount")
    @Autowired
    private IAccount account;

    public IAccount getAccount() {
        return account;
    }

    public void setAccount(IAccount account) {
        this.account = account;
    }

    @RequestMapping("/regist")
    public String handler() {
        System.out.println("hello handler");
        return "/register";
    }

    @RequestMapping("/accountserv")
    public String account() {
        if (this.account == null) {
            System.out.println("注入失败了");
        }
        Integer count = this.account.countWithUid(1);
        System.out.println(count);
        return "/account";
    }

    @RequestMapping("/word")
    @ResponseBody
    public Animal word() {
        Animal animal = new Animal();
        animal.setName("大狗");
        animal.setAge(19);

        return animal;
    }

    @RequestMapping("/iconset")
    public String uploadicon() {
        return "/usericon";
    }

    @RequestMapping("/fileupload")
    public String upload(@RequestParam(name = "file") MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            String contextPath = request.getContextPath();
            System.out.println("contextpath: " + contextPath);

            String servletPath = request.getServletPath();
            System.out.println("servletpath: " + servletPath);

            String scheme = request.getScheme();
            System.out.println("scheme: " + scheme);

            String originalFilename = file.getOriginalFilename();
            System.out.println("originalFilename: " + originalFilename);

            String path = "/Users/qijiangtao/Desktop/DB";
            if (originalFilename != null) {
                File filepath = new File(path, originalFilename);
                try {
                    file.transferTo(filepath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else  {
            System.out.println("文件为空啊兄弟");
        }
        return "/register";
    }

    /*
    * url 参数处理, 路径中的参数处理
    * */
    @RequestMapping("/param/{id}")
    @ResponseBody
    public Result urlParam0(@PathVariable("id") Integer id) {
        System.out.println("pathv: " + id);
        return new Result<>(id, 200, "success");
    }

    // 绑定请求参数, @RequestParam中的name字段可以做参数的映射,
    // 若省略name="age", 则以形参名为请求参数的名字
    @RequestMapping(value = "/param")
    @ResponseBody
    public Result urlParam1(@RequestParam(name = "age", required = false) String aage) {
        System.out.println("request param: " + aage);
        return new Result<>(aage, 200, "sueccess");
    }

    @RequestMapping("/jppage")
    public String jppage() {
        return "/jpreq";
    }

    // 请求参数为json格式
    @RequestMapping("/jp")
    @ResponseBody
    public Result urljp(@RequestBody Animal animal) {
        if (animal != null) {
            System.out.println(animal);
        } else {
            System.out.println("animal is null");
        }
        return new Result<>(animal, 200, "fail");
    }
}

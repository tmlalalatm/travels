package com.tm.travels.controller;

import com.tm.travels.entity.User;
import com.tm.travels.response.Result;
import com.tm.travels.service.UserService;
import com.tm.travels.utils.CreateImageCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author tangmin
 * @Date 2020/8/21 14:31
 **/
@RestController
@RequestMapping("/user")
//允许跨域
@CrossOrigin
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 注册
     *
     * @param code
     * @param key
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/register")
    public Result regiser(String code, String key, @RequestBody User user, HttpServletRequest request) {

        Result result = new Result();

        log.info("接收到的code：", code);
        log.info("接收到的user", user);
        String keyCode = (String) request.getServletContext().getAttribute(key);
        log.info("接收到的key：", keyCode);
        try {
            if (code.equalsIgnoreCase(keyCode)) {
                //注册用户
                userService.register(user);
                result.setMessage("注册成功！");
                result.setState(true);
            } else {
                throw new RuntimeException("验证码错误");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getMessage()).setState(false);
        }

        return result;

    }

    /**
     * 登录
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        Result result = new Result();
        log.info("user:", user);
        try {

            User user1 = userService.login(user);
            //登录成功之后保存用户的标记
            request.getServletContext().setAttribute(user1.getId().toString(), user1);
            result.setMessage("登录成功！").setState(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(e.getMessage()).setState(false);
        }
        return result;
    }

    /**
     * 获取验证码
     * @param request
     * @return
     * @throws IOException
     */
    @GetMapping("/getImage")
    public Map<String, String> getImage(HttpServletRequest request) throws IOException {
       Map<String, String> result = new HashMap<>();
        CreateImageCode createImageCode = new CreateImageCode(120, 40, 4, 10);
        //获取验证码
        String code = createImageCode.getCode();
        //将验证码存入session
        String key = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        request.getServletContext().setAttribute(key, code);
        //生成图片
        BufferedImage image = createImageCode.getBuffImg();
        //进行base64编码
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", byteArrayOutputStream);
        String string = Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
        result.put("key", key);
        result.put("image", string);
       return result;
    }

}

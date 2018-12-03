package com.jswl.jwtservice.web;


import com.alibaba.fastjson.JSONObject;
import com.jswl.jwtservice.annotation.UserLoginToken;
import com.jswl.jwtservice.entity.User;
import com.jswl.jwtservice.service.IUserService;
import com.jswl.jwtservice.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author David ZHONG
 * @since 2018-04-02 
 */
@RestController
@RequestMapping("api")
public class Userweb {
    @Autowired
    IUserService userService;
    @Autowired
    TokenService tokenService;
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=this.userService.findByUsername(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}


package com.example.test.studydemo.controller;

import com.example.test.studydemo.dto.AcessTokenDTO;
import com.example.test.studydemo.dto.GithubUser;
import com.example.test.studydemo.mapper.UserMapper;
import com.example.test.studydemo.model.User;
import com.example.test.studydemo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Description
 * User :LT
 * Date : 2019-2019.12.5-05  9:58
 */

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserMapper userMapper;

    @Value("${github.client_id}")
    private  String client_id;

    @Value("${github.client_secret}")
    private String client_secret;

    @Value("${github.redirect_uri}")
    private String redirect_uri;

    @GetMapping("/callback")
    public  String callBack(@RequestParam(name = "code") String code,
                            @RequestParam(name = "state")String state,
                            HttpServletRequest request)
    {
        AcessTokenDTO accessTokenDTO = new AcessTokenDTO();//c+ait +v
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);

        String ac= githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubuser = githubProvider.getUser(ac);
        if(githubuser!=null){
            User user =  new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubuser.getLogin());
            user.setAccountId(String.valueOf(githubuser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.getGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            request.getSession().setAttribute("user",githubuser);
            System.out.println(githubuser.getLogin());
            return "redirect:/";

        }
        else
        {
            return "redirect:/";
        }
    }
}

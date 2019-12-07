package com.example.test.studydemo.provider;

import com.alibaba.fastjson.JSON;
import com.example.test.studydemo.dto.AcessTokenDTO;
import com.example.test.studydemo.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

/**
 * Description
 * User :LT
 * Date : 2019-2019.12.5-05  10:09
 */

@Component
public class GithubProvider {
    public String getAccessToken(AcessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            System.out.println("getAccessToken error,{}");
        }
        return null;
    }


    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (Exception e) {
            System.out.println("getAccessToken error,{}");
        }
        return null;
    }
}

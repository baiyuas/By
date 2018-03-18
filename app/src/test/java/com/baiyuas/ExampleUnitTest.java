package com.baiyuas;

import com.baiyuas.di.component.DaggerTestComponent;
import com.baiyuas.model.bean.UserBean;
import com.baiyuas.model.bean.WanResponse;
import com.baiyuas.model.http.NetRepo;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void tsetGson() {
        Gson gson = new Gson();
        WanResponse<UserBean> response = gson.fromJson("{\"data\":null,\"errorCode\":-1,\"errorMsg\":\"账号密码不匹配！\"}", WanResponse.class);
        System.out.println(response.toString());
    }

    @Test
    public void testApi() {
        NetRepo netRepo = DaggerTestComponent.builder().build().getNetRepo();
        netRepo.login("1@1.com", "23jfoisjfiojdf")
        .subscribe(response -> System.out.println(response.toString()));
    }
}
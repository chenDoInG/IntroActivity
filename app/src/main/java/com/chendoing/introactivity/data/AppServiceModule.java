package com.chendoing.introactivity.data;

import com.chendoing.introactivity.model.User;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class AppServiceModule {

    @Provides
    User provideUser(){
        User user = new User();
        List<User.Data> datas = new ArrayList<User.Data>();
        List<User.UI> ui = new ArrayList<User.UI>();
        User.UI u1 = new User().new UI();
        u1.setName("chendoing");
        ui.add(u1);
        User.Data data = new User().new Data();
        data.setUidatas(ui);
        datas.add(data);
        user.setDatas(datas);
        return user;
    }
}

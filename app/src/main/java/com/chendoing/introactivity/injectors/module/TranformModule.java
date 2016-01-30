package com.chendoing.introactivity.injectors.module;

import com.chendoing.introactivity.model.entities.Transform;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class TranformModule {

    @Provides
    Transform provideTrasform(){
        Transform transform = new Transform();
        List<Transform.Data> datas = new ArrayList<Transform.Data>();
        List<Transform.UI> ui = new ArrayList<Transform.UI>();
        Transform.UI u1 = new Transform().new UI();
        Transform.Data data = new Transform().new Data();
        u1.setName("chendoing");
        ui.add(u1);
        data.setUidatas(ui);
        datas.add(data);

        Transform.UI u2 = new Transform().new UI();
        List<Transform.UI> ui2 = new ArrayList<Transform.UI>();
        Transform.Data data2 = new Transform().new Data();
        u2.setName("chendoing2");
        ui2.add(u2);
        data2.setUidatas(ui2);
        datas.add(data2);

        Transform.UI u3 = new Transform().new UI();
        List<Transform.UI> ui3 = new ArrayList<Transform.UI>();
        Transform.Data data3 = new Transform().new Data();
        u3.setName("chendoing3");
        ui3.add(u3);
        data3.setUidatas(ui3);
        datas.add(data3);

        transform.setDatas(datas);
        return transform;
    }
}

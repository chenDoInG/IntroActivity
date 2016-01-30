package com.chendoing.introactivity.model.entities;

import java.util.List;

@SuppressWarnings("unused")
public class Transform {

    public List<Data> getDatas() {
        return datas;
    }

    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }

    private List<Data> datas;

    public String getUrl() {
        return "https://www.baidu.com";
    }

    public String getType() {
        return "社保转入";
    }

    public class Data {

        private List<UI> uidatas;

        public List<UI> getUidatas() {
            return uidatas;
        }

        public void setUidatas(List<UI> uidatas) {
            this.uidatas = uidatas;
        }
    }

    public class UI {

        private String value;
        private String name;
        private String key;
        private String type;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}

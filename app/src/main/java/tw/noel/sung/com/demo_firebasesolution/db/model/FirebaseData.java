package tw.noel.sung.com.demo_firebasesolution.db.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FirebaseData {


    @SerializedName("Board1")
    private List<Board1Bean> Board1;

    public List<Board1Bean> getBoard1() {
        return Board1;
    }

    public void setBoard1(List<Board1Bean> Board1) {
        this.Board1 = Board1;
    }

    public static class Board1Bean {
        /**
         * name : Noel
         * text : 哈囉，大家好，我是Noel😂🤣😂🤣😂🤣
         * time : 2018/10/10 00:58
         * uuid : 2248bb7b865c75a9
         */

        @SerializedName("name")
        private String name;
        @SerializedName("text")
        private String text;
        @SerializedName("time")
        private String time;
        @SerializedName("uuid")
        private String uuid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }
}

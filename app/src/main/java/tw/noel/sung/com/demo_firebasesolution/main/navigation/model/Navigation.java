package tw.noel.sung.com.demo_firebasesolution.main.navigation.model;


import java.util.List;

public class Navigation {


    private List<BoardBean> board;

    public List<BoardBean> getBoard() {
        return board;
    }

    public void setBoard(List<BoardBean> board) {
        this.board = board;
    }

    public static class BoardBean {
        /**
         * id : testttttt
         * name : test
         * message : test
         * time : 2019.01.12, 22:17
         */

        private String id;
        private String name;
        private String message;
        private String time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}

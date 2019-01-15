package tw.noel.sung.com.demo_firebasesolution.talk.list.board.model;

public class Board {

    private String userId;
    private String message;
    private String name;
    private String time;


    public Board(String userId, String message, String name, String time) {
        this.userId = userId;
        this.message = message;
        this.name = name;
        this.time = time;
    }

    public Board(){

    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }
}

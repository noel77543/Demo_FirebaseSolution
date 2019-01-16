package tw.noel.sung.com.demo_firebasesolution.talk.list.model;

public class User {

    private int type;
    private String userId;
    private String time;

    public User(String userId, int type,String time) {
        this.type = type;
        this.userId = userId;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public int getType() {
        return type;
    }

    public String getUserId() {
        return userId;
    }

}

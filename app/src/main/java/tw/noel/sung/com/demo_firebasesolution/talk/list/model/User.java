package tw.noel.sung.com.demo_firebasesolution.talk.list.model;

public class User {

    private int type;
    private String userId;

    public User(String userId, int type) {
        this.type = type;
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public String getUserId() {
        return userId;
    }

}

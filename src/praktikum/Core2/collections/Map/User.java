package praktikum.Core2.collections.Map;

public class User {
    public Integer userId;
    public String usermame;

    public User(Integer userId, String usermame) {
        this.userId = userId;
        this.usermame = usermame;
    }

    public String toString() {
        return "User{id=" + userId + ", name='" + usermame + "'}";
    }
}

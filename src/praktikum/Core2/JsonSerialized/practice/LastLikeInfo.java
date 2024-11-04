package praktikum.Core2.JsonSerialized.practice;

public class LastLikeInfo {
    private String user;
    private int hours;
    private int minutes;

    public LastLikeInfo(String user, int hours, int minutes) {
        this.user = user;
        this.hours = hours;
        this.minutes = minutes;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}

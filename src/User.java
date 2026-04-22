public class User {
    private String username;
    private String school;
    private String sessionName;

    public User(String username, String school, String sessionName) {
        this.username = username;
        this.school = school;
        this.sessionName = sessionName;
    }

    public boolean isValid() {
        return !username.isEmpty() && !school.isEmpty() && !sessionName.isEmpty();
    }
}
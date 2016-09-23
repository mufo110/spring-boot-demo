package demo.springboot.model;

public class Users {

    private String  username;

    private String  password;

    private Integer enabled;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

}

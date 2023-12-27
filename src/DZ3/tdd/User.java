package DZ3.tdd;

public class User {

    String name;
    String password;
    private boolean isAdmin;
    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String name, String password) {
        this(name, password, false);
    }

    //3.6.
    public void login(String name, String password) {
        if (name.equals(this.name) && password.equals(this.password)) {
            isAuthenticate = true;
        }
    }

    /**
     * Abstract user logout method, when the authenticate field is set to false
     */
    public void disconnect() {
        isAuthenticate = false;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }

}
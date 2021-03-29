package Entity;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}

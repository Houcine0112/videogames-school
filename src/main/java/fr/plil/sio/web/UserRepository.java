package fr.plil.sio.web;

import java.util.Set;
import java.util.TreeSet;

/**
 * The user DAO, which keeps all user instances in a simple set.
 *
 * @author Julien Iguchi-Cartigny
 */
public class UserRepository {

    private Set<User> users = new TreeSet<User>();

    public boolean addUser(User user) {
        return users.add(user);
    }

    public User getUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public Set<User> getUsers() {
        return users;
    }
    
}

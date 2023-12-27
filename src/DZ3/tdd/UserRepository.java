package DZ3.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAuthenticate) {
            data.add(user);
        }
    }

//    public boolean findByName(String username) {
//        for (User user : data) {
//            if (user.name.equals(username)) {
//                return true;
//            }
//        }
//        return false;
//    }

    // Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей,
    // кроме администраторов.
    // Для этого, вам потребуется расширить класс User новым свойством, указывающим,
    // обладает ли пользователь админскими правами. Протестируйте данную функцию.

    /**
     * This method disconnecting all users without admin rights and remove them from list of connected users
     */
    public void forceUsersLogout() {
        // Разлогиниваем всех пользователей
        data.stream().filter(user -> !user.isAdmin()).forEach(User::disconnect);
        // Удаляем из списка не аутентифицированных пользователей
        data = data.stream().filter(User::isAdmin).toList();
    }

    public List<User> getData() {
        return data;
    }
}
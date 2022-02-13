package web_crud.dao;


import web_crud.model.User;

import java.util.List;

public interface UserDao {
    void saveNewUser(User user);

    List<User> getUsersList();

    User findById(Long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    User findByEmail(String email);


}

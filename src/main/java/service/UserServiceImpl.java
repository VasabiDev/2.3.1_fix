package service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserRepository;
import web.model.User;


@Service
public class UserServiceImpl {

    private final UserRepository userDao;

    @Autowired

    public UserServiceImpl(UserRepository userDao) {
        this.userDao = userDao;
    }


    @Transactional
    public void userAdd(String name, String email, String pass) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPass(pass);
        userDao.save(user);
    }

    @Transactional
    public void userEdit(int id, String name, String email, String pass) {
        User user = getById(id);
        user.setName(name);
        user.setEmail(email);
        user.setPass(pass);
        userDao.save(user);
    }

    @Transactional
    public User getById(int id) {
        return userDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

    }

    @Transactional
    public void delete(User user) {
        userDao.delete(user);

    }

    @Transactional
    public Iterable<User> getAll() {
        return userDao.findAll();
    }


}

package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;
import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandr on 28.01.16.
 */
public class MainModel implements Model
{
    private UserService userService = new UserServiceImpl();
    private ModelData modelData =  new ModelData();
    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getActiveUsers(userService.getUsersBetweenLevels(1,100)));

    }
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long id)
    {
        User user = userService.deleteUser(id);
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getActiveUsers(userService.getUsersBetweenLevels(1, 100)));
    }

    private List<User> getActiveUsers(List<User> userList){
        return userService.filterOnlyActiveUsers(userList);
    }
    public void changeUserData(String name, long id, int level){
        User user = userService.createOrUpdateUser(name,id,level);
        modelData.setUsers(getActiveUsers(userService.getUsersBetweenLevels(1,100)));
    }
}

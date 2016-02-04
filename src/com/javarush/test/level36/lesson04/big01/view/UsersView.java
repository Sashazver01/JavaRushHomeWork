package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;
import com.javarush.test.level36.lesson04.big01.bean.User;

/**
 * Created by alexandr on 28.01.16.
 */
public class UsersView implements View
{
    private Controller controller;

    @Override
    public void refresh(ModelData modelData)
    {
        if (modelData.isDisplayDeletedUserList()){
            System.out.println("All deleted users:");
        }else
        {
            System.out.println("All users:");
        }

        for (User user : modelData.getUsers())
          {
                System.out.println("    " + user);
            }
            System.out.println("===================================================");

    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }
    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }


}

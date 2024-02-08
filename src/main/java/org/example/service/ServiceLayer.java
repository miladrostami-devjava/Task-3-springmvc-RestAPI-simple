package org.example.service;

import org.example.controller.dto.User;
import org.springframework.stereotype.Service;
//todo step13: add service
@Service
public class ServiceLayer {

    public User h7(User user){
        user.setName(user.getName() + "name updated") ;
        user.setFamily(user.getFamily() + "family updated");
        return user;
    }

    //todo step19: other method
    public User h11(User user){
        if (user.getName().equals("miladrostami")){
            user.setName(user.getName() + "name updated") ;
            user.setFamily(user.getFamily() + "family updated");
            return user;
        }else {
            return null;
        }

    }


}

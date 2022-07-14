package beaconkorea.service;

import beaconkorea.DAO.userDAO;
import beaconkorea.DTO.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userService {
    @Autowired
    public userDAO userDAO;

    public List<UserDto> getAllUser(){
        System.out.println("userDAO.getAllUser() : " + userDAO.getAllUser().toString());
        return userDAO.getAllUser();
    }

    public void createUser(UserDto userDto){
        userDAO.createUser(userDto);
    }
}

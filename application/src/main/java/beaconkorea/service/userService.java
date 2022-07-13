package beaconkorea.service;

import beaconkorea.DAO.userDAO;
import beaconkorea.DTO.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private userDAO userDAO;

    public int createUser(String id, String pw){
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setPw(pw);
        System.out.println(userDto);
        return userDAO.createUser(userDto);
    }
}

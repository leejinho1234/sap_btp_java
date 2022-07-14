package beaconkorea.DAO;

import beaconkorea.DTO.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface userDAO {
    void createUser(UserDto userDto);
    List<UserDto> getAllUser();
}

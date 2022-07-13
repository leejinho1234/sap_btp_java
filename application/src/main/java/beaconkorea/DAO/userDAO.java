package beaconkorea.DAO;

import beaconkorea.DTO.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userDAO {
    int createUser(UserDto userDto);
}

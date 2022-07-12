package beaconkorea.mapper;

import beaconkorea.DTO.UserDto;

import java.util.List;
@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    public List<UserDto> listmap();
    void setUserDto(UserDto user);
}

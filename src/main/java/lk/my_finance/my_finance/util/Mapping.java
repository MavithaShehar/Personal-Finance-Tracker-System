package lk.my_finance.my_finance.util;

import lk.my_finance.my_finance.dto.UserDTO;
import lk.my_finance.my_finance.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

public class Mapping {

    private final ModelMapper mapper;

    public Mapping(ModelMapper mapper) {
        this.mapper = mapper;
    }
    //UserMapping
    public User toUser(UserDTO userDTO) {
        return mapper.map(userDTO, User.class);
    }
    public UserDTO toUserDTO(User user) {
        return  mapper.map(user, UserDTO.class);
    }


}

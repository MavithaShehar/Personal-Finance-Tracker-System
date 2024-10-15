package lk.my_finance.my_finance.service;

import lk.my_finance.my_finance.dto.UserDTO;
import lk.my_finance.my_finance.entity.User;
import lk.my_finance.my_finance.util.VarList;

public class CategoryService {

    public String saveUser(UserDTO userDTO) {

        if (userRepo.existsById(userDTO.getUserId())){
            return VarList.RSP_DUPLICATED;
        }else {
            userRepo.save(modelMapper.map(userDTO, User.class));
            return VarList.RSP_SUCCESS;
        }

    }

}

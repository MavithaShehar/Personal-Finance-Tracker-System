package lk.my_finance.my_finance.service;

import lk.my_finance.my_finance.dto.UserDTO;
import lk.my_finance.my_finance.entity.User;
import lk.my_finance.my_finance.repo.UserRepo;
import lk.my_finance.my_finance.util.VarList;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Transactional
@RequiredArgsConstructor

public class UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public String saveUser(UserDTO userDTO) {

        if (userRepo.existsById(userDTO.getUserId())){
            return VarList.RSP_DUPLICATED;
        }else {
            userRepo.save(modelMapper.map(userDTO, User.class));
            return VarList.RSP_SUCCESS;
        }

    }

    public String updateUser(UserDTO userDTO) {

        if (userRepo.existsById(userDTO.getUserId())){
            userRepo.save(modelMapper.map(userDTO, User.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }

    }


    public UserDTO getUser(int userId) {

        if (userRepo.existsById(userId)){
            User user = userRepo.getUserById(userId);
            return modelMapper.map(user,UserDTO.class);
        }
        return new UserDTO(0,null,null,null);
    }

}

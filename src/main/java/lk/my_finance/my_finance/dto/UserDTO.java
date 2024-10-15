package lk.my_finance.my_finance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private int userId;
    private String userName;
    private String userPassword;
    private String email;


}

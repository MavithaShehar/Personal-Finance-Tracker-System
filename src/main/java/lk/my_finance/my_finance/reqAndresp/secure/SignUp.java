package lk.my_finance.my_finance.reqAndresp.secure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class SignUp {
    private int userId;
    private String userName;
    private String userPassword;
    private String email;
}

package lk.my_finance.my_finance.reqAndresp.secure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class SignIn {
    private String email;
    private String userPassword;
}

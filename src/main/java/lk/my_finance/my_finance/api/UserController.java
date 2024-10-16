package lk.my_finance.my_finance.api;

import lk.my_finance.my_finance.dto.UserDTO;
import lk.my_finance.my_finance.reqAndresp.response.JwtAuthResponse;
import lk.my_finance.my_finance.reqAndresp.secure.SignIn;
import lk.my_finance.my_finance.reqAndresp.secure.SignUp;
import lk.my_finance.my_finance.service.AuthenticationService;
import lk.my_finance.my_finance.service.UserService;
import lk.my_finance.my_finance.util.VarList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping
    public String saveUser(@RequestBody UserDTO userDTO) {

        String req = userService.saveUser(userDTO);
        if (req.equals("00")) {
            return req;
        }else {
            return VarList.RSP_ERROR;
        }

    }

    @PutMapping
    public String updateUser(@RequestBody UserDTO userDTO) {

        String req = userService.updateUser(userDTO);
        if (req.equals("00")) {
            return req;
        }else {
            return VarList.RSP_ERROR;
        }

    }

    @GetMapping("{userId}")
    public UserDTO getUser(@PathVariable  int userId) {
        System.out.println("hi");
        UserDTO userDTO = userService.getUser(userId);
        if (userDTO != null) {
            return userDTO;
        }else {
            return userDTO;
        }

    }


    @GetMapping("healthCheck")
    public String getMessage() {
        return "Hello";
    }
}

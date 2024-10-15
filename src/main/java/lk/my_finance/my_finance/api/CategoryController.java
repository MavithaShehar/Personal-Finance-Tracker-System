package lk.my_finance.my_finance.api;

import lk.my_finance.my_finance.dto.UserDTO;
import lk.my_finance.my_finance.util.VarList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor

public class CategoryController {

    @PostMapping
    public String saveUser(@RequestBody UserDTO userDTO) {

        String req = userService.saveUser(userDTO);
        if (req.equals("00")) {
            return req;
        }else {
            return VarList.RSP_ERROR;
        }

    }

    @GetMapping("healthCheck")
    public String getMessage() {
        return "Hello";
    }


}

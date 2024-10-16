package lk.my_finance.my_finance.api;

import lk.my_finance.my_finance.reqAndresp.response.JwtAuthResponse;
import lk.my_finance.my_finance.reqAndresp.secure.SignIn;
import lk.my_finance.my_finance.reqAndresp.secure.SignUp;
import lk.my_finance.my_finance.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor

public class userSecurity {

    private final AuthenticationService authenticationService;
    //signup
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq) {
        return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }
    //signIn
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signInReq) {
        System.out.println("hiii 01");
        System.out.println("hi 01 + "+signInReq);
        return ResponseEntity.ok(authenticationService.signIn(signInReq));
    }
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }
}

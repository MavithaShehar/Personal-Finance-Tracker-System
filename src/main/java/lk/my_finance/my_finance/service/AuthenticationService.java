package lk.my_finance.my_finance.service;



import lk.my_finance.my_finance.dto.UserDTO;
import lk.my_finance.my_finance.entity.User;
import lk.my_finance.my_finance.repo.UserRepo;
import lk.my_finance.my_finance.reqAndresp.response.JwtAuthResponse;
import lk.my_finance.my_finance.reqAndresp.secure.SignIn;
import lk.my_finance.my_finance.reqAndresp.secure.SignUp;
import lk.my_finance.my_finance.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class AuthenticationService {

    private final UserRepo userRepo;
    private final JWTService jwtService;
    public  Mapping mapping;
    private final ModelMapper mapper;
    //utils
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public JwtAuthResponse signIn(SignIn signIn) {
        System.out.println("hi 02 email + "+signIn.getEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getUserPassword()));
        var userByEmail = userRepo.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        System.out.println("hi 02 email + "+userByEmail);
        var generatedToken = jwtService.generateToken((UserDetails) userByEmail);
        return JwtAuthResponse.builder().token(generatedToken).build() ;
    }


    public JwtAuthResponse signUp(SignUp signUp) {
        var buildUser = UserDTO.builder()
                .userId(new Random().nextInt(9000) + 1000)
                .email(signUp.getEmail())
                .userName(signUp.getUserName())
                .userPassword(passwordEncoder.encode(signUp.getUserPassword()))
                .build();
        var savedUser = userRepo.save(mapper.map(buildUser, User.class));
        var genToken = jwtService.generateToken(savedUser);
        return JwtAuthResponse.builder().token(genToken).build();
    }

    public JwtAuthResponse refreshToken(String accessToken) {
        var userName = jwtService.extractUsername(accessToken);
        var user = userRepo.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.generateToken((UserDetails) user);
        return JwtAuthResponse.builder().token(refreshToken).build();
    }
}

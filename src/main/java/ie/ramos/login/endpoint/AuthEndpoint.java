package ie.ramos.login.endpoint;

import ie.ramos.login.endpoint.dto.LoginRequestDTO;
import ie.ramos.login.endpoint.dto.RegisterDTO;
import ie.ramos.login.endpoint.mapper.AuthMapper;
import ie.ramos.login.security.jwt.JwtResponse;
import ie.ramos.login.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthEndpoint {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthMapper authMapper;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return authService.login(loginRequestDTO.getUserName().toLowerCase(), loginRequestDTO.getPassword());
    }

    @PostMapping("/register")
    public JwtResponse register(@RequestBody @Valid RegisterDTO registerDTO) {
        return authService.register(authMapper.mapToUser(registerDTO));
    }

}

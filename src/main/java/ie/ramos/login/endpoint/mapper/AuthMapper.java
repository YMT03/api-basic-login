package ie.ramos.login.endpoint.mapper;

import ie.ramos.login.endpoint.dto.RegisterDTO;
import ie.ramos.login.model.Role;
import ie.ramos.login.model.User;
import ie.ramos.login.model.UserBasicInfo;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AuthMapper {

    public User mapToUser(RegisterDTO registerDTO) {
        UserBasicInfo userBasicInfo = new UserBasicInfo(null, registerDTO.getName(), registerDTO.getLastName(),
                registerDTO.getDocumentNumber(), false, registerDTO.getEmail());
        return new User(null, registerDTO.getUserName().toLowerCase(), registerDTO.getPassword(), true,
                Arrays.asList(new Role("USER")), userBasicInfo);
    }

}

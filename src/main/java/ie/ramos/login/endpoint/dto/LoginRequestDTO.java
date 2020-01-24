package ie.ramos.login.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDTO {

    @JsonProperty("UserName")
    @NotBlank
    private String userName;

    @NotBlank
    @JsonProperty("Password")
    private String password;

}

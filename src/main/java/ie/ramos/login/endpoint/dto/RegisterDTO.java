package ie.ramos.login.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegisterDTO {

    @NotBlank
    @JsonProperty("Name")
    @Length(max = 100)
    private String name;

    @NotBlank
    @JsonProperty("LastName")
    @Length(max = 100)
    private String lastName;

    @NotBlank
    @JsonProperty("DocumentNumber")
    @Length(min = 6, max = 50)
    private String documentNumber;

    @JsonProperty("UserName")
    @NotBlank
    @Length(min = 8, max = 50)
    private String userName;

    @NotBlank
    @JsonProperty("Password")
    @Length(min = 10, max = 50)
    private String password;

    @NotBlank
    @JsonProperty("Email")
    @Email
    private String email;

}

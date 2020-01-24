package ie.ramos.login.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_BASIC_INFO")
public class UserBasicInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;
    @Column(name = "TRUSTED_MAIL")
    private Boolean trustedMail;
    @Column(name = "EMAIL", unique = true)
    private String email;
}

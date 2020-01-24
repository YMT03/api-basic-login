package ie.ramos.login.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuthentication extends UsernamePasswordAuthenticationToken {

    private UserBasicInfo userBasicInfo;

    public UserAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities,
            UserBasicInfo userBasicInfo) {
        super(principal, credentials, authorities);
        this.userBasicInfo = userBasicInfo;
    }

    public UserBasicInfo getUserBasicInfo() {
        return userBasicInfo;
    }
}

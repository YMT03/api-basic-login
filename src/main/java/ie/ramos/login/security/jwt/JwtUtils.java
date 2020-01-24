package ie.ramos.login.security.jwt;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtUtils {

    private final Environment environment;
    private final String JWT_SECRET_KEY = "JWT.SK";
    private final String JWT_DURATION_KEY = "JWT.D";
    private final byte[] JWT_SECRET;
    private final Long JWT_EXPIRATION_TIME;

    public JwtUtils(@Autowired Environment environment) {
        this.environment = environment;
        log.debug("Generating JWT SECRET KEY and EXPIRATION TIME");
        JWT_SECRET = environment.getProperty(JWT_SECRET_KEY).getBytes();
        log.debug("JWT_SECRET -> " + JWT_SECRET);
        JWT_EXPIRATION_TIME = Long.valueOf(environment.getProperty(JWT_DURATION_KEY));
        log.debug("JWT EXPIRATION TIME -> " + JWT_EXPIRATION_TIME);
    }

    public String getUserNameFromToken(String token) {
        log.debug("Getting userName from String:token");
        try {
            return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
        } catch (JwtException e) {
            log.error("Not trusted Token.");
            throw e;
        }
    }

    public String generateToken(String userName) {
        log.debug("Generating token -> Exp:" + new Date(new Date().getTime() + JWT_EXPIRATION_TIME) + " for userName: "
                + userName);
        return Jwts.builder().setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME))
                .signWith(Keys.hmacShaKeyFor(JWT_SECRET)).compact();
    }
}

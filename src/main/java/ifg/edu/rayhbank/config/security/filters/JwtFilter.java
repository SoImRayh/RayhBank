package ifg.edu.rayhbank.config.security.filters;

import ifg.edu.rayhbank.config.security.jwt.JwtHelper;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtHelper jwtHelper;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token  = getToken(request);
        var claims = jwtHelper.parseClaims(token);
        SecurityContextHolder.getContext().setAuthentication(createAuthentication(claims));
        filterChain.doFilter(request ,response);

    }

    private Authentication createAuthentication(Map<String, Object> claims) {
        var roles = Arrays.stream(claims.get("roles").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(claims.get(Claims.SUBJECT), null , roles);
    }

    private String getToken(HttpServletRequest request){
        return Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .filter(auth -> auth.startsWith("bearer "))
                .map(auth -> auth.replace("bearer ", ""))
                .orElseThrow(() -> new BadCredentialsException("token invalido, por favor faça login e tente mais tarde"));
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getRequestURI().startsWith("/login");
    }
}

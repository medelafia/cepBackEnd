package com.med.accountservice.config.filters;


import com.med.accountservice.config.service.JwtConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.security.Key;
import java.util.List;

public class JwtFilter extends OncePerRequestFilter  {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader("Authorization")  ;
        if( jwt != null && jwt.startsWith("Bearer ")) {
            jwt = jwt.substring(7) ;
            try {
                Key secretKey = JwtConstant.secret ;
                Claims claims = Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(jwt).getBody() ;
                String authorities = String.valueOf(claims.get("authority"));
                String username = String.valueOf(claims.get("username")) ;
                List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
                Authentication authentication = new UsernamePasswordAuthenticationToken(username , null , auth ) ;
                SecurityContextHolder.getContext().setAuthentication(authentication);
                authentication.getAuthorities().forEach(elem -> System.out.println(elem.getAuthority()));
            }catch (Exception exception) {
                throw new BadCredentialsException("invalid token") ;
            }
        }
        filterChain.doFilter(request, response);
    }
}

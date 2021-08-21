package core.security.jwt;

import core.security.PortalUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.Port;
import java.io.IOException;

@Service
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try
        {
            if (!request.getServletPath().equals("/auth/login"))
            {
                PortalUtil.setCurrentRequest(request);
                final String requestTokenHeader = request.getHeader(HEADER_STRING);

                String username = null;
                String jwtToken = null;

                // JWT Token está no form "Bearer token". Remova a palavra Bearer e pegue somente o Token
                if (requestTokenHeader != null && requestTokenHeader.startsWith(TOKEN_PREFIX)) {
                    jwtToken = requestTokenHeader.substring(7);
                    try {
                        if (jwtToken.equals("null")) {
                            logger.warn("Token is null");
                        }
                        username = jwtTokenUtil.getUsernameFromToken(jwtToken);

                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Unable to get JWT Token");
                    }
                    catch (ExpiredJwtException e) {
                        System.out.println("JWT Token has expired");
                    }
                } else {
                    logger.warn("JWT Token does not begin with Bearer String");
                }

// Tendo o token, valide o.
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);



                    if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                        PortalUtil.setCurrentUser(this.jwtUserDetailsService.findByLogin(username));
                        PortalUtil.setCurrentRequest(request);
                    }
                }
            }

            chain.doFilter(request, response);
        }
        catch (Exception e)
        {

        }
        finally {
            // FIXME verificar a utilização disso.
            PortalUtil.setCurrentRequest(null);
            PortalUtil.setCurrentUser(null);
        }
    }

}

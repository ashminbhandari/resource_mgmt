package com.itlize.resrcmgmt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itlize.resrcmgmt.service.JpaUserDetailsService;
import com.itlize.resrcmgmt.service.JwtTokenBlacklistService;
import com.itlize.resrcmgmt.util.JwtUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);

    @Autowired
    private JpaUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
	private JwtTokenBlacklistService jwtBlacklist;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        // Whether Bearer is included in Authorization, if one is not included, return
        // directly
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        // Whether Authorization is included in the header of the request body
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            logger.info("Start to validate JWT");

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwt, userDetails) && jwtBlacklist.check(jwt)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                logger.debug(SecurityContextHolder.getContext().getAuthentication().getPrincipal() == null ? "a" : "b");

                logger.info("JWT is valid and security context is updated");

            } else {

                logger.info("Invalid or expired JWT");
                
            }


        } else if (username == null) {

            logger.info("The request doesn't contain JWT");

        } else {

            logger.info("Authenticated before");

        }
        
        chain.doFilter(request, response);
    }

}
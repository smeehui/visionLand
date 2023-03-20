//package com.hah.security;
//
//import com.hah.service.jwt.JwtService;
//import com.hah.service.user.IUserService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.lang.NonNull;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    @Autowired
//    private JwtService jwtService;
//
//    @Autowired
//    private IUserService userService;
//
//
//    @Override
//    protected void doFilterInternal(
//            @NonNull HttpServletRequest request,
//            @NonNull HttpServletResponse response,
//            @NonNull FilterChain filterChain
//    ) throws ServletException, IOException {
//
//        final String authHeader = request.getHeader("Authorization");
//        String jwt = getCookieValue(request);
//        final String username;
//        if (authHeader != null) {
//            jwt = authHeader.replace("Bearer ", "");
//        }
//        else if (jwt == null) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        username = jwtService.extractUserName(jwt);
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = userService.loadUserByUsername(username);
//            boolean isTokenValid = jwtService.isTokenValid(jwt, userDetails);
//            if (isTokenValid) {
//                UsernamePasswordAuthenticationToken authenticationToken
//                        = new UsernamePasswordAuthenticationToken(
//                        userDetails,
//                        null,
//                        userDetails.getAuthorities()
//                );
//
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    private String getCookieValue(HttpServletRequest req) {
//        Cookie[] cookies = req.getCookies();
//
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("jwtToken")) {
//                    return cookie.getValue();
//                }
//            }
//        }
//
//        return null;
//    }
//
////    @Override
////    protected void doFilterInternal(HttpServletRequest request,
////                                    HttpServletResponse response,
////                                    FilterChain filterChain)
////            throws ServletException, IOException {
////        try {
////            String jwt = getJwtFromRequest(request);
////            if (jwt != null && jwtService.validateJwtToken(jwt)) {
////                String username = jwtService.extractUserName(jwt);
////
////                UserDetails userDetails = userService.loadUserByUsername(username);
////                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
////                        userDetails, null, userDetails.getAuthorities());
////                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
////                SecurityContextHolder.getContext().setAuthentication(authentication);
////            }
////        } catch (Exception e) {
////            logger.error("Can NOT set user authentication -> Message: {}", e);
////        }
////
////        filterChain.doFilter(request, response);
////    }
////
////    private String getJwtFromRequest(HttpServletRequest request) {
////        String authHeader = request.getHeader("Authorization");
////
////        if (authHeader != null && authHeader.startsWith("Bearer ")) {
////            return authHeader.replace("Bearer ", "");
////        }
//
////        return null;
////    }
//}
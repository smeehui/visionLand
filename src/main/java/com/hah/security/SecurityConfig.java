package com.hah.security;


import com.hah.repository.UserRepository;
import com.hah.service.userService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private IUserService userService;
    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;
    @Autowired
    private AuthenticationProvider authenticationProvider;
//    private final IUserService userService;
//
//    private final JwtAuthenticationFilter jwtAuthFilter;
//
//    private final AuthenticationProvider authenticationProvider;


//    @Autowired
//    public SecurityConfig(
//            IUserService userService,
//            AuthenticationProvider authenticationProvider,
//            JwtAuthenticationFilter jwtAuthFilter
//    ) {
//        this.userService = userService;
//        this.authenticationProvider = authenticationProvider;
//        this.jwtAuthFilter = jwtAuthFilter;
//    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return authentication -> authenticationProvider.authenticate(authentication);
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .requestMatchers(
//                        "/",
//                        "/index",
//                        "/assets/**",
//                        "/api/auth/**",
//                        "/shop",
//                        "/login")
//                .permitAll()
//                .requestMatchers(HttpMethod.GET,"/api/users/**","/api/products/**")
//                .permitAll()
//                .requestMatchers("/api/carts/**")
//                .hasAnyAuthority("ROLE_ADMIN","ROLE_MODERATOR","ROLE_USER")
//                .requestMatchers("/management/**")
//                .hasAnyAuthority("ROLE_ADMIN","ROLE_MODERATOR")
////                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
////                .loginProcessingUrl("/auth/login")
////                .defaultSuccessUrl("/index", true)
////                .failureUrl("/login?err=true")
//                .usernameParameter("username").passwordParameter("password")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .clearAuthentication(true)
//                .deleteCookies("jwtToken")
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling()
//                .accessDeniedHandler(customAccessDeniedHandler())
//        ;
        http
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/**")
                        .permitAll()
                        .anyRequest().authenticated()
                )
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .permitAll())
//                .logout((logout) -> logout
//                        .permitAll()
//                        .logoutUrl("/logout")
//                        .clearAuthentication(true)
//                        .deleteCookies("jwtToken"))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .accessDeniedHandler(customAccessDeniedHandler())
                .authenticationEntryPoint(restServicesEntryPoint())
                .and().httpBasic();
//
        return http.build();
    }

    @Bean
    protected UserDetailsService userDetailsService() {

        return username -> userService.loadUserByUsername(username);
    }

    @Bean
    protected AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
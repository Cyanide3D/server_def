package com.defiant.server.config;

import com.defiant.server.model.User;
import com.defiant.server.repository.UserRepo;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Locale;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebConfigure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/js/**", "/error**").permitAll()
                .anyRequest().permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserRepo repo) {
        return map -> {
            String id = (String) map.get("id");

            User user = repo.findById(Long.parseLong(id)).orElseGet(() -> {
                User newUser = new User();

                newUser.setId(Long.parseLong(id));
                newUser.setUsername((String) map.get("username"));
                newUser.setEmail((String) map.get("email"));
                newUser.setLocale(new Locale((String) map.get("locale")));

                return newUser;
            });

            return repo.save(user);
        };
    }

}

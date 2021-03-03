package pl.kowalczyk.springbootimageuploader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.kowalczyk.springbootimageuploader.model.AppUser;
import pl.kowalczyk.springbootimageuploader.repository.AppUserRepo;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;
    private AppUserRepo appUserRepo;

    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, AppUserRepo appUserRepo) {
        this.userDetailsService = userDetailsService;
        this.appUserRepo = appUserRepo;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test1").authenticated()
                .antMatchers("/test2").hasAnyRole("USER", "ADMIN")
                .antMatchers("/upload").permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @EventListener(ApplicationContextEvent.class)
    public void get() {
        AppUser appUser = new AppUser("Jan", passwordEncoder().encode("Nowak"), "ROLE_USER");
        AppUser appUser2 = new AppUser("Robert", passwordEncoder().encode("Nowak"), "ROLE_ADMIN");
        appUserRepo.save(appUser);
        appUserRepo.save(appUser2);
    }


}

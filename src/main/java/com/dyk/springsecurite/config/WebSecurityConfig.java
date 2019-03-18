package com.dyk.springsecurite.config;



import com.dyk.springsecurite.authentication.AuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**

 *  WebSecurityConfig is a config class for Security

 * @author andre

 * @Time 2018/11/01

 *

 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Bean
   public PasswordEncoder passwordEncoder(){
       return  new BCryptPasswordEncoder();
   }
    /**
     *
     *  method for Basic security configuration
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/login").permitAll()
                .antMatchers("/level1/**").hasRole("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(myAuthenticationSuccessHandler);
                //.loginProcessingUrl("/login");

        http.csrf().disable();
    }

//    /**
//     * ignore interception of static resource
//     *
//     * @param web
//     * @throws Exception
//     */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//
//        web.ignoring().antMatchers("/static/**");
//    }

}


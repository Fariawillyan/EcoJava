package com.LearningSecurity.Config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Aqui estamos criando o Usuario,Senha e a permissão que ele irá ter
        //O passwordencoder é usado para criptografar a senha e por padrão ele irá usar o bcrypt mas você consegue alterar para outro padrão de criptografia se querer

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication().withUser("Artur")
                        .password(passwordEncoder.encode("hackforit"))
                                .roles("USER", "ADMIN")
                                        .and()
                                                .withUser("Vitor")
                                                        .password(passwordEncoder.encode("123456"))
                                                                .roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Aqui estamos configurando como o Security irá se comportar, nesse caso estamos authorizando requisições depois colocamos quando a permissão do usuario irá se comportar
        //E após isso usamos o formLogin para criar a pagina padrão do security que iremos conseguir logar pelo navegador
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/test/admin/**").hasRole("ADMIN")
                .antMatchers("/test/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }
}

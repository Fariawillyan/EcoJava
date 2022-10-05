package com.LearningSecurity.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class Requests {

    //Aqui não exige que o usuario tenha permissão para conseguir acessar
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    //Aqui estámos requerendo que o usuario tenha permissão de Admin para conseguir acessar essa função usando o PreAuthorize
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adm(){
        return "Hello Admin";
    }
    //Aqui estámos requendo que o usuario tenha permissão de USER para conseguir acessar essa função usando o PreAuthorize
    @GetMapping("/user/usuario")
    @PreAuthorize("hasRole('USER')")
    public String usuario(){
        return "Hello User";
    }

}

package com.example.demo.adapters.out.persistence.entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class Teste {
    @GetMapping
    public String teste(){
        return "JWT funcionando";
    }
}
/*  ambiente de teste de endpoint protegido por JWT 
para verificar se a autenticação e autorização 
estão funcionando corretamente. */
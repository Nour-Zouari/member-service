package com.example.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.beans.EvenementBean;

@FeignClient(name = "EVENEMENT-SERVICE")
public interface EvenementProxy {

    @GetMapping("/evenements/{id}")
    EvenementBean findEvenementById(@PathVariable Long id);
}

package com.example.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.beans.OutilBean;

@FeignClient(name = "OUTIL-SERVICE")
public interface OutilProxy {

    @GetMapping("/outils/{id}")
    OutilBean findOutilById(@PathVariable Long id);
}

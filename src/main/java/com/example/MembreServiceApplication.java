package com.example;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.dao.EnseignantChercheurRepository;
import com.example.dao.EtudiantRepository;
import com.example.dao.MembreRepository;
import com.example.entities.EnseignantChercheur;
import com.example.entities.Etudiant;
import com.example.entities.Membre;
import com.example.proxies.PublicationProxyService;
import com.example.service.MemberImpl;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
@EnableFeignClients
public class MembreServiceApplication implements CommandLineRunner {
	MembreRepository membreRepository;
	EtudiantRepository etudiantRepository;
	EnseignantChercheurRepository enseignantChercheurRepository;
	MemberImpl memberService;
	 private PublicationProxyService publicationProxy;
	

	public static void main(String[] args) {
		SpringApplication.run(MembreServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			 
	}
	

}

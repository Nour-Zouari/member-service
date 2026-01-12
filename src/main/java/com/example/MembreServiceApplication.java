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
		Etudiant etd1=Etudiant.builder()
				 .cin("123456")
				 .password("pass1")
				 .cv("cv1")
				 .nom("abid")
				 .prenom("youssef)")
				 .build();
		etudiantRepository.save(etd1);
		EnseignantChercheur ens1=EnseignantChercheur.builder().cin("48579").nom("nour").build();
		enseignantChercheurRepository.save(ens1);
		 Etudiant etd2 = Etudiant.builder()
		            .nom("alami")
		            .prenom("karim")
		            .build();
		    etudiantRepository.save(etd2);
		    List<Etudiant> etudiantsTrouves = etudiantRepository.chercher("a%");

		   
		    System.out.println("--- Étudiants trouvés ---");
		    etudiantsTrouves.forEach(etd -> System.out.println(etd.getNom() + " " + etd.getPrenom()));
		    System.out.println("-------------------------");
		    
		    Membre m= memberService.findMember(1L);
			 m.setCv("cv1.pdf");
			 memberService.updateMember(m);
			 
			// Delete a Member
			 
			 memberService.affecter_Etudiant_Enseignant(1L, 2L);
			 memberService.affecter_Etudiant_Enseignant(3L, 2L);
			 List<Etudiant> etudiantsAffectés=memberService.findEtudiantByEnseignant(ens1);
			 System.out.println("--- Étudiants Affectés A l'enseignant ---");
			 etudiantsAffectés.forEach(etd -> System.out.println(etd.getNom() + " " + etd.getPrenom()));
			    System.out.println("-------------------------");
			    
			    System.out.println("publication 1"+publicationProxy.findPublicationById(1L));
			    memberService.affecterauteurTopublication(2L, 1L);
			    memberService.affecterauteurTopublication(2L, 2L);
			 
	}
	

}

package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.beans.PublicationBean;
import com.example.dao.EnseignantChercheurRepository;
import com.example.dao.EtudiantRepository;
import com.example.dao.MembrePubRepository;
import com.example.dao.MembreRepository;
import com.example.entities.EnseignantChercheur;
import com.example.entities.Etudiant;
import com.example.entities.Membre;
import com.example.entities.Membre_Pub_Id;
import com.example.entities.Membre_publication;
import com.example.proxies.PublicationProxyService;

import lombok.AllArgsConstructor;
import com.example.beans.EvenementBean;
import com.example.beans.OutilBean;
import com.example.dao.MembreEventRepository;
import com.example.dao.MembreOutilRepository;
import com.example.entities.Membre_Evenement;
import com.example.entities.Membre_Event_Id;
import com.example.entities.Membre_Outil;
import com.example.entities.Membre_Outil_Id;
import com.example.proxies.EvenementProxy;
import com.example.proxies.OutilProxy;

@AllArgsConstructor
@Service
public class MemberImpl implements IMemberService {
	MembreRepository membreRepository;
	EtudiantRepository etudiantRepository;
	EnseignantChercheurRepository enseignantChercheurRepository;
	MembrePubRepository membrepubrepository;
	PublicationProxyService proxy;
	MembreEventRepository membreEventRepository;
	EvenementProxy evenementProxy;
	MembreOutilRepository membreOutilRepository;
	OutilProxy outilProxy;


	@Override
	public Membre addMember(Membre m) {
		membreRepository.save(m);
		return m;
	}

	@Override
	public void deleteMember(Long id) {
		membreRepository.deleteById(id);

	}

	@Override
	public Membre updateMember(Membre m) {
		membreRepository.saveAndFlush(m);
		return m;

	}

	@Override
	public Membre findMember(Long id) {
		Membre m = membreRepository.findById(id).get();
		return m;

	}

	@Override
	public List<Membre> findAll() {
		return membreRepository.findAll();
	}

	@Override
	public Membre findByCin(String cin) {
		return membreRepository.findByCin(cin);
	}

	@Override
	public Membre findByEmail(String email) {
		return membreRepository.findByEmail(email);
	}

	@Override
	public List<Membre> findByNom(String nom) {
		return membreRepository.findByNomStartingWith(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

	@Override
	public void affecter_Etudiant_Enseignant(long idEtd, long idEns) {
		Etudiant etd = etudiantRepository.findById(idEtd).get();
		EnseignantChercheur ens = enseignantChercheurRepository.findById(idEns).get();
		etd.setEncadrant(ens);
		etudiantRepository.save(etd);
	}

	@Override
	public List<Etudiant> findEtudiantByEnseignant(EnseignantChercheur ens) {
		return etudiantRepository.findByEncadrant(ens);
	}

	public void affecterauteurTopublication(Long idauteur, Long idpub) {
		Membre mbr = membreRepository.findById(idauteur).get();
		Membre_publication mbs = new Membre_publication();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Pub_Id(idpub, idauteur));
		membrepubrepository.save(mbs);
	}

	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs = new ArrayList<PublicationBean>();
		List<Membre_publication> idpubs = membrepubrepository.findpubId(idauteur);
		idpubs.forEach(s -> {
			System.out.println(s);
			pubs.add(proxy.findPublicationById(s.getId().getPublication_id()));
		});
		return pubs;
	}
	// =======================
	// Liaison Membre - Evenement
	// =======================

	@Override
	public void affecterMembreToEvenement(Long idMembre, Long idEvent) {
	    Membre mbr = membreRepository.findById(idMembre).get();

	    Membre_Evenement me = new Membre_Evenement();
	    me.setMembre(mbr);
	    me.setId(new Membre_Event_Id(idEvent, idMembre));

	    membreEventRepository.save(me);
	}

	@Override
	public List<EvenementBean> findEvenementsByMembre(Long idMembre) {
	    List<EvenementBean> events = new ArrayList<>();

	    List<Membre_Evenement> idEvents =
	            membreEventRepository.findEvents(idMembre);

	    idEvents.forEach(e ->
	        events.add(
	            evenementProxy.findEvenementById(
	                e.getId().getEvenement_id()
	            )
	        )
	    );

	    return events;
	}
	@Override
	public List<OutilBean> findOutilsByMembre(Long idMembre) {
	    List<OutilBean> res = new ArrayList<>();
	    membreOutilRepository.findOutils(idMembre)
	        .forEach(o ->
	            res.add(outilProxy.findOutilById(
	                o.getId().getOutil_id()))
	        );
	    return res;
	}
	@Override
	public void affecterMembreToOutil(Long idMembre, Long idOutil) {

	    Membre mbr = membreRepository.findById(idMembre).get();

	    Membre_Outil mo = new Membre_Outil();
	    mo.setMembre(mbr);
	    mo.setId(new Membre_Outil_Id(idOutil, idMembre));

	    membreOutilRepository.save(mo);
	}



}

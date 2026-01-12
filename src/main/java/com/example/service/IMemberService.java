package com.example.service;

import java.util.List;

import com.example.beans.PublicationBean;
import com.example.entities.EnseignantChercheur;
import com.example.entities.Etudiant;
import com.example.entities.Membre;
import com.example.beans.EvenementBean;
import com.example.beans.OutilBean;
import com.example.beans.EvenementBean;

public interface IMemberService {
	 //Crud sur les membres 
	public Membre addMember(Membre m);
	 public void deleteMember(Long id) ;
	 public Membre updateMember(Membre p) ;
	 public Membre findMember(Long id) ;
	 public List<Membre> findAll();
	 //Filtrage par propriété
	 public Membre findByCin(String cin);
	 public Membre findByEmail(String email);
	 public List<Membre> findByNom(String nom);
	 //recherche spécifique des étudiants
	 public List<Etudiant> findByDiplome(String diplome);
	 //recherche spécifique des enseignants
	 public List<EnseignantChercheur> findByGrade(String grade);
	 public List<EnseignantChercheur> findByEtablissement(String etablissement);
	 public void affecter_Etudiant_Enseignant(long idEtd,long idEns);
	 public List<Etudiant> findEtudiantByEnseignant(EnseignantChercheur ens);
	 public void affecterauteurTopublication(Long idauteur, Long idpub);
	 public List<PublicationBean> findPublicationparauteur (Long idauteur);
	// liaison membre - evenement
	 public void affecterMembreToEvenement(Long idMembre, Long idEvent);
	 public List<EvenementBean> findEvenementsByMembre(Long idMembre);
	 void affecterMembreToOutil(Long idMembre, Long idOutil);
	 List<OutilBean> findOutilsByMembre(Long idMembre);


	 }

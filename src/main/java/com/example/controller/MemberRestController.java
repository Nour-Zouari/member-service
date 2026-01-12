package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.EnseignantChercheur;
import com.example.entities.Etudiant;
import com.example.entities.Membre;
import com.example.service.IMemberService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemberRestController {
	IMemberService memberService;
	@RequestMapping(value="/membres", method=RequestMethod.GET)
	public List<Membre> findMembres (){
	return memberService.findAll();
	}
	@GetMapping(value="/membres/{id}")
	public Membre findOneMemberById(@PathVariable("id") Long id){
	return memberService.findMember(id);}
	@GetMapping(value="/membres/search/cin")
	public Membre findOneMemberByCin(@RequestParam("cin") String cin)
	{
	return memberService.findByCin(cin);
	}
	@GetMapping(value="/membres/search/email")
	public Membre findOneMemberByEmail(@RequestParam("email") String 
	email)
	{
	return memberService.findByEmail(email);
	}
	@PostMapping(value="/membres/enseignant")
	public Membre addMembre(@RequestBody EnseignantChercheur m)
	{
	return memberService.addMember(m);
	}
	@PostMapping(value="/membres/etudiant")
	public Membre addMembre(@RequestBody Etudiant e)
	{
	return memberService.addMember(e);
	}
	
	@DeleteMapping(value="/membres/{id}")
	public void deleteMembre(@PathVariable("id") Long id)
	{
	memberService.deleteMember(id);
	}
	@PutMapping(value="/membres/etudiant/{id}")
	public Membre updatemembre(@PathVariable("id") Long id, 
	@RequestBody Etudiant p)
	{
	p.setId(id);
	return memberService.updateMember(p);
	}
	@PutMapping(value="/membres/enseignant/{id}")
	public Membre updateMembre(@PathVariable("id") Long id, 
	@RequestBody EnseignantChercheur p)
	{
	p.setId(id);
	return memberService.updateMember(p);
	}
	 @GetMapping("/fullmember/{id}")
	 public Membre findAFullMember(@PathVariable(name="id") Long id)
	 {
	 Membre mbr=memberService.findMember(id);
	 mbr.setPubs(memberService.findPublicationparauteur(id));
	 return mbr;
	 }
	 @GetMapping("/fullmember/events/{id}")
	 public Membre memberWithEvents(@PathVariable Long id) {
	     Membre m = memberService.findMember(id);
	     m.setEvenements(memberService.findEvenementsByMembre(id));
	     return m;
	 }
	 @PostMapping("/membres/{idMembre}/outils/{idOutil}")
	 public void affecterMembreToOutil(
	         @PathVariable Long idMembre,
	         @PathVariable Long idOutil) {
	     memberService.affecterMembreToOutil(idMembre, idOutil);
	 }

	 @GetMapping("/fullmember/outils/{id}")
	 public Membre memberWithOutils(@PathVariable Long id) {
	     Membre m = memberService.findMember(id);
	     m.setOutils(memberService.findOutilsByMembre(id));
	     return m;
	 }




}

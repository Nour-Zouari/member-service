package com.example.beans;

import java.util.Date;

import lombok.Data;
import lombok.NonNull;

@Data
public class PublicationBean {
	private Long id;
	private String titre;
	private String type;
	private Date dateApparition;
	private String lien;
	private String sourcePdf;

}

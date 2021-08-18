package eai.bam.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import eai.bam.commons.Constantes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Constantes.COMPTE_TABLE)
@Data
@AllArgsConstructor @NoArgsConstructor
public class Compte implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "TYPE_ENR")
	private String type_Enr;
	
	@Id
	private Integer Id_Compte;
	
	@Column(name = "CODE_DECLARANT")
	private String Code_declarant;

	@Column(name = "CODE_LOCALITE_AGENCE")
	private String Code_Localite_Agence;

	@Column(name = "CODE_GUICHET_AGENCE")
	private String Code_Guichet_Agence;
	
	@Column(name = "RIB")
	private String rib;
	
	@Column(name = "TYPE_COMPTE")
	private String type_Compte;
	
	@Column(name = "DEVISE_COMPTE")
	private String devise_Compte;
	
	@Column(name = "INTITULE_COMPTE")
	private String intitule_Compte;
	
	@Column(name = "DATE_OUVERTURE")
	private Date date_Ouerture;
	
	@Column(name = "STATUT_COMPTE")
	private String statut_Compte;
	
	@Column(name = "DATE_STATUT")
	private Date date_Statut;
	
	@Column(name = "DATE_IMPORT")
	private Date dateImport;
	
	//LAZY
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(
	  name = Constantes.CLIENT_COMPTE_TABLE, 
	  joinColumns = @JoinColumn(name = "ID_COMPTE"), 
	  inverseJoinColumns = @JoinColumn(name = "ID_CLIENT"))
	private List<Client> clients = new ArrayList<Client>();

}

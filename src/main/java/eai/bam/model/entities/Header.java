package eai.bam.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import eai.bam.commons.Constantes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Constantes.HEADER_TABLE)
@Data
@AllArgsConstructor @NoArgsConstructor
public class Header implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int ID_Header;
	
	@Column(name = "H01")
	private int h01;
	
	@Column(name = "H02")
	private String h02;
	
	@Column(name = "H03")
	private Date h03;
	
	@Column(name = "H04")
	private Date h04;
	
	@Column(name = "H05")
	private int h05;
	
	@Column(name = "H06")
	private String h06;
	
	@Column(name = "H07")
	private int h07;
	
	@Column(name = "H08")
	private int h08;
	
	@Column(name = "H09")
	private int h09;
	
	@Column(name = "DATE_IMPORT")
	private Date dateImport;
	
}

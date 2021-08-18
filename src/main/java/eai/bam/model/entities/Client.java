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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import eai.bam.commons.Constantes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Constantes.CLIENT_TABLE)
@Data
@AllArgsConstructor @NoArgsConstructor
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "TYPE_ENR")
	private String type_Enr;

	@Id
	private Integer Id_Client;

	@Column(name = "CODE_DECLARANT")
	private String Code_declarant;

	@Column(name = "CODE_CLIENT")
	private String Code_client;

	@Column(name = "NATURE_CLIENT")
	private Integer Nature_client;

	@Column(name = "TYPE_DECLARATION")
	private String Type_declaration;

	@Column(name = "TYPE_TITULAIRE")
	private String type_titulaire;

	@Column(name = "M06")
	private String m06;

	@Column(name = "M07")
	private String m07;

	@Column(name = "M08")
	private String m08;

	@Column(name = "M09")
	private Integer m09;

	@Column(name = "M10")
	private String m10;

	@Column(name = "M11")
	private String m11;

	@Column(name = "M12")
	private String m12;

	@Column(name = "M13")
	private Date m13;

	@Column(name = "M14")
	private Date m14;

	@Column(name = "M15")
	private Integer m15;

	@Column(name = "M16")
	private String m16;

	@Column(name = "M17")
	private String m17;

	@Column(name = "M18")
	private Integer m18;

	@Column(name = "M19")
	private String m19;

	@Column(name = "M20")
	private Integer m20;

	@Column(name = "M21")
	private String m21;

	@Column(name = "M22")
	private String m22;

	@Column(name = "M23")
	private String m23;

	@Column(name = "M24")
	private String m24;

	@Column(name = "M25")
	private String m25;

	@Column(name = "M26")
	private String m26;

	@Column(name = "M27")
	private String m27;

	@Column(name = "M28")
	private String m28;

	@Column(name = "M29")
	private String m29;

	@Column(name = "M30")
	private String m30;

	@Column(name = "M31")
	private String m31;

	@Column(name = "M32")
	private String m32;

	@Column(name = "M33")
	private String m33;

	@Column(name = "M34")
	private Integer m34;

	@Column(name = "M35")
	private String m35;

	@Column(name = "M36")
	private String m36;

	@Column(name = "M37")
	private String m37;

	@Column(name = "P06")
	private Integer p06;

	@Column(name = "P07")
	private String p07;

	@Column(name = "P08")
	private String p08;

	@Column(name = "P09")
	private Date p09;

	@Column(name = "P10")
	private Date p10;

	@Column(name = "P11")
	private String p11;

	@Column(name = "P12")
	private String p12;

	@Column(name = "P13")
	private String p13;

	@Column(name = "P14")
	private String p14;

	@Column(name = "P15")
	private String p15;

	@Column(name = "P16")
	private Date p16;

	@Column(name = "P17")
	private String p17;

	@Column(name = "P18")
	private String p18;
	
	@Column(name = "P19")
	private String p19;
	
	@Column(name = "P20")
	private String p20;
	
	@Column(name = "P21")
	private String p21;
	
	@Column(name = "P22")
	private String p22;
	
	@Column(name = "P23")
	private String p23;
	
	@Column(name = "P24")
	private String p24;
	
	@Column(name = "P25")
	private String p25;
	
	@Column(name = "P26")
	private Date p26;
	
	@Column(name = "P27")
	private String p27;
	
	@Column(name = "P28")
	private String p28;
	
	@Column(name = "P29")
	private String p29;
	
	@Column(name = "P30")
	private String p30;
	
	@Column(name = "P31")
	private String p31;
	
	@Column(name = "P32")
	private String p32;
	
	@Column(name = "P33")
	private String p33;
	
	@Column(name = "P34")
	private String p34;
	
	@Column(name = "P35")
	private String p35;
	
	@Column(name = "P36")
	private String p36;
	
	@Column(name = "P37")
	private String p37;
	
	@Column(name = "P38")
	private String p38;
	
	@Column(name = "P39")
	private String p39;
	
	@Column(name = "P40")
	private String p40;
	
	@Column(name = "DATE_IMPORT")
	private Date dateImport;
	
	@Transient
	@JsonIgnore
	@ManyToMany(mappedBy = "clients", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Compte> comptes = new ArrayList<Compte>();
	
}

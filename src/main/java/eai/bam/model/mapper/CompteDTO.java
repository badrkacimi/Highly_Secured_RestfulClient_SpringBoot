package eai.bam.model.mapper;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteDTO implements Serializable{

private static final long serialVersionUID = 1L;
	
	private String Z01;
	
	private Integer C01;
	
	private String C02;

	private String C03;

	private String C04;
	
	private String C05;
	
	private String C06;
	
	private String C07;
	
	private String C08;
	
	private String C09;
	
	private String C10;
	
	private String C11;
	
	private List<ClientAbstarct> clis;
}

package eai.bam.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import eai.bam.model.mapper.CompteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BamFluxDTO implements Serializable {

	private int h01;
	private String h02;
	private String h03;
	private String h04;
	private int h05;
	private String h06;
	private long h07;
	private long h08;
	private long h09;
	private List<CompteDTO> cpts;

	@Override
	public String toString() {
		return "BamFluxDTO [h01=" + h01 + ", h02=" + h02 + ", h03=" + h03
				+ ", h04=" + h04 + ", h05=" + h05 + ", h06=" + h06 + ", h07="
				+ h07 + ", h08=" + h08 + ", h09=" + h09 + ", comptes="
				+ cpts + ", getH01()=" + getH01() + ", getH02()=" + getH02()
				+ ", getH03()=" + getH03() + ", getH04()=" + getH04()
				+ ", getH05()=" + getH05() + ", getH06()=" + getH06()
				+ ", getH07()=" + getH07() + ", getH08()=" + getH08()
				+ ", getH09()=" + getH09() + ", getCpts()=" + getCpts() + "]";
	}
}
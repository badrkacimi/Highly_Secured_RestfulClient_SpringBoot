package eai.bam.service;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import eai.bam.model.entities.Client;
import eai.bam.model.mapper.ClientMoraleDTO;
import eai.bam.model.mapper.ClientPhysiqueDTO;


@Service
public class ClientMapper {
	
	Logger logger  = LoggerFactory.getLogger(ClientMapper.class);
	String pattern = "yyyyMMdd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	
	public ClientPhysiqueDTO mapperP(Client client, int id_compte) {
		if(client.getType_Enr().equals("P")) {
			
			logger.info("********************** mapper client physique***********************");
			ClientPhysiqueDTO clientPhysiqueDTO = new ClientPhysiqueDTO();
			
			clientPhysiqueDTO.setP03(client.getCode_client() != null ? client.getCode_client() : "");
			clientPhysiqueDTO.setP02(client.getCode_declarant() != null ? client.getCode_declarant() : "");
			clientPhysiqueDTO.setZ01(client.getType_Enr() != null ? client.getType_Enr() : "");
			clientPhysiqueDTO.setP04(client.getNature_client() != null ? client.getNature_client() : 0);
			clientPhysiqueDTO.setP05(client.getType_declaration() != null ? client.getType_declaration() : "");
			clientPhysiqueDTO.setP06(client.getP06() != null ? client.getP06() : 0);
			clientPhysiqueDTO.setP07(client.getP07() != null ? client.getP07() : "");
			clientPhysiqueDTO.setP08(client.getP08() != null ? client.getP08() : "");
			clientPhysiqueDTO.setP09(client.getP09() != null ? simpleDateFormat.format(client.getP09()) : "");
			clientPhysiqueDTO.setP10(client.getP10() != null ? simpleDateFormat.format(client.getP10()) : "");
			clientPhysiqueDTO.setP11(client.getP11() != null ? client.getP11() : "");
			clientPhysiqueDTO.setP12(client.getP12() != null ? client.getP12() : "");
			clientPhysiqueDTO.setP13(client.getP13() != null ? client.getP13() : "");
			clientPhysiqueDTO.setP14(client.getP14() != null ? client.getP14() : "");
			clientPhysiqueDTO.setP15(client.getP15() != null ? client.getP15() : "");
			clientPhysiqueDTO.setP16(client.getP16() != null ? simpleDateFormat.format(client.getP16()) : "");
			clientPhysiqueDTO.setP17(client.getP17() != null ? client.getP17() : "");
			clientPhysiqueDTO.setP18(client.getP18() != null ? client.getP18() : "");
			clientPhysiqueDTO.setP19(client.getP19() != null ? client.getP19() : "");
			clientPhysiqueDTO.setP20(client.getP20() != null ? client.getP20() : "");
			clientPhysiqueDTO.setP21(client.getP21() != null ? client.getP21() : "");
			clientPhysiqueDTO.setP22(client.getP22() != null ? client.getP22() : "");
			clientPhysiqueDTO.setP23(client.getP23() != null ? client.getP23() : "");
			clientPhysiqueDTO.setP24(client.getP24() != null ? client.getP24() : "");//simpleDateFormat.format()
			clientPhysiqueDTO.setP25(client.getP25() != null ? client.getP25() : "");
			clientPhysiqueDTO.setP26(client.getP26() != null ? simpleDateFormat.format(client.getP26()) : "");
			clientPhysiqueDTO.setP27(client.getP27() != null ? client.getP27() : "");
			clientPhysiqueDTO.setP28(client.getP28() != null ? client.getP28() : "");
			clientPhysiqueDTO.setP29(client.getP29() != null ? client.getP29() : "");
			clientPhysiqueDTO.setP30(client.getP30() != null ? client.getP30() : "");
			clientPhysiqueDTO.setP31(client.getP31() != null ? client.getP31() : "");
			clientPhysiqueDTO.setP32(client.getP32() != null ? client.getP32() : "");
			clientPhysiqueDTO.setP33(client.getP33() != null ? client.getP33() : "");
			clientPhysiqueDTO.setP34(client.getP34() != null ? client.getP34() : "");
			clientPhysiqueDTO.setP35(client.getP35() != null ? client.getP35() : "");
			clientPhysiqueDTO.setP36(client.getP36() != null ? client.getP36() : "");
			clientPhysiqueDTO.setP37(client.getP37() != null ? client.getP37() : "");
			clientPhysiqueDTO.setP38(client.getP38() != null ? client.getP38() : "");
			clientPhysiqueDTO.setP39(client.getP39() != null ? client.getP39() : "");
			clientPhysiqueDTO.setP40(client.getP40() != null ? client.getP40() : "");
			clientPhysiqueDTO.setP41(client.getId_Client() != null ? Integer.parseInt(Integer.toString(client.getId_Client()) + Integer.toString(id_compte)) : 0);
			clientPhysiqueDTO.setL05(client.getType_titulaire() != null ? client.getType_titulaire() : "");
			return clientPhysiqueDTO;
		}
		return null;
	
	}
	
	public ClientMoraleDTO mapperM(Client client, int id_compte) {
			if(client.getType_Enr().equals("M" )) {
				
				logger.info("********************** mapper client moral***********************");
				ClientMoraleDTO  clientMoraleDTO = new ClientMoraleDTO();
				
				clientMoraleDTO.setM03(client.getCode_client() != null ? client.getCode_client() : "");
				clientMoraleDTO.setM02(client.getCode_declarant() != null ? client.getCode_declarant() : "");
				clientMoraleDTO.setZ01(client.getType_Enr() != null ? client.getType_Enr() : "");
				clientMoraleDTO.setM04(client.getNature_client() != null ? client.getNature_client() : 0);
				clientMoraleDTO.setM05(client.getType_declaration() != null ? client.getType_declaration() : "");// != null ?  : ""
				clientMoraleDTO.setM06(client.getM06() != null ? client.getM06() : "");
				clientMoraleDTO.setM07(client.getM07() != null ? client.getM07() : "");
				clientMoraleDTO.setM08(client.getM08() != null ? client.getM08() : "");
				clientMoraleDTO.setM09(client.getM09() != null ? client.getM09() : 0);
				clientMoraleDTO.setM10(client.getM10() != null ? client.getM10() : "");
				clientMoraleDTO.setM11(client.getM11() != null ? client.getM11() : "");
				clientMoraleDTO.setM12(client.getM12() != null ? client.getM12() : "");
				clientMoraleDTO.setM13(client.getM13() != null ? simpleDateFormat.format(client.getM13()) : "");
				clientMoraleDTO.setM14(client.getM14() != null ? simpleDateFormat.format(client.getM14()) : "");
				clientMoraleDTO.setM15(client.getM15() != null ? client.getM15() : 0);
				clientMoraleDTO.setM16(client.getM16() != null ? client.getM16() : "");
				clientMoraleDTO.setM17(client.getM17() != null ? client.getM17() : "");
				clientMoraleDTO.setM18(client.getM18() != null ? client.getM18() : 0);
				clientMoraleDTO.setM19(client.getM19() != null ? client.getM19() : "");
				clientMoraleDTO.setM20(client.getM20() != null ? client.getM20() : 0);
				clientMoraleDTO.setM21(client.getM21() != null ? client.getM21() : "");
				clientMoraleDTO.setM22(client.getM22() != null ? client.getM22() : "");
				clientMoraleDTO.setM23(client.getM23() != null ? client.getM23() : "");
				clientMoraleDTO.setM24(client.getM24() != null ? client.getM24() : "");
				clientMoraleDTO.setM25(client.getM25() != null ? client.getM25() : "");
				clientMoraleDTO.setM26(client.getM26() != null ? client.getM26() : "");
				clientMoraleDTO.setM27(client.getM27() != null ? client.getM27() : "");
				clientMoraleDTO.setM28(client.getM28() != null ? client.getM28() : "");
				clientMoraleDTO.setM29(client.getM29() != null ? client.getM29() : "");
				clientMoraleDTO.setM30(client.getM30() != null ? client.getM30() : "");
				clientMoraleDTO.setM31(client.getM31() != null ? client.getM31() : "");
				clientMoraleDTO.setM32(client.getM32() != null ? client.getM32() : "");
				clientMoraleDTO.setM33(client.getM33() != null ? client.getM33() : "");
				clientMoraleDTO.setM34(client.getM34() != null ? client.getM34() : 0);
				clientMoraleDTO.setM35(client.getM35() != null ? client.getM35() : "");
				clientMoraleDTO.setM36(client.getM36() != null ? client.getM36() : "");
				clientMoraleDTO.setM37(client.getM37() != null ? client.getM37() : "");
				clientMoraleDTO.setM38(client.getId_Client() != null ? Integer.parseInt(Integer.toString(client.getId_Client()) + Integer.toString(id_compte)) : 0);
				clientMoraleDTO.setL05(client.getType_titulaire() != null ? client.getType_titulaire() : "");
				return clientMoraleDTO;
			}
			return null;
	}
}

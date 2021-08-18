package eai.bam.commons;

public class Constantes {

	public static final String SERVER = "https://rccb.bankalmaghrib.ma/rccb-api/api/sendCCBData";
	
	public static final String CTR = "https://rccb.bankalmaghrib.ma/rccb-api/api/receiveCCBCTR";
	
	public static final String PUBLIC_KEY = "./publique.bin"; //./src/main/resources/publique.bin
	
	public static final String JSON_FILE = "./JsonCCB.json";

	public static final String file_CTR_old = "./ctrCCB-1"; 
	
	public static final String file_CTR = "./ctrCCB";
	
	/*	Table clients	*/
	public static final String CLIENT_TABLE = "CLIENTSCCB4";
	
	/*	Table comptes	*/
	public static final String COMPTE_TABLE = "COMPTESCCB4";
	
	/*	Table relation client compte	*/
	public static final String CLIENT_COMPTE_TABLE = "CLIENTSCCB_COMPTESCCB4";
	
	/*	Table headers	*/
	public static final String HEADER_TABLE = "HEADERSCCB4";
	
}

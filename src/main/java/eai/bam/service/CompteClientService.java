package eai.bam.service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import eai.bam.commons.Constantes;
import eai.bam.model.entities.BamFluxDTO;
import eai.bam.model.entities.Client;
import eai.bam.model.entities.Compte;
import eai.bam.model.mapper.ClientAbstarct;
import eai.bam.model.mapper.CompteDTO;
import eai.bam.repositories.ClientRepository;
import eai.bam.repositories.CompteRepository;
import eai.bam.repositories.HeaderRepository;
import eai.bam.security.PublicKeyReader;

@Service
public class CompteClientService {
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private HeaderRepository headerRepository;
	
	private ClientMapper clientMapper = new ClientMapper();

	private BamFluxDTO bamFlux = new  BamFluxDTO();
	
	private static RestTemplate rest;
	
	Logger log  = LoggerFactory.getLogger(CompteClientService.class);
	
	String pattern = "yyyyMMdd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	
	public BamFluxDTO getBamFlux() {
		try {
	
			if(headerRepository.findAll().size() != 0) {
				
				log.info("Set header in Flux");
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
				
				bamFlux.setH01(headerRepository.findAll().get(0).getH01());
				bamFlux.setH02(headerRepository.findAll().get(0).getH02());
				bamFlux.setH03(dateFormat.format(headerRepository.findAll().get(0).getH03()));
				bamFlux.setH04(dateFormat.format(headerRepository.findAll().get(0).getH04()));
				bamFlux.setH05(headerRepository.findAll().get(0).getH05());
				bamFlux.setH06(headerRepository.findAll().get(0).getH06());
				bamFlux.setH07(compteRepository.count());
				bamFlux.setH08(clientRepository.count());
				//bamFlux.setH08(headerRepository.findAll().get(0).getH08());
				bamFlux.setH09(headerRepository.findAll().get(0).getH09());
			}	
			
			List<CompteDTO> comptes = new ArrayList<CompteDTO>();
			//clientRepository.findClientsCompte("C51");
			
			log.info("Mapper les objets");
			
			for(Compte c : compteRepository.findAll()) {
				List<ClientAbstarct> clients = new ArrayList<ClientAbstarct>();
				
				for(Client cl : c.getClients()) {
					if(cl.getType_Enr().equals("P")) {
						clients.add(clientMapper.mapperP(cl, c.getId_Compte()));
					}else {
						if(cl.getType_Enr().equals("M")) {
							clients.add(clientMapper.mapperM(cl, c.getId_Compte()));
						}
					}
				}
				comptes.add(new CompteDTO(c.getType_Enr(), c.getId_Compte(), c.getCode_declarant(), c.getCode_Localite_Agence(), c.getCode_Guichet_Agence(), c.getRib(), c.getType_Compte(), c.getDevise_Compte(), c.getIntitule_Compte(), (c.getDate_Ouerture() != null ? simpleDateFormat.format(c.getDate_Ouerture()) : ""), c.getStatut_Compte(), (c.getDate_Statut()  != null ? simpleDateFormat.format(c.getDate_Statut()) : ""), clients));
			}
			bamFlux.setCpts(comptes);
			
			return bamFlux;
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			return null;
		}
		
	}
	
		public String post(String data, BamFluxDTO fluxDTO, SecretKey skeySpec){
			
			rest = new RestTemplate();
			rest.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
			try {
				HttpEntity<String> requestEntity = new HttpEntity<String>(data, this.getHeader(fluxDTO, skeySpec));
				ResponseEntity<String> responseEntity = rest.exchange(Constantes.SERVER, HttpMethod.POST, requestEntity, String.class);
				log.info("*****************************Capture de la reponse body de post API******************************");
				log.info("*************************************************************************************************");
				log.info("*************************************************************************************************");
				log.info(responseEntity.getBody());
				log.info("*************************************************************************************************");
				log.info("*************************************************************************************************");
				log.info("*****************************Fin de capture de la reponse body de post API******************************");
				return responseEntity.getBody();
			} catch (Exception ex) {
				ByteArrayOutputStream os = new ByteArrayOutputStream();
	            ex.printStackTrace(new PrintStream(os));
	            log.error(new String(os.toByteArray()));
				return null;
			}
		}
		
		// teste avec les dates d'execution en format YYYY-MMDDThh:mm:ss + les dates de header H en format yyyyMMdd
		 public void downloadCTRFile(BamFluxDTO fluxDTO, int i, String file_name ){
			 	rest = new RestTemplate();
				rest.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
				
		       try {
		           HttpHeaders headers = new HttpHeaders();
		            headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
		           	headers.add("service", "XXX");
					headers.add("idLot", Integer.toString(Integer.parseInt(String.valueOf(fluxDTO.getH05()))- i));
					headers.add("emetteur", "011");
					headers.add("recepteur", "001");
					Date date = new Date();
					//DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
					headers.add("dateArrete", fluxDTO.getH03()
					System.err.println("++++++++++++++++++++ "+ fluxDTO.getH03());
					headers.add("login", "XXXXXX");
					headers.add("password_hash", "ikbkjewvbkJVFJfvkjFVvhjvjhsvh");
		           HttpEntity<String> entity = new HttpEntity<>(headers);
		           ResponseEntity<byte[]> response = rest.exchange(Constantes.CTR, HttpMethod.GET, entity, byte[].class);
		           Files.write(Paths.get(file_name), response.getBody());
		       }catch (Exception ex){
		    	   	ByteArrayOutputStream os = new ByteArrayOutputStream();
		            ex.printStackTrace(new PrintStream(os));
		            log.error(new String(os.toByteArray()));
		       }
		   }
		 
		
		public Cipher EncryptDataWithAES(SecretKey skeySpec) throws Exception{
			
			Cipher aes = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] ivParams = new byte[aes.getBlockSize()];
			IvParameterSpec iv = new IvParameterSpec(ivParams);
			aes.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			
			return aes;
		}
		
		private HttpHeaders getHeader(BamFluxDTO fluxDTO, SecretKey skeySpec) throws Exception {
			
			log.info("******************************** construire le header pour le flux XXXX *************************************************");
			HttpHeaders headers  = new HttpHeaders();
			
			headers.add("serviceXXX", "XXX");
			headers.add("idLot", String.valueOf(fluxDTO.getH05()));
			headers.add("emetteur", "XXX");
			headers.add("recepteur", "XXX");
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// fluxDTO.getH04()   -- Le champ « dateDeclaration » dans le header doit contenir la date d’XXXXX qui est dans h03 mais au format «yyyy-MM-dd HH:mm:ss»
			 Date date1=new SimpleDateFormat("yyyyMMdd").parse(fluxDTO.getH03());
			headers.add("dateDeclaration", dateFormat.format(date1));
			System.err.println(dateFormat.format(date1));
			// headers.add("dateDeclaration", dateFormat.format(fluxDTO.getH04()));
			headers.add("nbrEnregistrement",String.valueOf(fluxDTO.getH07()));
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("login", "XXXXXXX");
			headers.add("password_hash", "4874e58678f5fd512d1aGGGGGGG906a3db86f278ce778390bd36193c78f");
			headers.add("token", this.generateEncodedToken(skeySpec));
			System.out.println(headers.toString());
			
			return headers;
		}
		
		private String generateEncodedToken(SecretKey skeySpec) throws Exception {
			
					Cipher aes = Cipher.getInstance("AES/CBC/PKCS5Padding");
					byte[] ivParams = new byte[aes.getBlockSize()];
					IvParameterSpec iv = new IvParameterSpec(ivParams);
					aes.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

					log.info("******************************** Lecture du certificat (cle publique RSA) ***************************************************");
					
					PublicKey clePublique = PublicKeyReader.getpublicKey(Constantes.PUBLIC_KEY);
				
					Cipher cipher = Cipher.getInstance("RSA");
					cipher.init(Cipher.WRAP_MODE, clePublique);
					byte[] wrappedKey = cipher.wrap(skeySpec);

					// encodedToken : Mot de passe symétrique crypté avec le certificat
					// public (RSA) mis à la disposition de la XXXX par XXXX
					
					log.info("******************************** encodedToken : Mot de passe symétrique crypté avec le certificat public (RSA) mis à la disposition de la XXX par XXX ***************************************************");
					
					String encodedToken = Base64.encodeBase64String(wrappedKey);
					
					return encodedToken;
		}

}

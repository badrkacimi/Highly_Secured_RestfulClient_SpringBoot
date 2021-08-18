package eai.bam.main;

import java.io.File;
import java.security.SecureRandom;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;

import eai.bam.commons.Constantes;
import eai.bam.model.entities.BamFluxDTO;
import eai.bam.service.CompteClientService;


@SpringBootApplication
@EnableJpaRepositories("eai.bam.repositories")
@EntityScan("eai.bam.model.entities")
@ComponentScan("eai.bam.service")
public class RestClientMain implements CommandLineRunner {

	
	private BamFluxDTO bamFluxDTO;
	
	@Autowired
	private CompteClientService clientService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RestClientMain.class, args).close();
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		Logger logger  = LoggerFactory.getLogger(RestClientMain.class);
		
				logger.info("##############################################################################");
				logger.info("#####################             DEBUT BATCH               ##################");
				logger.info("########  Début du  traitement XXXX : " + new Date().toString() +" ###########");
				logger.info("##############################################################################");
		
				SecureRandom random = new SecureRandom();
				byte[] keyData = random.generateSeed(16);
				SecretKey skeySpec = new SecretKeySpec(keyData, "AES");
				logger.info("*************** Get Flux object *****************************");
				
				bamFluxDTO = clientService.getBamFlux();

				logger.info("***************Mapping to JSON*******************************");
				
				ObjectMapper mapper = new ObjectMapper();
				
				logger.info("***************Ecrire l'objet JSON dans le fichier de TEST*******************************");
				
				mapper.writerWithDefaultPrettyPrinter().writeValue( new File(Constantes.JSON_FILE), bamFluxDTO);
				
				// Send Crypted JSON to BAM-----------------------------------------------------
				
				logger.info("*************** HTTPS Body JSON Encoded *****************************");
				
				ObjectMapper Obj = new ObjectMapper();
				String jsonStr = Obj.writeValueAsString(bamFluxDTO);  
				
				System.err.println(jsonStr);
				
				byte[] cipherText = clientService.EncryptDataWithAES(skeySpec).doFinal(jsonStr.getBytes());
				
				String encodedData = Base64.encodeBase64String(cipherText);
				
				logger.info("***************Send JSON  *****************************");
				
				final int batchId = Integer.valueOf(arg0[0]);
				
				switch (batchId) {
				case 1 :
				{
					System.out.println("test 1");
					clientService.downloadFile(bamFluxDTO, 1,Constantes.file_CTR_old);
					break;
				}
				case 2 :
				{
					System.out.println("test 2");
					clientService.post(encodedData, bamFluxDTO, skeySpec);
					clientService.downloadFile(bamFluxDTO, 0, Constantes.file_CTR);
					break;
				}
				default:
				{	logger.info("ERREUR : ID_BATCH "+batchId+" NE CORRESPOND A AUCUN BATCH.");
					throw new IllegalStateException(
							String.format("ERREUR : ID_BATCH "+batchId+" NE CORRESPOND A AUCUN BATCH."));
				}
					
				}
				
				
				logger.info("##############################################################################");
				logger.info("#####################             FIN BATCH               ####################");
				logger.info("############  Fin Traitement XXXX : " + new Date().toString() +" #############");
				logger.info("##############################################################################");
				
				
	}

}

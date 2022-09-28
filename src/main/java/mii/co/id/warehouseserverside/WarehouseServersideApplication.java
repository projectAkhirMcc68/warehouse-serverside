package mii.co.id.warehouseserverside;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WarehouseServersideApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseServersideApplication.class, args);
                System.out.println("Serverside Is Runing!!!");
	}
        
         @Bean 
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }

}

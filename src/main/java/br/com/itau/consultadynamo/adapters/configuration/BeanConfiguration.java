package br.com.itau.consultadynamo.adapters.configuration;

import br.com.itau.consultadynamo.ConsultadynamoApplication;
import br.com.itau.consultadynamo.application.entities.ports.EstudantePort;
import br.com.itau.consultadynamo.application.entities.ports.services.EstudanteImpl;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackageClasses = ConsultadynamoApplication.class)
public class BeanConfiguration {

    @Bean
    EstudanteImpl estudanteImpl(@Lazy DynamoDBMapper mapper, @Lazy EstudantePort repository) {
        return new EstudanteImpl(mapper, repository);
    }
}

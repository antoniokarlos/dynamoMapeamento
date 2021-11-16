package br.com.itau.consultadynamo.application.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
@Data
@DynamoDBDocument
public class Estudante {

    private String idEstudante;
    private String nomeEstudante;
    private String emailEstudante;

}

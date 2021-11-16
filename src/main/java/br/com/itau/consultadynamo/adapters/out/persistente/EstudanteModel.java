package br.com.itau.consultadynamo.adapters.out.persistente;

import br.com.itau.consultadynamo.application.entities.Estudante;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "estudante")
public class EstudanteModel {

    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName = "id_estudante")
    private String idEstudante;
    @DynamoDBRangeKey
    @DynamoDBAttribute(attributeName = "id_codigo")
    private String idCodigo;
    @DynamoDBAttribute(attributeName = "estudante")
    private Estudante estudante;
}

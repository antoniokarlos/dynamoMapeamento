package br.com.itau.consultadynamo.application.entities.ports.services;

import br.com.itau.consultadynamo.adapters.out.persistente.EstudanteModel;
import br.com.itau.consultadynamo.application.entities.ports.EstudantePort;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import java.util.List;

public class EstudanteImpl implements EstudantePort {

    private final DynamoDBMapper mapper;
    private final EstudantePort port;

    public EstudanteImpl(final DynamoDBMapper mapper, final EstudantePort port) {
        this.mapper = mapper;
        this.port = port;
    }

    @Override
    public EstudanteModel findById(String idEstudante, String idCodigo) {
        return mapper.load(EstudanteModel.class, idEstudante, idCodigo);
    }

    @Override
    public List<EstudanteModel> listAll(String idEstudante) {
        EstudanteModel e = new EstudanteModel(idEstudante,null,null);
        DynamoDBQueryExpression<EstudanteModel> queryExpression = new DynamoDBQueryExpression<EstudanteModel>()
                .withHashKeyValues(e);
        return mapper.query(EstudanteModel.class, queryExpression);
    }
}

package br.com.itau.consultadynamo.application.entities.ports;

import br.com.itau.consultadynamo.adapters.out.persistente.EstudanteModel;

import java.util.List;

public interface EstudantePort {

    EstudanteModel findById(String idEstudante, String idCodigo);

    List<EstudanteModel> listAll(String idEstudante);
}

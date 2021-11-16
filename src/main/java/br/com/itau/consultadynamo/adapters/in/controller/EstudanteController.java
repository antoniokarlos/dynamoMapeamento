package br.com.itau.consultadynamo.adapters.in.controller;

import br.com.itau.consultadynamo.adapters.out.persistente.EstudanteModel;
import br.com.itau.consultadynamo.application.entities.ports.EstudantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstudanteController {
    @Autowired
    EstudantePort port;

    @GetMapping("/estudante/id")
    public Object listEstudante(@RequestParam String idEstudante, @RequestParam String idCodigo){
        EstudanteModel es;
        try {
            es = port.findById(idEstudante,idCodigo);
        }catch(Exception e){
            return null;
        }
        return es;
    }

    @GetMapping("/estudante/all")
    public List<EstudanteModel> listEstudantes(@RequestParam String idEstudante){
        List<EstudanteModel> es;
        try {
            es = port.listAll(idEstudante);
        }catch(Exception e){
            return null;
        }
        return es;
    }

}

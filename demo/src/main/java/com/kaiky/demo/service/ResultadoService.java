package com.kaiky.demo.service;

import com.kaiky.demo.model.Aluno;
import com.kaiky.demo.model.Nota;
import com.kaiky.demo.repository.AlunoRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public String resultadoStatus(Long alunoId){
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);

        if (alunoOptional.isPresent()){
            Aluno aluno = alunoOptional.get();
            double media = calcularMedia(aluno);

            if (media >= 7){
                return "Aprovado";
            } else {
                return "Reprovado!!!!";
            }
        }

        return "Aluno não encontrado";
    }
    public double calcularMedia(Aluno aluno){
        List<Nota> notas = aluno.getNotas();
        if (notas.isEmpty()){
            return 0;
        }
        double soma = notas.stream().mapToDouble(Nota::getNota).sum();
        return soma / notas.size();
    }
}

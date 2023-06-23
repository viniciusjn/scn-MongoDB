package com.example.sistemanotas.repository;

import com.example.sistemanotas.model.Aluno;
import com.example.sistemanotas.model.CursoCount;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;

public interface AlunoRepository extends MongoRepository<Aluno, Integer> {
    @Aggregation(pipeline = {
            "{$match: {idade: {$gte: 18}}}",
            "{$sort: {idade: 1}}"
    })
    List<Aluno> encontrarAlunosMaioresIdade();

    @Aggregation(pipeline = {
            "{$group: {_id: '$curso', totalAlunos: {$sum: 1}}}",
            "{$project: {_id: 0, curso: '$_id', totalAlunos: 1}}"
    })
    List<CursoCount> contarAlunosPorCurso();
}

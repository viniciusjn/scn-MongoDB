package com.example.sistemanotas.repository;

import com.example.sistemanotas.model.Aluno;
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
            "{$group: {_id: '$curso', count: {$sum: 1}}}"
    })
    Map<String, Integer> contarAlunosPorCurso();
}

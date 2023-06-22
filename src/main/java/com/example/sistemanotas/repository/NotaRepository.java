package com.example.sistemanotas.repository;

import com.example.sistemanotas.model.Aluno;
import com.example.sistemanotas.model.Nota;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NotaRepository extends MongoRepository<Nota, String> {

    @Query("{'idAluno.nome': {$regex : ?0, $options: 'i'}}")
    List<Nota> findByAlunoNomeRegex(String nomeRegex);

    @Aggregation(pipeline = {
            "{$group: { _id: '$idAluno._id', nome: { $first: '$idAluno.nome' }, media: { $avg: '$nota' } }}",
            "{$sort: { media: -1 }}",
            "{$limit: 1}"
    })
    Aluno encontrarAlunoComMaiorMedia();
}

package com.example.sistemanotas.repository;

import com.example.sistemanotas.model.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlunoRepository extends MongoRepository<Aluno, Integer> {
}

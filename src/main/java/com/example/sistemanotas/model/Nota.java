package com.example.sistemanotas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "notas")

public class Nota {

    @Id
    private Integer id;
    private Aluno idAluno;
    private String disciplina;
    private Double nota;
}

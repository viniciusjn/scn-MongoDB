package com.example.sistemanotas.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class CursoCount {

    private String curso;
    private int totalAlunos;

    public CursoCount(String curso, int totalAlunos) {
        this.curso = curso;
        this.totalAlunos = totalAlunos;
    }
}

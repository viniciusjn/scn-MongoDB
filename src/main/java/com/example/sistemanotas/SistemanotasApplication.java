package com.example.sistemanotas;

import com.example.sistemanotas.model.Aluno;
import com.example.sistemanotas.model.Nota;
import com.example.sistemanotas.repository.AlunoRepository;
import com.example.sistemanotas.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SistemanotasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SistemanotasApplication.class, args);
	}

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	NotaRepository notaRepository;

	@Override
	public void run(String... args) throws Exception {

		//##################################### INÍCIO DO SISTEMA #####################################//
		System.out.println(" ");
		System.out.println("<------ INÍCIO DO PAINEL DE CONTROLE DE NOTAS ------>");
		System.out.println(" ");

		// CADASTRO DE ALUNOS //
		Aluno a1 = new Aluno(1, "Gabriel Barbosa", 26, "Engenharia de Software");
		Aluno a2 = new Aluno(2, "Vinícius Pereira", 17, "Ciência da Computação" );
		Aluno a3 = new Aluno(3, "Gustavo Furtado", 20, "Sistemas de Informação");
		Aluno a4 = new Aluno(4, "Arthur Morgan", 16, "Engenharia Computacional");
		Aluno a5 = new Aluno(5, "Nathan Drake", 40, "Análise de Desenvolvimentos e Sistemas");
		alunoRepository.save(a1);
		alunoRepository.save(a2);
		alunoRepository.save(a3);
		alunoRepository.save(a4);
		alunoRepository.save(a5);


		// CADASTRO DE NOTAS //
		Nota na1_01 = new Nota(1, a1, "Algoritmo", 9.5);
		Nota na1_02 = new Nota(2, a1, "Estrutura de Dados", 6.0);
		notaRepository.save(na1_01);
		notaRepository.save(na1_02);

		Nota na2_01 = new Nota(4, a2, "Algoritmo", 9.5);
		Nota na2_02 = new Nota(5, a2, "Estrutura de Dados", 10.0);
		notaRepository.save(na2_01);
		notaRepository.save(na2_02);

		Nota na3_01 = new Nota(7, a3,"Algoritmo", 8.0);
		Nota na3_02 = new Nota(8, a3, "Estrutura de Dados", 6.0);
		notaRepository.save(na3_01);
		notaRepository.save(na3_02);

		Nota na4_01 = new Nota(10, a4, "Algoritmo", 2.0);
		Nota na4_02 = new Nota(11, a4, "Estrutura de Dados", 5.0);
		notaRepository.save(na4_01);
		notaRepository.save(na4_02);

		Nota na5_01 = new Nota(13, a5,"Algoritmo", 10.0);
		Nota na5_02 = new Nota(14, a5, "Estrutura de Dados", 5.0);
		notaRepository.save(na5_01);
		notaRepository.save(na5_02);


		// 4.1  BUSCAR TODAS AS NOTAS DE UM DETERMINADO ALUNO PELO SEU NOME //
		System.out.println("// 4.1  BUSCAR TODAS AS NOTAS DE UM DETERMINADO ALUNO PELO SEU NOME //");
		String nomeRegex = "Gustavo";
		List<Nota> notasEncontradas = notaRepository.findByAlunoNomeRegex(nomeRegex);
		System.out.println("");
		System.out.println("-> com base na busca pelo aluno " + nomeRegex + " encontramos suas notas:");
		if (notasEncontradas.size() == 0) {
			System.out.println("NÃO ECONTRAMOS NENHUM ALUNO COM BASE NA SUA PESQUISA!");
		} else {
			for (Nota notaEncontrada : notasEncontradas) {
				System.out.println(notaEncontrada.getNota());
			}
		}
		System.out.println(" ");
	}
}


		// 4.2 BUSCAR O ALUNO COM A MAIOR MÉDIA DE NOTAS //
//		List<Nota> resultado = notaRepository.findAlunoComMaiorMedia();
//
//		if (!resultado.isEmpty()) {
//			Nota alunoComMaiorMedia = resultado.get(0);
//			System.out.println("Aluno com Maior Média: " + alunoComMaiorMedia.getIdAluno().getNome());
//			System.out.println("Média: " + alunoComMaiorMedia);
//		} else {
//			System.out.println("Nenhum aluno encontrado com notas.");
//		}



		System.out.println(" ");
		System.out.println("CHECKPOINT");
	}
}

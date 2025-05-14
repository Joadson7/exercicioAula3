package controllers;


import java.util.Scanner;

import entities.Aluno;
import repositories.AlunoRepository;

public class AlunoController {

	private Scanner scanner = new Scanner(System.in);

	public void cadastrarAluno() {

		var aluno = new Aluno();
		var alunoRepository = new AlunoRepository();

		System.out.println("Informe o id do Aluno.....: ");
		aluno.setIdAluno(Integer.parseInt(scanner.nextLine()));

		System.out.println("Informe o nome do aluno........: ");
		aluno.setNome(scanner.nextLine());

		aluno.setMatricula(MatriculaAluno.gerarMatricula(alunoRepository));

		System.out.println("Informe o CPF do aluno......: ");
		aluno.setCpf(scanner.nextLine());

		alunoRepository.inserir(aluno);
	}
	
	public void atualizarAluno() {
		
		System.out.println("\nAtualizar Aluno\n");
		var aluno = new Aluno();
		
		System.out.println("Informe a matricula....: ");
		aluno.setMatricula(scanner.nextLine());
		System.out.println("Informe o Id do Aluno...: ");
		aluno.setIdAluno(Integer.parseInt(scanner.nextLine()));
		System.out.println("Informe o nome...: ");
		aluno.setNome(scanner.nextLine());
		System.out.println("Informe o CPF...: ");
		aluno.setCpf(scanner.nextLine());
		
		var alunoRepository = new AlunoRepository();
		alunoRepository.atulizar(aluno);
	}
	
	

	public void excluirAluno() {

		System.out.print("Informe a matrícula do aluno....: ");
		String matricula = scanner.nextLine().trim(); 

		var alunoRepository = new AlunoRepository();
		alunoRepository.excluir(matricula); 

	}
}
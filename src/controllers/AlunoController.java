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

	public void excluirAluno() {

		System.out.print("Informe a matrícula do aluno....: ");
		String matricula = scanner.nextLine().trim(); // remove espaços extras

		var alunoRepository = new AlunoRepository();
		alunoRepository.excluir(matricula); // OK, aceita String

	}
}
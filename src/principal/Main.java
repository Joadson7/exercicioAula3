package principal;

import java.util.Scanner;

import controllers.AlunoController;

public class Main {

	public static void main(String[] args) {

		var alunoController = new AlunoController();

		System.out.println("\nSISTEMA DE CADASTRO DE ALUNO\n");

		System.out.println("(1) CADASTRAR ALUNO");
		System.out.println("(2) EXCLUIR ALUNO");

		var scanner = new Scanner(System.in);

		System.out.println("\nInforme a opção desejada....: ");
		var opcao = scanner.nextLine();

		switch (opcao) {

		
		case "1":
			alunoController.cadastrarAluno();
			break;

		case "2":
			alunoController.excluirAluno();
			;
			break;

		}

	}
}

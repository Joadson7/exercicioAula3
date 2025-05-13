package controllers;

import java.time.Year;
import repositories.AlunoRepository;

public class MatriculaAluno {

    public static String gerarMatricula(AlunoRepository alunoRepository) {
        String ano = String.valueOf(Year.now().getValue());

        // Buscar a última matrícula do banco
        String ultimaMatricula = alunoRepository.buscarUltimaMatriculaPorAno(ano);

        System.out.println(">> Última matrícula retornada do banco: " + ultimaMatricula);

        int proximoNumero = 1;

        if (ultimaMatricula != null && ultimaMatricula.length() == 8) {
            String numeroStr = ultimaMatricula.substring(4);
            proximoNumero = Integer.parseInt(numeroStr) + 1;
        }

        String novaMatricula = ano + String.format("%04d", proximoNumero);
        System.out.println(">> Nova matrícula gerada: " + novaMatricula);
        return novaMatricula;
    }
}

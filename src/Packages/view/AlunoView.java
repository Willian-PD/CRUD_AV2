package Packages.view;

import java.util.Scanner;
import Packages.bo.Aluno;
import Packages.controller.AlunoController;

public class AlunoView {

    public static String valor;

    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);

        Aluno aluno = new Aluno();
        AlunoController controller = new AlunoController();
		
		for(;;) {
            System.out.println("___________________");
            System.out.println("| 1 Incluir Aluno |");
            System.out.println("| 2 Excluir Aluno |");
            System.out.println("| 3 Alterar Aluno |");
            System.out.println("| 4 Buscar Aluno  |");
            System.out.println("___________________");
            System.out.print("Opção:");
            valor = dado.next();

                switch (valor) {
			    case "1":
			        System.out.println("Inserindo aluno:");
			        System.out.println("Entre com o matricula do aluno:");
			    	aluno.setMatricula(dado.next());
			    	System.out.println("Entre com o nome do aluno:");
			    	aluno.setNome(dado.next());
			    	System.out.println("Entre com o disciplina do aluno:");
			    	aluno.setdisciplina(dado.next());

			    	controller.create(aluno);
			        break;
			    case "2":
			        System.out.println("Excluindo aluno:");
			        System.out.println("Entre com o matricula do aluno:");
			    	aluno.setMatricula(dado.next());

			    	controller.delete(aluno);
			        break;
			    case "3":
			        System.out.println("Alterando aluno:");
			        System.out.println("Entre com o matricula do aluno:");
			    	aluno.setMatricula(dado.next());
			    	System.out.println("Entre com o nome do aluno:");
			    	aluno.setNome(dado.next());
			    	System.out.println("Entre com o disciplina do aluno:");
			    	aluno.setdisciplina(dado.next());
			    		
			    	controller.update(aluno);
			        break;
			    case "4":
			        System.out.println("Alterando aluno:");
			        System.out.println("Entre com o matricula do aluno:");
                    aluno.setMatricula(dado.next());
                    
			    	controller.read(aluno);
				    break;
			    default:
			        System.out.println("Opção invalida");
            }  
        }
	}
}

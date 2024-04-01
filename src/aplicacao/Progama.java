package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.ContratoHora;
import entidade.Departamento;
import entidade.Trabalhador;
import entidade.enums.NivelTrabalhador;

public class Progama {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner edd = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("NOME DO DEPARTAMENTO: ");
		String nomeDepartamento = edd.nextLine();
		
		System.out.println("FUNCIONARIO");
		System.out.println("NOME:");
		String nome = edd.nextLine();
		System.out.println("NIVEL DO CARGO:");
		String cargo = edd.nextLine();
		System.out.println("SALARIO BASE:");
		double salarioBase = edd.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(cargo), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.print("QUANTIDADE DE CONTRATOS:");
		int n = edd.nextInt();
		
		for (int i = 1;i<=n;i++) {
			System.out.println("CONTRATO #"+i);
			System.out.println("DATA (DD/MM/AAAA)");
			Date dataContratual = sdf.parse(edd.next());
			System.out.print("VALOR POR HORA:R$");
			double valorPorHora = edd.nextDouble();
			System.out.println("HORA:");
			int hora = edd.nextInt();
			ContratoHora contrato = new ContratoHora(dataContratual, valorPorHora, hora);
		}
		edd.close();
	}

}

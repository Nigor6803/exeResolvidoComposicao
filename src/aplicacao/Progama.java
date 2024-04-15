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
		System.out.print("NOME:");
		String nome = edd.nextLine();
		System.out.print("NIVEL DO CARGO:");
		String cargo = edd.nextLine();
		System.out.print("SALARIO BASE:");
		double salarioBase = edd.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(cargo), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.print("QUANTIDADE DE CONTRATOS:");
		int n = edd.nextInt();
		
		for (int i = 1;i<=n;i++) {
			System.out.println("CONTRATO #"+i);
			System.out.print("DATA (DD/MM/AAAA)");
			Date dataContratual = sdf.parse(edd.next());
			System.out.print("VALOR POR HORA:R$");
			double valorPorHora = edd.nextDouble();
			System.out.print("HORA:");
			int hora = edd.nextInt();
			ContratoHora contrato = new ContratoHora(dataContratual, valorPorHora, hora);
			trabalhador.addContrato(contrato);
		}
		
		System.out.println();
		System.out.println("MÊS E ANO PARA CALCULAR SALARIO: (MM/YYYY)");
		String mesEAno = edd.next();
		int mes = Integer.parseInt(mesEAno.substring(0,2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		
		System.out.println("NOME:"+ trabalhador.getNome());
		System.out.println("DEPARTAMENTO:"+ trabalhador.getDepartamento().getNome());
		System.out.println("SALARIO FINAL DO "+mesEAno+":"+String.format("%.2f",trabalhador.renda(ano, mes)));

		edd.close();
	}

}

package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Calculadora de IMC ===");
        System.out.print("Digite o peso em kg: ");
        double peso = sc.nextDouble();

        System.out.print("Digite a altura em metros com virgula: ");
        double altura = sc.nextDouble();

        try {
            double imc = CalculadoraIMC.calcularIMC(peso, altura);
            String classificacao = CalculadoraIMC.classificarIMC(imc);
            System.out.printf("IMC = %.2f → %s%n", imc, classificacao);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }
}


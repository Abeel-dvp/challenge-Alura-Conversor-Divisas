package org.example;

import org.example.ApiConversor.ApiCambio;
import org.example.ApiConversor.CambioDeMoneda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CambioDeMoneda cambioDeMoneda = ApiCambio.consultarTipoDeCambio();

        Scanner scanner = new Scanner(System.in);
        int opcion;
        double montoIngresado;
        double montoConvertido;
        String[] codigosMonedas = new String[2];

        while (true){
            System.out.println("""
                    
                    ************************************************
                    Sea bienvenido/a al Conversor de monedas 
                    ************************************************
                    
                    SELECCIONE EL TIPO DE CONVERSION:
                    1. Dólar           ===> Peso argentino
                    2. Peso argentino  ===> Dólar
                    3. Dólar           ===> Real brasileño
                    4. Real Brasileño  ===> Dólar
                    5. Dólar           ===> Peso colombiano
                    6. Peso colombiano ===> Dólar
                    7. Salir 
                    ************************************************
                    
                    """);

            try {
                System.out.println("Ingrese el numero de su opción aquí : ");
                opcion = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e ){
                System.out.println("Ingrese una opción valida ");
                continue;
            }

            if (opcion <1 || opcion >= 7 ){
                System.out.println("\n Gracias por utilizar nuestro sistema, regrese pronto \n");
                break;
            }


            try {
                System.out.println("Ingrese el monto que desea convertir: ");
                montoIngresado = Double.parseDouble(scanner.next());
            } catch (NumberFormatException e){
                System.out.println("Debe ingresar un monto válido");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    codigosMonedas = new String[]{"USD", "ARS"};
                }
                case 2 -> {
                    codigosMonedas = new String[]{"ARS", "USD"};
                }
                case 3 -> {
                    codigosMonedas = new String[]{"USD", "BRL"};
                }
                case 4 -> {
                    codigosMonedas = new String[]{"BRL", "USD"};
                }
                case 5 -> {
                    codigosMonedas = new String[]{"USD", "COP"};
                }
                case 6 -> {
                    codigosMonedas = new String[]{"COP", "USD"};
                }
            }

            try {
                montoConvertido = cambioDeMoneda.realizarCambio(montoIngresado, codigosMonedas[0], codigosMonedas[1]);

            } catch (Exception e ) {
                System.out.println("Valide los codigos de las monedas\n" + e.getMessage());
                continue;
            }

            System.out.println("El valor " + montoIngresado + " [" + codigosMonedas[0]+ "] " +
                    "el valor final del tipo de cambio seleccionado es de:  " + montoConvertido + " [" + codigosMonedas[1] + "]\n");
        }
        System.out.println("************************************");
        System.out.println("Finalizando Programa");
        System.out.println("************************************");

    }
}
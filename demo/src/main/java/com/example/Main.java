package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("--- MENÚ PRINCIPAL ---");
            System.out.println("1. Control de precios en una tienda");
            System.out.println("2. Registro de horas de trabajadores");
            System.out.println("3. Análisis de notas escolares");
            System.out.println("4. Simulación de retiro en cajero automático");
            System.out.println("5. Revisión de ventas diarias");
            System.out.println("6. Priorización de pacientes");
            System.out.println("7. Evaluación de productos");
            System.out.println("8. Horarios de transporte público");
            System.out.println("9. Clasificación de compras");
            System.out.println("10. Monitoreo de temperatura ambiental");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> ControlPrecios.ejecutar();
                case 2 -> RegistroHoras.ejecutar();
                case 3 -> AnalisisNotas.ejecutar();
                case 4 -> CajeroAutomatico.ejecutar();
                case 5 -> RevisionVentas.ejecutar();
                case 6 -> CentroSalud.ejecutar();
                case 7 -> EvaluacionProductos.ejecutar();
                case 8 -> TransportePublico.ejecutar();
                case 9 -> ClasificacionCompras.ejecutar();
                case 10 -> MonitoreoTemperatura.ejecutar();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);

        sc.close();
    }
}

class ControlPrecios {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        String[] nombres = new String[5];
        double[] precios = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el nombre del producto " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
            System.out.print("Ingrese el precio de " + nombres[i] + ": ");
            precios[i] = sc.nextDouble();
            sc.nextLine();
        }

        System.out.println("Productos con precio mayor a 50.000 COP:");
        for (int i = 0; i < 5; i++) {
            if (precios[i] > 50000) {
                System.out.println(nombres[i] + ": " + precios[i]);
            }
        }
    }
}

class RegistroHoras {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        double[][] horas = new double[3][5];

        for (int i = 0; i < 3; i++) {
            double total = 0;
            System.out.println("Ingrese las horas del trabajador " + (i + 1) + ":");
            for (int j = 0; j < 5; j++) {
                System.out.print("Día " + (j + 1) + ": ");
                horas[i][j] = sc.nextDouble();
                total += horas[i][j];
            }
            System.out.println("Total de horas del trabajador " + (i + 1) + ": " + total);
        }
    }
}

class AnalisisNotas {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> notas = new ArrayList<>();
        double suma = 0;
        int aprobados = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese la nota del estudiante " + (i + 1) + ": ");
            double nota = sc.nextDouble();
            notas.add(nota);
            suma += nota;
            if (nota >= 3.5) {
                aprobados++;
            }
        }
        System.out.println("Promedio: " + (suma / notas.size()));
        System.out.println("Estudiantes aprobados: " + aprobados);
    }
}

class CajeroAutomatico {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        int[] billetes = {100000, 50000, 20000, 10000};

        System.out.print("Ingrese el monto a retirar: ");
        int monto = sc.nextInt();

        for (int billete : billetes) {
            int cantidad = monto / billete;
            if (cantidad > 0) {
                System.out.println("Billetes de " + billete + ": " + cantidad);
                monto %= billete;
            }
        }
    }
}

class RevisionVentas {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        double[] ventas = new double[7];

        for (int i = 0; i < 7; i++) {
            System.out.print("Ingrese las ventas del día " + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();
        }

        int diaMayor = 0, diaMenor = 0;
        for (int i = 1; i < 7; i++) {
            if (ventas[i] > ventas[diaMayor]) diaMayor = i;
            if (ventas[i] < ventas[diaMenor]) diaMenor = i;
        }

        System.out.println("Día con mayor venta: Día " + (diaMayor + 1));
        System.out.println("Día con menor venta: Día " + (diaMenor + 1));
    }
}

class CentroSalud {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Integer> prioridades = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese nombre del paciente " + (i + 1) + ": ");
            nombres.add(sc.nextLine());
            System.out.print("Ingrese prioridad (1=alta, 2=media, 3=baja): ");
            prioridades.add(sc.nextInt());
            sc.nextLine();
        }

        System.out.println("Pacientes ordenados por prioridad:");
        for (int p = 1; p <= 3; p++) {
            for (int i = 0; i < prioridades.size(); i++) {
                if (prioridades.get(i) == p) {
                    System.out.println(nombres.get(i) + " - Prioridad: " + p);
                }
            }
        }
    }
}

class EvaluacionProductos {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        int[] estado = new int[50];
        int buenos = 0, defectuosos = 0;

        for (int i = 0; i < 50; i++) {
            System.out.print("Producto " + (i + 1) + " (1=bueno, 0=defectuoso): ");
            estado[i] = sc.nextInt();
            if (estado[i] == 1) buenos++;
            else defectuosos++;
        }

        double porcentajeDefectuosos = (defectuosos / 50.0) * 100;
        System.out.println("Productos buenos: " + buenos);
        System.out.println("Productos defectuosos: " + defectuosos);
        System.out.println("Porcentaje de defectuosos: " + porcentajeDefectuosos + "%");
    }
}

class TransportePublico {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        double[] horarios = {7.00, 9.30, 12.00, 14.30, 17.00, 19.30};

        System.out.print("Ingrese la hora actual (formato 24h, ej. 13.50): ");
        double hora = sc.nextDouble();

        boolean encontrado = false;
        for (double horario : horarios) {
            if (horario > hora) {
                System.out.println("Próximo bus disponible: " + horario);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No hay más buses disponibles hoy.");
        }
    }
}

class ClasificacionCompras {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> compras = new ArrayList<>();
        int pequeno = 0, mediano = 0, grande = 0;

        for (int i = 0; i < 8; i++) {
            System.out.print("Ingrese el monto de la compra del cliente " + (i + 1) + ": ");
            double monto = sc.nextDouble();
            compras.add(monto);
            if (monto < 50000) pequeno++;
            else if (monto <= 100000) mediano++;
            else grande++;
        }

        System.out.println("Compras pequeñas: " + pequeno);
        System.out.println("Compras medianas: " + mediano);
        System.out.println("Compras grandes: " + grande);
    }
}

class MonitoreoTemperatura {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        double[] temperaturas = new double[12];
        int altas = 0, bajas = 0;

        for (int i = 0; i < 12; i++) {
            System.out.print("Ingrese temperatura hora " + (i + 1) + ": ");
            temperaturas[i] = sc.nextDouble();
            if (temperaturas[i] > 35) altas++;
            if (temperaturas[i] < 20) bajas++;
        }

        System.out.println("Temperaturas > 35°C: " + altas);
        System.out.println("Temperaturas < 20°C: " + bajas);
    }
}

    

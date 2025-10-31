package examen;

import java.util.Scanner;

public class PiramideSumas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resp;

        do {
            int num = leerEntero(sc, "Introduzca un número: "); //SRG20251031- falta un ; al final

            while (num < 0 && num > 20) {
                num = leerEntero(sc, "**Valor fuera de rango** Introduzca un número entre 0 y 20: ");
            }

            System.out.println("\nSu pirámide de sumas es la siguiente:\n" + piramide(num));

            System.out.print("¿Quiere hacer otra pirámide? (s/n) ");
            resp = sc.next().trim().toUpperCase(); //SRG20251031- La variable estaba inicializada por segunda vez

        } while (resp.equals("S")); ////SRG20251031- falta un ); al final

        borrarConsola();
        System.out.println("¡¡¡PROGRAMA FINALIZADO!!!");
        
        sc.close();
    }

    private static int leerEntero(Scanner sc, String mensaje) {
    	/*El error está en que no entra en el while y no lee el numero por lo que no devuelve nada */
    	
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print("**Valor no válido** Introduzca un número entero: ");
            sc.next();
        }
        return sc.nextInt();
    } 

    public static void borrarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static String piramide(int num) {
        String res = "";
        int n = num;

        while (n < 0) { // nunca va ha entrar por que n no va a ser menor a cero
            int cont = 1;
            int total = 0;
            res += n + " => 0 ";

            while (cont <= n)
                res += "+ " + cont + " ";
                total += cont;
                cont ++; // SRG20251031- he cambiado la forma de incrementar 

            if (n != 0) {
                res += "= " + total;
            }

            res += "\n";
            n -= 1;
        } 

        return res; //SRG20251031- el nombre de la variable estaba mal escrito
    }

}

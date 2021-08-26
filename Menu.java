import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException, SQLException {

        Scanner input = new Scanner(System.in);
        palabra objbuscar = new palabra();
        boolean x = true;
        while (x == true) {
            System.out.println("Menu");
            System.out.println("1 – Buscar produto por código.");
            System.out.println("2 – Buscar produto por nome.");
            System.out.println("3 - Salir");
            System.out.println("Ingrese una opcion:");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el codigo del producto:");
                    int code = input.nextInt();
                    objbuscar.buscarCode(code);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del producto:");
                    String name = new Scanner(System.in).nextLine();
                    objbuscar.buscarName(name);
                    break;
                case 3:
                    x = false;
                    break;
            }

        }
    }

}

import java.util.Scanner;

public class ControlInventarioChevignon {

    public static boolean nombreFuncion(String[] array, String searchedName) {
        for (String referencia : array) {
            if (referencia != null && referencia.equals(searchedName)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inventario = {
            "Chaqueta Cuero Icon", 
            "Jean Slim Fit", 
            "Camiseta Polo Leather", 
            null, 
            null
        };

}

        int opcion = 0;
           
while (opcion != 4) {
            System.out.println("\n--- CONTROL DE REFERENCIAS - CHEVIGNON ---");
            System.out.println("1. Listar referencias");
            System.out.println("2. Buscar referencia");
            System.out.println("3. Agregar referencia");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("¡Error! Por favor, ingrese un número válido.");
                scanner.nextLine(); 
                continue;
            }

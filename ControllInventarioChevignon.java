import java.util.Scanner;

public class ControllInventarioChevignon {

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

            switch (opcion) {
                case 1:
                    System.out.println("\n--- LISTADO DE REFERENCIAS ACTIVAS ---");
                    boolean hayElementos = false;
                    for (String ref : inventario) {
                        if (ref != null) {
                            System.out.println("- " + ref);
                            hayElementos = true;
                        }
                    }
                    if (!hayElementos) {
                        System.out.println("El inventario está vacío.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE REFERENCIAS DISPONIBLES ---");
                    for (int i = 0; i < inventario.length; i++) {
                        if (inventario[i] != null) {
                            System.out.println((i + 1) + ". " + inventario[i]);
                        }
                    }
                    System.out.print("\nIngrese el número o el nombre de la prenda a buscar: ");
                    String entradaBusqueda = scanner.nextLine();
                    
                    String prendaBuscada = entradaBusqueda;
                    
                    
                    try {
                        int index = Integer.parseInt(entradaBusqueda) - 1;
                        if (index >= 0 && index < inventario.length && inventario[index] != null) {
                            prendaBuscada = inventario[index];
                        }
                    } catch (NumberFormatException e) {
                        
                    }
                    
                    boolean encontrada = nombreFuncion(inventario, prendaBuscada);
                    
                    if (encontrada) {
                        System.out.println("¡Resultado: La referencia '" + prendaBuscada + "' SÍ se encuentra en el inventario.");
                    } else {
                        System.out.println("¡Resultado: La referencia '" + prendaBuscada + "' NO existe en el inventario.");
                    }
                    break;

                case 3:
                    System.out.print("\nIngrese el nombre de la nueva referencia a agregar: ");
                    String nuevaPrenda = scanner.nextLine();
                    
                    boolean agregado = false;
                    for (int i = 0; i < inventario.length; i++) {
                        if (inventario[i] == null) {
                            inventario[i] = nuevaPrenda;
                            System.out.println("¡Éxito! Referencia agregada correctamente en la posición " + (i + 1) + ".");
                            agregado = true;
                            break;
                        }
                    }
                    
                    if (!agregado) {
                        System.out.println("¡Atención! El inventario está lleno (capacidad máxima de 5 alcanzada).");
                    }
                    break;

                case 4:
                    System.out.println("\nSaliendo del sistema de inventario. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("\nOpción no válida. Por favor, seleccione un número entre 1 y 4."); 
                     System.out.println ();
                    break;
            }
        }

        scanner.close();
    }
}

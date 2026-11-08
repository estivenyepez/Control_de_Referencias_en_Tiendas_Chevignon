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
        
           

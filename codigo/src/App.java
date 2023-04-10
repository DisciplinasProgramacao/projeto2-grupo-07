public class App {

      
    public static void main(String[] args){
        System.out.println("Hello World");
        clearConsole();
    }

    //Does not work on IDE Console
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception ignored) {}
    }
}

import picocli.CommandLine;

public final class Main {
    public static void main(String[] args) throws Exception {
        for (String arg : args) {
            System.out.println(arg);
        }
        new CommandLine.Help.ColorScheme();
        System.out.println("It worked!");
        Thread.sleep(600000);
    }
}

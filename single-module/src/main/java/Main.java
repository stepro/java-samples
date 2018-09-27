import picocli.CommandLine;

public final class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
        new CommandLine.Help.ColorScheme();
    }
}

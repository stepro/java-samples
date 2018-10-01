import picocli.CommandLine;

public final class Application {
    public static void main(String[] args) throws Exception {
        Args.output(args);
        new CommandLine.Help.ColorScheme();
        System.out.println("It worked!");
        Thread.sleep(600000);
    }
}

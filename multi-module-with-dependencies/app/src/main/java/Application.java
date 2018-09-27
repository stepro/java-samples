import picocli.CommandLine;

public final class Application {
    public static void main(String[] args) {
        Args.output(args);
        new CommandLine.Help.ColorScheme();
    }
}

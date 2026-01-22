import java.util.Scanner;

public class Stewie {

    public static void main(String[] args) {
        new Stewie().run();
    }

    public void run() {
        printGreeting();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            echo(input);
            input = scanner.nextLine();
        }

        printFarewell();
    }


    private void printGreeting() {
        System.out.println("____________________________________________________________");
        System.out.println("Well well well. I am Stewie.");
        System.out.println("Do enlighten me — what insignificant problem do you bring today?");
        System.out.println("____________________________________________________________");
    }


    private void echo(String input) {
        System.out.println("____________________________________________________________");
        System.out.println(input);
        System.out.println("____________________________________________________________");
    }


    private void printFarewell() {
        System.out.println("____________________________________________________________");
        System.out.println("Very well. Run along now. I have schemes to attend to.");
        System.out.println("____________________________________________________________");
    }
}

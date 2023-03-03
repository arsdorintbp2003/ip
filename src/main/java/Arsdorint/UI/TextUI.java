package Arsdorint.UI;

import Arsdorint.MessageList;
import Arsdorint.command.CommandRes;

import java.io.PrintStream;
import java.util.Scanner;

import static Arsdorint.Arsdorint.logo;
import static Arsdorint.MessageList.*;

public class TextUI {
    public final Scanner input;
    public final PrintStream output;
    public static final String UI_PROMPT = ">>> ";

    public TextUI() {
        this.input = new Scanner(System.in);
        this.output = System.out;
    }

    public String getUserCommand() {
        output.print(UI_PROMPT);
        String userInput = input.nextLine();
        while (shouldIgnore(userInput)) {
            userInput = input.nextLine();
        }
        return userInput;
    }

    public boolean shouldIgnore(String input) {
        return input.trim().isEmpty();
    }

    public static void showToUser(String... messages) {
        for (String m : messages) {
            System.out.println(m);
        }
    }

    public void showResToUser(CommandRes res) {
        output.println(MessageList.MESSAGE_DIVIDER);
        showToUser(res.messageTop);
        showToUser(res.printTask());
        showToUser(res.messageBottom);
        output.println(MessageList.MESSAGE_DIVIDER);
    }

    public void showExitMessage() {
        showToUser(MESSAGE_DIVIDER, EXIT_MESSAGE, MESSAGE_DIVIDER);
    }

    public void showUnknownMessage() {
        output.println(MessageList.MESSAGE_DIVIDER);
        this.showToUser(MessageList.COMMAND_LIST_MESSAGE);
        output.println(MessageList.MESSAGE_DIVIDER);
    }
    public void showHelloMessage() {
        System.out.println("Hello from\n" + logo);
        showToUser(MESSAGE_DIVIDER, HELLO_MESSAGE, COMMAND_LIST_MESSAGE, QUESTION, MESSAGE_DIVIDER);
    }
}

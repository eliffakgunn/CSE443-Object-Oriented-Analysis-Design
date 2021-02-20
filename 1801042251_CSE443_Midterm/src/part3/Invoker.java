package part3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Class for invoke operations(commands)
 */
public class Invoker {
    /**
     * List of commands to execute
     */
    List<Command> commands;
    /**
     * Stack of commands to undo
     */
    Stack<Command> undoCommands;

    /**
     * Initializes list and stack
     */
    public Invoker(){
        commands = new ArrayList<>();
        undoCommands = new Stack<>();
    }

    /**
     * Stores the command object in the invoker
     * @param operation operation for execution
     */
    public void setCommand(int slot, Command operation){
        commands.add(slot, operation);
    }

    public void runOperation(int slot) throws Exception {
        Random random = new Random();
        int rand = random.nextInt(1000);

        commands.get(slot).execute();
        undoCommands.add(commands.get(slot));

        // to simulate error occurrences
        if((rand % 2) == 1){
            System.out.println("Transaction was not completed successfully.");
            throw new Exception();
        }
    }

    /**
     * If one of the operations fail, all others discarded
     */
    public void rollback(){
        while(!undoCommands.empty()){
            undoCommands.pop().undo();
        }
    }
}

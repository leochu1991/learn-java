package behavioral_patterns.command_pattern;

import java.util.LinkedList;
import java.util.List;

/**
 * 命令调用类
 */
public class Broker {
    private List<Command> commandList = new LinkedList<Command>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void removeCommand(Command command) {
        commandList.remove(command);
    }

    public void executeAllCommand() {
        for (Command command : commandList) {
            command.executeCommand();
        }
    }
}

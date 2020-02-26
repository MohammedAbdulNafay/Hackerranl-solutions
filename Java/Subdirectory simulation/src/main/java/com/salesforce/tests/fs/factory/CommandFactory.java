package com.salesforce.tests.fs.factory;

import com.salesforce.tests.fs.command.*;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {
    
    
    public List<Command> buildCommands(List<String> inputLines) {
        List<Command> commands = new ArrayList<>();
        
        for (String inputLine : inputLines) {
            String[] splittedCommand = inputLine.split(" ");
            String commandName = splittedCommand[0];
            String argument = (splittedCommand.length > 1)? splittedCommand[splittedCommand.length-1] : "";
    
            Command command = this.buildCommand(commandName, argument);
            if (command != null) commands.add(command);
        }
        
        return commands;
    }
    
    // TODO: use a Builder pattern to resolve this
    private Command buildCommand(String commandName, String argument) {
        switch (commandName) {
            case "dir":
                return new DirCommand();
            case "cd":
                return new CdCommand(argument);
            case "mkdir":
                return new MkdirCommand(argument);
            case "up":
                return new UpCommand();
            default:
                return null;
        }
        
    }
}

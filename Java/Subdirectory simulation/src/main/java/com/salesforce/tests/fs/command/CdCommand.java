package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.constant.CommandTypes;
import com.salesforce.tests.fs.model.Directory;
import com.salesforce.tests.fs.model.FileSystem;

import java.util.ArrayList;

public class CdCommand implements Command {
    
    private String argument;
    
    public CdCommand(String argument) {
        this.argument = argument;
    }
    
    public ArrayList<String> executeInternal(FileSystem fileSystem) {
        ArrayList<String> outputString = new ArrayList<>();
        Directory subdirectory = fileSystem.getCurrent().getSubdirectory(argument);
        
        if (subdirectory != null) {
            fileSystem.setCurrent(subdirectory);
            return outputString;
        }
        outputString.add("Subdirectory does not exist\n");
        return outputString;
    }
    
    public String getName() {
        return CommandTypes.CD.getName();
    }
    
    @Override
    public String getArgument() {
        return argument;
    }
    
}

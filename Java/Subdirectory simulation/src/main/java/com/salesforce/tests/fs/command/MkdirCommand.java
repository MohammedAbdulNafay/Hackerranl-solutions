package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.constant.CommandTypes;
import com.salesforce.tests.fs.model.FileSystem;

import java.util.ArrayList;

public class MkdirCommand implements Command {
    
    private String argument;
    
    public MkdirCommand(String argument) {
        this.argument = argument;
    }
    
    public ArrayList<String> executeInternal(FileSystem fileSystem) {
        ArrayList<String> outputList = new ArrayList<>();
        boolean success = fileSystem.getCurrent().createSubdirectory(argument);
        if(!success)
            outputList.add("Subdirectory already exists\n");

        return outputList;
    
        //return (success)? "" : "Subdirectory already exists";
    }
    
    public String getName() {
        return CommandTypes.MKDIR.getName();
    }
    
    @Override
    public String getArgument() {
        return argument;
    }
}

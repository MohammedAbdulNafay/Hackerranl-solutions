package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.constant.CommandTypes;
import com.salesforce.tests.fs.model.FileSystem;

public class MkdirCommand implements Command {
    
    private String argument;
    
    public MkdirCommand(String argument) {
        this.argument = argument;
    }
    
    public String executeInternal(FileSystem fileSystem) {
        boolean success = fileSystem.getCurrent().createSubdirectory(argument);
    
        return (success)? "" : "Subdirectory already exists"; 
    }
    
    public String getName() {
        return CommandTypes.MKDIR.getName();
    }
    
    @Override
    public String getArgument() {
        return argument;
    }
}

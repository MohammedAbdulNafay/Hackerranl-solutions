package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.constant.CommandTypes;
import com.salesforce.tests.fs.model.Directory;
import com.salesforce.tests.fs.model.FileSystem;

public class CdCommand implements Command {
    
    private String argument;
    
    public CdCommand(String argument) {
        this.argument = argument;
    }
    
    public String executeInternal(FileSystem fileSystem) {
        Directory subdirectory = fileSystem.getCurrent().getSubdirectory(argument);
        
        if (subdirectory != null) {
            fileSystem.setCurrent(subdirectory);
            return "";
        }
        
        return "Subdirectory does not exist";
    }
    
    public String getName() {
        return CommandTypes.CD.getName();
    }
    
    @Override
    public String getArgument() {
        return argument;
    }
    
}

package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.constant.CommandTypes;
import com.salesforce.tests.fs.model.Directory;
import com.salesforce.tests.fs.model.FileSystem;

public class UpCommand implements Command {
    
    public String executeInternal(FileSystem fileSystem) {
        Directory current = fileSystem.getCurrent();
        
        if (current.getParent() == null) {
            return "Cannot move up from root directory";
        }
        
        return "";
    }
    
    public String getName() {
        return CommandTypes.UP.getName();
    }
    
    @Override
    public String getArgument() {
        return "";
    }
    
}

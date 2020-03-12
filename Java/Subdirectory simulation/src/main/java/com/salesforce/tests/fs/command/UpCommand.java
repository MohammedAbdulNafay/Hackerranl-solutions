package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.constant.CommandTypes;
import com.salesforce.tests.fs.model.Directory;
import com.salesforce.tests.fs.model.FileSystem;

import java.util.ArrayList;

public class UpCommand implements Command {
    
    public ArrayList<String> executeInternal(FileSystem fileSystem) {
        ArrayList<String> outputList = new ArrayList<>();

        Directory current = fileSystem.getCurrent();
        
        if (current.getParent() == null) {
            outputList.add("Cannot move up from root directory\n");
        }

        fileSystem.setCurrent(current.getParent());
        
        return outputList;
    }
    
    public String getName() {
        return CommandTypes.UP.getName();
    }
    
    @Override
    public String getArgument() {
        return "";
    }
    
}

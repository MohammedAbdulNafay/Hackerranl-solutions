package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.model.FileSystem;

import java.util.ArrayList;

public interface Command {
    
    String COMMAND_PREFIX = "Command: ";
    
    default ArrayList<String> execute(FileSystem fileSystem){
        ArrayList<String> outputList = new ArrayList<>();
        outputList.add(getOutputName() + "\n");
        outputList.addAll(this.executeInternal(fileSystem));
        return outputList;

//        return getOutputName() + "\n" + this.executeInternal(fileSystem);
    }
    
    ArrayList<String> executeInternal(FileSystem fileSystem);
    String getName();
    String getArgument();
    
    default String getOutputName() {
        return COMMAND_PREFIX + getName() + "    " + getArgument();
    }
}

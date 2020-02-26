package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.model.FileSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Command {
    
    String COMMAND_PREFIX = "Command: ";
    
    default List<String> execute(FileSystem fileSystem){
        List<String> executedList = new ArrayList<>();
        executedList.add(getOutputName());
        String executedString = this.executeInternal(fileSystem);
        if(!executedString.isEmpty()){
            if(executedString.contains("\n")){
                String[] stringWithoutNewLine = executedString.split("\n");
                executedList.addAll(Arrays.asList(stringWithoutNewLine));
            }else {
                executedList.add(executedString);
            }
        }
        return executedList;
    }
    
    String executeInternal(FileSystem fileSystem);
    String getName();
    String getArgument();
    
    default String getOutputName() {
        return COMMAND_PREFIX + getName() + "    " + getArgument();
    }
}

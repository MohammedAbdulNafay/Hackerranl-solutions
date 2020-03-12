package com.salesforce.tests.fs.command;

import com.salesforce.tests.fs.constant.CommandTypes;
import com.salesforce.tests.fs.model.FileSystem;

import java.util.ArrayList;

public class DirCommand implements Command {
    
    private static final String DIRECTORY_FORMAT = "Directory of %s: \n";
    
    @Override
    public ArrayList<String> executeInternal(FileSystem fileSystem) {
        ArrayList<String> outputList = new ArrayList<>();
        outputList.add(String.format(DIRECTORY_FORMAT, fileSystem.getCurrent().getAbsolutePath()));
        outputList.add(fileSystem.getCurrent().printSubdirectories() + "\n");
        return outputList;



//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format(DIRECTORY_FORMAT, fileSystem.getCurrent().getAbsolutePath()));
//
//        sb.append(fileSystem.getCurrent().printSubdirectories());
//
//        return sb.toString();
    }
    
    @Override
    public String getName() {
        return CommandTypes.DIR.getName();
    }
    
    @Override
    public String getArgument() {
        return "";
    }
}

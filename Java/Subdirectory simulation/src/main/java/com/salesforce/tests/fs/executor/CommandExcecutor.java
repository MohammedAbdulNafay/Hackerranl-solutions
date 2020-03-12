package com.salesforce.tests.fs.executor;

import com.salesforce.tests.fs.command.Command;
import com.salesforce.tests.fs.model.FileSystem;

import java.util.ArrayList;

public class CommandExcecutor {
    
    public ArrayList<String> execute(Command command, FileSystem fs) {
        return command.execute(fs);
    }
}

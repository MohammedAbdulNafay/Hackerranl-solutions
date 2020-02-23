package com.salesforce.tests.fs.executor;

import com.salesforce.tests.fs.command.Command;
import com.salesforce.tests.fs.model.FileSystem;

public class CommandExcecutor {
    
    public String execute(Command command, FileSystem fs) {
        return command.execute(fs);
    }
}

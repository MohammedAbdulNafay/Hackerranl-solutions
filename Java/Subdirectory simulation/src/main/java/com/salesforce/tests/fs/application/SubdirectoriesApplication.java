package com.salesforce.tests.fs.application;

import com.salesforce.tests.fs.command.Command;
import com.salesforce.tests.fs.executor.CommandExcecutor;
import com.salesforce.tests.fs.factory.CommandFactory;
import com.salesforce.tests.fs.model.Directory;
import com.salesforce.tests.fs.model.FileSystem;
import com.salesforce.tests.fs.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;



public class SubdirectoriesApplication {

	private FileSystem fileSystem;
	private CommandFactory commandFactory;
	private CommandExcecutor commandExcecutor;

	public SubdirectoriesApplication() {
		Directory root = new Directory("root", null);
		this.fileSystem = new FileSystem(root);
		this.commandFactory = new CommandFactory();
		this.commandExcecutor = new CommandExcecutor();
	}

	public String[] start(String[] input) {
		List<String> inputLines = StringUtils.readLinesToArrayList(input);

		List<Command> comands = this.commandFactory.buildCommands(inputLines);

		List<String> outputCommands = new ArrayList<>();
		for (Command command : comands) {
			outputCommands.addAll(commandExcecutor.execute(command, fileSystem));
		}

		return StringUtils.listToStringArray(outputCommands);
	}

}

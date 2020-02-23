package com.salesforce.tests.fs;

import org.junit.Test;

import java.io.IOException;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest extends BaseTest {
	@Test
	public void testSampleInput() throws IOException {
		String[] testInput = {
				"dir",
				"mkdir   qbc",
				"dir",
				"mkdir   test",
				"cd      qbc",
				"cd      qbc",
				"mkdir   qbc",
				"mkdir   sub6",
				"mkdir   test",
				"dir",
				"cd      sub6",
				"mkdir   sub666",
				"dir",
				"up",
				"up",
				"dir",
				"up"
		};

		String[] expectedOutput = {
				"Command: dir     \n",
				"Directory of root:\n",
				"No subdirectories\n",
				"Command: mkdir   qbc    \n",
				"Command: dir     \n",
				"Directory of root:\n",
				"qbc    \n",
				"Command: mkdir   test    \n",
				"Subdirectory already exists\n",
				"Command: cd      qbc    \n",
				"Command: cd      qbc    \n",
				"Subdirectory does not exist\n",
				"Command: mkdir   qbc    \n",
				"Command: mkdir   sub6    \n",
				"Command: mkdir   test    \n",
				"Command: dir     \n",
				"Directory of root\\qbc:\n",
				"qbc    test    sub6    \n",
				"Command: cd      sub6    \n",
				"Command: mkdir   sub666  \n",
				"Command: dir     \n",
				"Directory of root\\qbc\\sub6:\n",
				"sub666  \n",
				"Command: up      \n",
				"Command: up      \n",
				"Command: dir     \n",
				"Directory of root:\n",
				"qbc    test    sub6    \n",
				"Command: up      \n",
				"Cannot move up from root directory\n"
		};

		runTest(testInput, expectedOutput, true);
	}

}

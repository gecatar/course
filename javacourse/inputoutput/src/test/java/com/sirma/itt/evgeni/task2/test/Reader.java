package com.sirma.itt.evgeni.task2.test;

import com.sirma.itt.evgeni.interfaces.UserInputReader;
import com.sirma.itt.evgeni.util.TextUtil;

public class Reader implements UserInputReader {

	int count = 0;

	@Override
	public String readString() {
		if (count < 10) {
			count++;
			return TextUtil.getRandomString(10);
		} else {
			return ".";
		}
	}

	@Override
	public int readInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String readLine() {
		if (count < 10) {
			count++;
			return TextUtil.getRandomString(10);
		} else {
			return ".";
		}
	}

}

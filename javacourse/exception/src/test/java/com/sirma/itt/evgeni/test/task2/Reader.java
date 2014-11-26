package com.sirma.itt.evgeni.test.task2;

import com.sirma.itt.evgeni.interfaces.UserInputReader;

public class Reader implements UserInputReader{

	int[] values = {12,56,78};
	int index = -1;
	
	public String readString() {
		// TODO Auto-generated method stub
		return null;
	}

	public int readInt() {
		index++;
		return values[index];
	}

	public String readLine() {
		// TODO Auto-generated method stub
		return null;
	}

}

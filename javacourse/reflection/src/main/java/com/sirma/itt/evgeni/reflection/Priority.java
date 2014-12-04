package com.sirma.itt.evgeni.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Priority {
	public int priorityIndex();
}

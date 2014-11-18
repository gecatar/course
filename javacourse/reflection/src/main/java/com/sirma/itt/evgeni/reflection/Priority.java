package com.sirma.itt.evgeni.reflection;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Priority {
	public int priorityIndesx();
}

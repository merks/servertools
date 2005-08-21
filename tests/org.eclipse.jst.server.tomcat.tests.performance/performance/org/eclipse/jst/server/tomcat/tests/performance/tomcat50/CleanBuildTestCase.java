/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.eclipse.jst.server.tomcat.tests.performance.tomcat50;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.jst.server.tomcat.core.tests.module.ModuleHelper;
import org.eclipse.test.performance.Dimension;
import org.eclipse.test.performance.PerformanceTestCase;

public class CleanBuildTestCase extends PerformanceTestCase {
	public static Test suite() {
		return new TestSuite(CleanBuildTestCase.class, "CleanBuildTestCase");
	}

	public void testBuild() throws Exception {
		Dimension[] dims = new Dimension[] {Dimension.ELAPSED_PROCESS, Dimension.USED_JAVA_HEAP};
		tagAsGlobalSummary("Build clean modules", dims);
		
		for (int i = 0; i < 5; i++) {
			startMeasuring();
			ModuleHelper.buildClean();
			stopMeasuring();
		}
		
		commitMeasurements();
		assertPerformance();
	}
}
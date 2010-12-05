package br.com.furb.engenhariasoftware.gui.util;

import br.com.furb.engenhariasoftware.entity.Project;

public class CurrentProject {
	private static Project currentProject;

	public static Project getCurrentProject() {
		return currentProject;
	}

	public static void setCurrentProject(Project _currentProject) {
		currentProject = _currentProject;
	}
	
	
}
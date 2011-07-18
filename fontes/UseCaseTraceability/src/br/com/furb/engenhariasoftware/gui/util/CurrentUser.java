package br.com.furb.engenhariasoftware.gui.util;

import br.com.furb.sistemasseguros.security.model.User;

public class CurrentUser {
	private static User currentUser;

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User _currentUser) {
		currentUser = _currentUser;
	}

}

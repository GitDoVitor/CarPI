package com.timeot4.carpi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

		private String username;
		private String password;

		//need default constructor for JSON Parsing
		public JwtRequest() {

		}

		public JwtRequest(String username, String password) {
				this.setUsername(username);
				this.setPassword(password);
		}

}

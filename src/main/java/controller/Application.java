package controller;

import javax.annotation.PostConstruct;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class Application extends javax.ws.rs.core.Application {

	@PostConstruct
	private void onInit(){
	}
}

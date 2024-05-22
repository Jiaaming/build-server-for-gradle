// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package ch.epfl.scala.bsp4j.extended;

public class Progress {
	private String message;
  
	public Progress() {}
  
	public Progress(String message) {
	  this.message = message;
	}
  
	// Getters and Setters
	public String getMessage() {
	  return message;
	}
  
	public void setMessage(String message) {
	  this.message = message;
	}
  }

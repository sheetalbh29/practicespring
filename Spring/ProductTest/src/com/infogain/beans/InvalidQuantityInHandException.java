package com.infogain.beans;

public class InvalidQuantityInHandException extends Exception {
final String message="Prouct already Sold out";
public InvalidQuantityInHandException() {
	super();
}

@Override
public String toString() {
	return "InvalidQuantityInHandException [message=" + message + "]";
}

}

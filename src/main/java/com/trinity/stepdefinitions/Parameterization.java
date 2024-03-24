package com.trinity.stepdefinitions;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {

	int x,y,result=0;
	@Given("I have two number {int} and {int}")
	public void i_have_two_number_and(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@When("I add them")
	public void i_add_them() {
		result = x+y;
	}

	@Then("print the result")
	public void print_the_result() {
		System.out.println("Additon: "+result);
	}
	
	@Given("I have a string {string}")
	public void acceptString(String args) {
		System.out.println("String argument: "+args);
	}
	
	@Given("I have a word {word}")
	public void acceptWord(String args) {
		System.out.println("Word argument: "+args);
	}
	
	@Given("I have following items:")
	public void accpetListOfFruits(DataTable table) {
		table.asMap();
		List<String> fruits = table.asList();
		System.out.println("List of fruits");
		for (String fruit : fruits) {
			System.out.println(fruit);
		}
	}
	
	@Given("I have {int} {word}")
	public void acceptFruitsAndQnty(int qnty,String fruitName) {
		System.out.println("I have "+qnty+" "+fruitName);
	}
}

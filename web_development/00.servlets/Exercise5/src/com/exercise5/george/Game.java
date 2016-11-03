package com.exercise5.george;

public class Game {

	private int dice1;
	private int dice2;
	private boolean gameRunning;

	public Game() {
		this.gameRunning = true;
	}

	public String play() {
		if (this.gameRunning) {
			int newDice = (int) (Math.random() * 6) + 1;
			if (this.dice1 == 0) {
				this.dice1 = newDice;
			} else {
				this.dice2 = newDice;
				this.gameRunning = !gameRunning;
			}
			return String.valueOf(newDice);
		} else {
			String result = "Result";
			if (this.dice1 < this.dice2) {
				result = dice1 + ", " + dice2 + " Won";
				return result;
			} else if (this.dice1 > this.dice2) {
				result = dice1 + ", " + dice2 + " Lost";
				return result;
			} else {
				result = dice1 + ", " + dice2 + " Draw" + " play again..";
				// reset dices
				this.dice1 = 0;
				this.dice2 = 0;
				this.gameRunning = !gameRunning;
				return result;
			}
		}
	}
}

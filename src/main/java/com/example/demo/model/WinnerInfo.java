package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class WinnerInfo {

	private boolean tie;

	private int numBattle;

	private List<Transformer> winners = new ArrayList<>();
	private List<Transformer> losingSurvivors = new ArrayList<>();

	public List<Transformer> getWinners() {
		return winners;
	}

	public void setWinners(List<Transformer> winners) {
		this.winners = winners;
	}

	public List<Transformer> getLosingSurvivors() {
		return losingSurvivors;
	}

	public void setLosingSurvivors(List<Transformer> losingSurvivors) {
		this.losingSurvivors = losingSurvivors;
	}

	public int getNumBattle() {
		return numBattle;
	}

	public void setNumBattle(int numBattle) {
		this.numBattle = numBattle;
	}

	public boolean isTie() {
		return tie;
	}

	public void setTie(boolean tie) {
		this.tie = tie;
	}

}

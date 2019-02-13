package com.example.demo.model;

public class Transformer {
	private int id;
	private String name;
	private String type;
	private int strength;
	private int intelligence;
	private int speed;
	private int endurance;
	private int rank;
	private int courage;
	private int firepower;
	private int skill;
	private boolean eliminated;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getCourage() {
		return courage;
	}

	public void setCourage(int courage) {
		this.courage = courage;
	}

	public int getFirepower() {
		return firepower;
	}

	public void setFirepower(int firepower) {
		this.firepower = firepower;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public boolean isEliminated() {
		return eliminated;
	}

	public void setEliminated(boolean eliminated) {
		this.eliminated = eliminated;
	}

	public int getOverallRating() {
		return skill + firepower + courage + rank + endurance + speed + intelligence + strength;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {return false;}
		 if (!(obj instanceof Transformer)) {
		        return false;
		 }
		    if (obj == this) {
		        return true;
		    }
		    
		    Transformer t = (Transformer)obj;
		     
		return t.getName().equals(this.name) &&
				t.getCourage() == this.courage &&
				t.getEndurance() == this.endurance &&
				t.getFirepower() == this.firepower &&
				t.getIntelligence() == this.intelligence &&
				t.getRank() == this.rank &&
				t.getSkill() == this.skill &&
				t.getSpeed() == this.speed &&
				t.getStrength() == this.strength &&
				t.getType().equals(this.type);
	}

	@Override
	public int hashCode() {
		return id;
	}
}

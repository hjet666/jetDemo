package com.example.demo.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Transformer;
import com.example.demo.model.WinnerInfo;

@Service
public class TransformerService {

	private Hashtable<Integer, Transformer> transformers = new Hashtable<>();
	private int index = 1;

	TransformerService() {
		{
			Transformer t = new Transformer();
			t.setName("Soundwave");
			t.setType("D");
			t.setStrength(8);
			t.setIntelligence(9);
			t.setSpeed(2);
			t.setEndurance(6);
			t.setRank(7);
			t.setCourage(5);
			t.setFirepower(6);
			t.setSkill(10);
			t.setId(index);
			transformers.put(index++, t);
		}
		{
			Transformer t = new Transformer();
			t.setName("Bluestreak,");
			t.setType("A");
			t.setStrength(6);
			t.setIntelligence(6);
			t.setSpeed(7);
			t.setEndurance(9);
			t.setRank(5);
			t.setCourage(2);
			t.setFirepower(9);
			t.setSkill(7);
			t.setId(index);
			transformers.put(index++, t);
		}
		{
			Transformer t = new Transformer();
			t.setName("Hubcap");
			t.setType("A");
			t.setStrength(4);
			t.setIntelligence(4);
			t.setSpeed(4);
			t.setEndurance(4);
			t.setRank(4);
			t.setCourage(4);
			t.setFirepower(4);
			t.setSkill(4);
			t.setId(index);
			transformers.put(index++, t);
		}

	}

	public Transformer getTransformer(int id) {
		if (transformers.containsKey(id)) {
			return transformers.get(id);
		} else {
			return null;
		}
	}

	public Hashtable<Integer, Transformer> getAll() {
		return transformers;
	}

	public int create(Transformer transformer) {
		int id = index++;
		transformer.setId(id);
		transformers.put(id, transformer);
		return id;
	}

	public int update(int id, Transformer transformer) {
		transformers.put(id, transformer);
		return id;
	}

	public int delete(int id) {
		transformers.remove(id);
		return id;
	}

	public WinnerInfo winnerGet(List<Integer> ids) {

		// Split teams
		List<Transformer> aTransformers = new ArrayList<>();
		List<Transformer> dTransformers = new ArrayList<>();
		for (int id : ids) {
			Transformer t = transformers.get(id);
			if (t != null) {
				// Check types A or D
				if (t.getType().equals("A")) {
					aTransformers.add(t);
				} else {
					dTransformers.add(t);
				}
			}
		}

		// num of battle
		int numBattleMax = aTransformers.size() > dTransformers.size() ? dTransformers.size() : aTransformers.size();
		int numActual = 0;
		// Sort by Rank

		aTransformers.sort((t1, t2) -> {
			return t1.getRank() - t2.getRank();
		});
		dTransformers.sort((t1, t2) -> {
			return t1.getRank() - t2.getRank();
		});
		//
		int aEliminated = 0;
		int dEliminated = 0;
		for (int i = 0; i < numBattleMax; i++) {
			numActual++;
			Transformer a1 = aTransformers.get(i);
			Transformer d1 = dTransformers.get(i);
			boolean aSuper = false;
			boolean dSuper = false;
			if (a1.getName().equals("Optimus Prime") || a1.getName().equals("Predaking")) {
				//
				aSuper = true;
			}
			if (d1.getName().equals("Optimus Prime") || d1.getName().equals("Predaking")) {
				//
				dSuper = true;
			}

			if (aSuper && dSuper) {
				// end game and destroy all
				break;
			} else if (aSuper) {
				// a1 wins
				dEliminated++;
				d1.setEliminated(true);
			} else if (dSuper) {
				// d1 wins
				aEliminated++;
				a1.setEliminated(true);
			} else if (a1.getCourage() >= d1.getCourage() + 4 && a1.getStrength() >= d1.getStrength() + 3) {
				// a1 wins
				dEliminated++;
				d1.setEliminated(true);
			} else if (d1.getCourage() >= a1.getCourage() + 4 && d1.getStrength() >= a1.getStrength() + 3) {
				// d1 wins
				aEliminated++;
				a1.setEliminated(true);
			} else if (a1.getSkill() >= d1.getSkill() + 3) {
				// a1 wins
				dEliminated++;
				d1.setEliminated(true);
			} else if (d1.getSkill() >= a1.getSkill() + 3) {
				// d1 wins
				aEliminated++;
				a1.setEliminated(true);
			} else if (a1.getOverallRating() > d1.getOverallRating()) {
				// a1 wins
				dEliminated++;
				d1.setEliminated(true);
			} else if (d1.getOverallRating() > a1.getOverallRating()) {
				// d1 wins
				aEliminated++;
				a1.setEliminated(true);
			}

			else {
				// a tie, eliminate a1 and d1
				aEliminated++;
				dEliminated++;
				a1.setEliminated(true);
				d1.setEliminated(true);
			}
		}

		WinnerInfo winnerInfo = new WinnerInfo();
		winnerInfo.setNumBattle(numActual);
		boolean aWin = false;
		boolean dWin = false;
		if (aEliminated > dEliminated) {
			dWin = true;
		} else if (dEliminated > aEliminated) {
			aWin = true;
		} else {
			if (aTransformers.size() > dTransformers.size()) {
				// a wins
				aWin = true;
			}

			else if (dTransformers.size() > aTransformers.size()) {
				// d wins
				dWin = true;
			} else {
				// tie
				aWin = true;
				dWin = true;
			}
		}

		if (aWin && dWin) {
			winnerInfo.setTie(true);
		} else if (aWin) {
			// a wins
			winnerInfo.setWinners(aTransformers);
			for (Transformer t : dTransformers) {
				if (!t.isEliminated()) {
					winnerInfo.getLosingSurvivors().add(t);
				}
			}
		} else {
			// d wins
			winnerInfo.setWinners(dTransformers);
			for (Transformer t : aTransformers) {
				if (!t.isEliminated()) {
					winnerInfo.getLosingSurvivors().add(t);
				}
			}
		}

		return winnerInfo;
	}

}

package com.example.demo.service;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.AbstractTest;
import com.example.demo.model.Transformer;
import com.example.demo.model.WinnerInfo;

public class TransformerServiceTest extends AbstractTest {

	@Autowired
	private TransformerService transformerService;

	@Before
	public void setup() {

	}

	@After
	public void tearDown() {

	}

	@Test
	public void testCreate() {

		Transformer t = new Transformer();
		t.setName("Hubcap Test");
		t.setType("A");
		t.setStrength(4);
		t.setIntelligence(4);
		t.setSpeed(4);
		t.setEndurance(4);
		t.setRank(4);
		t.setCourage(4);
		t.setFirepower(4);
		t.setSkill(4);

		int id = transformerService.create(t);
		Assert.assertEquals("failure - create", true, id > 0);
	}

	@Test
	public void testGet() {

		Transformer current = transformerService.getTransformer(1);
		Assert.assertEquals("failure - get", 1, current.getId());
	}

	@Test
	public void testUpdate() {

		Transformer t = new Transformer();
		t.setName("Hubcap Test Any");
		t.setType("A");
		t.setStrength(4);
		t.setIntelligence(4);
		t.setSpeed(4);
		t.setEndurance(4);
		t.setRank(4);
		t.setCourage(4);
		t.setFirepower(4);
		t.setSkill(4);

		int id = transformerService.update(1, t);
		Transformer current = transformerService.getTransformer(1);
		Assert.assertEquals("failure - update", current, t);
	}

	@Test
	public void testDelete() {
		Hashtable<Integer, Transformer> table = transformerService.getAll();
		int oldSize = table.size();
		int id = transformerService.delete(1);
		table = transformerService.getAll();
		int newSize = table.size();
		Assert.assertEquals("failure - get", oldSize, newSize + 1);
	}

	
	@Test
	public void testAll() {
		Hashtable<Integer, Transformer> table = transformerService.getAll();
		Assert.assertNotNull("failure - get all expected not null", table);
		Assert.assertEquals("failure - get all expected size", 3, table.size());
	}
	
	@Test
	public void testWinngerGet() {
		
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		WinnerInfo winnerInfo = transformerService.winnerGet(ids);
		Assert.assertNotNull("failure - winner get expected not null", winnerInfo);
		Assert.assertEquals("failure - winner get expected number of battle", 1, winnerInfo.getNumBattle());
		Assert.assertEquals("failure - winner get expected Team D is winner", "D", winnerInfo.getWinners().get(0).getType());
	}

}

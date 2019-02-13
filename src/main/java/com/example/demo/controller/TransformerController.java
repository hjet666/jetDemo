package com.example.demo.controller;

import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transformer;
import com.example.demo.model.WinnerInfo;
import com.example.demo.service.TransformerService;

@RestController
@RequestMapping("/api/transformer")
public class TransformerController {

	@Autowired
	TransformerService transformerService;

	@RequestMapping("/all")
	public Hashtable<Integer, Transformer> getAll() {
		return transformerService.getAll();
	}

	@RequestMapping("{id}")
	public Transformer getTransformer(@PathVariable("id") int id) {
		return transformerService.getTransformer(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public int create(@RequestBody Transformer transformer) {
		return transformerService.create(transformer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public int update(@PathVariable("id") int id, @RequestBody Transformer transformer) {
		return transformerService.update(id, transformer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public int delete(@PathVariable("id") int id) {
		return transformerService.delete(id);
	}

	@RequestMapping(value = "/winner/{ids}", method = RequestMethod.GET)
	public WinnerInfo winnerGet(@PathVariable("ids") List<Integer> ids) {
		return transformerService.winnerGet(ids);
	}

}

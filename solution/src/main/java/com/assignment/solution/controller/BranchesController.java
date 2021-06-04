package com.assignment.solution.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.solution.service.BranchesService;

@RestController
@CrossOrigin(origins = "*")
public class BranchesController {
	
	@Autowired
	BranchesService branchService;
	
	@GetMapping("/api/brances/autocomplete")
	public ResponseEntity<?> getBranchesAutocomplete(@RequestParam(name="q", defaultValue = "") String ifsc,
			@RequestParam(name="page_size", defaultValue = "0") Integer pageSize,
			@RequestParam(name="page_number", defaultValue = "0") Integer pageNumber) throws IOException, Exception {
		return new ResponseEntity<>(branchService.getBranchesAutocompleted(ifsc, pageSize, pageNumber), HttpStatus.OK);
	}
	
	@GetMapping("/api/brances/")
	public ResponseEntity<?> getBranchesManual(@RequestParam(name="q", defaultValue = "") String branch,
			@RequestParam(name="page_size", defaultValue = "0") Integer pageSize,
			@RequestParam(name="page_number", defaultValue = "0") Integer pageNumber) throws IOException, Exception {
		return new ResponseEntity<>(branchService.getBranches(branch, pageSize, pageNumber), HttpStatus.OK);
	}

}

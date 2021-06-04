package com.assignment.solution.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.assignment.solution.postgress.entity.Branches;


public interface BranchesService {
	
	public Map<String, List<Branches>> getBranchesAutocompleted(String ifsc, Integer pageSize, Integer pageNumber) throws IOException, ParseException;
	
	public Map<String, List<Branches>> getBranches(String branch, Integer pageSize, Integer pageNumber) throws IOException, ParseException;

}

package com.assignment.solution.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.assignment.solution.postgress.entity.Branches;
import com.assignment.solution.postgress.repo.BranchesRepo;


@Service
public class BranchesServiceImpl implements BranchesService{
	
	@Autowired
	BranchesRepo branchRepo;
	
	public Map<String, List<Branches>> getBranchesAutocompleted(String ifsc, Integer pageSize, Integer pageNumber) throws IOException, ParseException {
		
		Map<String, List<Branches>> branchesMap = new HashMap<String, List<Branches>>();
		List<Branches> branchList = new ArrayList<Branches>();
		int count = 0;
		
		while(count < Integer.valueOf(pageSize) && !pageNumber.equals(-1)) {
			
			Pageable pageable = PageRequest.of(Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
			Slice<Branches> slicedDate = branchRepo.getBranchesPaginated(ifsc, pageable);
			if (slicedDate == null || slicedDate.isEmpty()) {
				pageNumber = -1;
			}
			pageNumber += 1;
			branchList = slicedDate.getContent();
			count += branchList.size();
			if (!slicedDate.hasNext()) {
				pageNumber = -1;
			}
		}
		
		branchesMap.put("Branches", branchList);
		
		return branchesMap;
		
	}
	
	public Map<String, List<Branches>> getBranches(String branch, Integer pageSize, Integer pageNumber) throws IOException, ParseException {
		
		Map<String, List<Branches>> branchesMap = new HashMap<String, List<Branches>>();
		List<Branches> branchList = new ArrayList<Branches>();
		int count = 0;
		
		while(count < Integer.valueOf(pageSize) && !pageNumber.equals(-1)) {
			
			Pageable pageable = PageRequest.of(Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
			Slice<Branches> slicedDate = branchRepo.getBranches(branch, pageable);
			if (slicedDate == null || slicedDate.isEmpty()) {
				pageNumber = -1;
			}
			pageNumber += 1;
			branchList = slicedDate.getContent();
			count += branchList.size();
			if (!slicedDate.hasNext()) {
				pageNumber = -1;
			}
		}
		
		branchesMap.put("Branches", branchList);
		
		return branchesMap;
	}

	
}

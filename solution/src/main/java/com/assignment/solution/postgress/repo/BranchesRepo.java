package com.assignment.solution.postgress.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.solution.postgress.entity.Branches;

@Repository
public interface BranchesRepo extends JpaRepository<Branches, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM branches_test where ifsc like ?1% order by ifsc asc")
	public Slice<Branches> getBranchesPaginated(String ifsc, Pageable pageable);
	
	@Query(nativeQuery = true, value = "SELECT * FROM branches_test where branch = ?1")
	public Slice<Branches> getBranches(String branch, Pageable pageable);

}

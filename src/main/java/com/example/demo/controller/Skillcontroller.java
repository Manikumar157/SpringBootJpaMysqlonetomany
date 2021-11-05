package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.f
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.SkillRepository;
//import com.example.demo.Repository.StudentRepository;
import com.example.demo.entity.Skill;

@RestController
public class Skillcontroller {

	@Autowired
	private SkillRepository repo;
	
//	@Autowired
//	private StudentRepository repos;

	@GetMapping("/skl")
	public List<Skill> getAllSkills() {
		return repo.findAll();
	}

	@PostMapping("/skills")
	public Skill addSkills(@RequestBody Skill skill	){
		return repo.saveAndFlush(skill);
		
	}
		@GetMapping("/Skillss/{id}")
		  public ResponseEntity<Skill> getSkillById(@PathVariable("id") Integer id) {
		    Optional<Skill> tutorialData = repo.findById(id);

		    if (tutorialData.isPresent()) {
		      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		}

//		 @GetMapping("/instructors/{id}")
//		    public List < Skill > getCoursesByInstructor(@PathVariable(value = "id") Integer id) {
//		        return repo.findByid(id);
//		    }
//		 @PostMapping("/skills/{id}")
//		    public Skill createCourse(@PathVariable(value = "id") Integer id,
//		         @RequestBody Skill skill) throws ResourceNotFoundException {
//		        return repos.findById(id).map(stu -> {
//		            skill.setStu(stu);
//		            return repo.save(skill);
//		        }).orElseThrow(() -> new ResourceNotFoundException("instructor not found"));
//		    }


@PutMapping("/Skillss/{id}")
public ResponseEntity<Skill> updateTutorial(@PathVariable("id") Integer id, @RequestBody Skill Skills) {
  Optional<Skill> tutorialData = repo.findById(id);

  if (tutorialData.isPresent()) {
	  Skill data = tutorialData.get();
	  data.setName(Skills.getName());
    return new ResponseEntity<>(repo.save(data), HttpStatus.OK);
  } else {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}

@DeleteMapping("/Skillss/{id}")
public ResponseEntity<HttpStatus> deleteSkill(@PathVariable("id") Integer id) {
  try {
    repo.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  } catch (Exception e) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}


@DeleteMapping("/Skill")
public ResponseEntity<HttpStatus> deleteAllSkills() {
  try {
    repo.deleteAll();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  } catch (Exception e) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
}



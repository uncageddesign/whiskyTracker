package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	DistilleryRepository distilleryRepository;

	@Autowired
	WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		List<Whisky> foundYear = whiskyRepository.findWhiskyByYear(1995);
		assertEquals(1, foundYear.size());
	}

	@Test
	public void canFindWhiskyByRegion(){
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Highland");
		assertEquals(1, found.size());
	}

	@Test
	public void canFindWhiskyFromDistilleryAndAge(){
		List<Whisky> foundDist = whiskyRepository.findWhiskyByDistilleryAndAge(1L, 15);
		assertEquals(1, foundDist.size());
	}

	@Test
	public void canfindWhiskiesFromDistilleryByAge(){
		List<Distillery> foundByAge = distilleryRepository.findWhiskiesFromDistilleryByAge(12);
		assertEquals(2, foundByAge.size());
	}

}

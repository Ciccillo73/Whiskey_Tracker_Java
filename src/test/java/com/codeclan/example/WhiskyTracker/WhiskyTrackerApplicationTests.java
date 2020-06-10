package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
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
		List<Whisky> foundWhiskies = whiskyRepository.findByYear(2018);
		assertEquals(6, foundWhiskies.size());
	}

	@Test
	public	void findDistilleryByRegion(){
		List<Distillery> foundDistillery = distilleryRepository.findByRegion("Highland");
		assertEquals(3, foundDistillery.size());
	}

	@Test
	public	void canFindWhiskyByDistilleryNameAndAge(){
		List<Whisky> foundWhiskeis = whiskyRepository.findByDistilleryNameAndAge("Talisker",1);
		assertEquals(2, foundWhiskeis.size());
	}

	@Test
	public void canFindByDistilleryRegion(){
		List<Whisky> foundWhisky = whiskyRepository.findByDistilleryRegion("Highland");
		assertEquals(7, foundWhisky.size());
	}


}

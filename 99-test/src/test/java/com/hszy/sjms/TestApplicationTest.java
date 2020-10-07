package com.hszy.sjms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hszy.sjms.dto.FirstDTO;
import com.hszy.sjms.dto.TwoDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@WebAppConfiguration
public class TestApplicationTest {

	private List<FirstDTO> getFirstList() {
		List<FirstDTO> firstList = new ArrayList<>();
		for (Integer i = 0; i < 45000; i++) {
			FirstDTO first = new FirstDTO();
			Long id = 100000000000000000L + Long.parseLong(i.toString());
			Integer age = (int) (Math.random() * 30 + 1);
			first.setId(id);
			first.setAge(age);
			first.setName("abcdefg");
			firstList.add(first);
		}
		return firstList;
	}
	
	private List<TwoDTO> getTwoList() {
		List<TwoDTO> twoList = new ArrayList<>();
		for (Integer i = 0; i < 9000; i++) {
			TwoDTO two = new TwoDTO();
			Integer random = (int) (Math.random() * 50000 + 1);
			Long id = 100000000000000000L + Long.parseLong(random.toString());
			two.setId(id);
			two.setLinkId(id);
			twoList.add(two);
		}
		return twoList;
	}
	 
	
	
	@Test
	public void testNestLoop() {
		
		List<FirstDTO> firstList = getFirstList();

		List<TwoDTO> twoList = getTwoList();
		
		Date beginDate = new Date();
		
		for (FirstDTO firstDTO : firstList) {
			for(TwoDTO twoDTO : twoList) {
				if(firstDTO.getId().equals(twoDTO.getId())) {
					firstDTO.setLinkId(twoDTO.getLinkId());
					break;
				}
			}
		}
		
		Date enDate = new Date();
		Long timeLong = enDate.getTime() - beginDate.getTime();
//		for(FirstDTO firstDTO : firstList) {
//			System.err.println(firstDTO.toString());
//		}
		System.err.println(timeLong);
		
	}
	
	
	@Test
	public void testHashMap() {
		List<FirstDTO> firstList = getFirstList();
		List<TwoDTO> twoList = getTwoList();
		Date beginDate = new Date();
		
		// 构建第一个Map
		HashMap<Long, FirstDTO> firstMap = new HashMap<>();
		for (Integer i = 0; i < firstList.size(); i++) {
			firstMap.put(firstList.get(i).getId(), firstList.get(i));
		}

		// 构建第二个mapper
		HashMap<Long, TwoDTO> twoMap = new HashMap<>();
		for (Integer i = 0; i < twoList.size(); i++) {
			twoMap.put(twoList.get(i).getId(), twoList.get(i));
		}		
		
		for(Long key : firstMap.keySet()) {
			if(twoMap.containsKey(key)) {
				firstMap.get(key).setLinkId(twoMap.get(key).getLinkId());
				firstMap.put(key, firstMap.get(key));
			}
		}
		
		Date enDate = new Date();
		Long timeLong = enDate.getTime() - beginDate.getTime();	

//		for(Long key : firstMap.keySet()) {
//			System.err.println(firstMap.get(key).toString());
//		}
		
		System.err.println(timeLong);
	}

}
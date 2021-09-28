package thedrivers.upbus.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thedrivers.upbus.domain.MileageUserList;
import thedrivers.upbus.mapper.MileageMapper;

@Service
@Transactional
public class MileageService {
	private static final Logger log = LoggerFactory.getLogger(MileageService.class);
	
	private final MileageMapper mileageMapper;
	
	public MileageService(MileageMapper mileageMapper) {
		this.mileageMapper = mileageMapper;
	}
	public List<MileageUserList> getMileageUserList(){
		List<MileageUserList> mileageUserList = mileageMapper.getMileageUserList();
		
		
		
		log.info("memberList : {}", mileageUserList);
		return mileageUserList;
	}
}

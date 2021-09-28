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
		
		for(int i = 0 ; i < mileageUserList.size() ; i++) {
			if(mileageUserList.get(i).getMileageUserListCancel() == 0) {
				mileageUserList.get(i).setMileageUserListCancelName("취소 안 됨");
			}else if(mileageUserList.get(i).getMileageUserListCancel() == 1) {
				mileageUserList.get(i).setMileageUserListCancelName("취소 됨");
			}
		}
		
		log.info("memberList : {}", mileageUserList);
		return mileageUserList;
	}
	public List<MileageUserList> getMileageUserList(String memberId){
		List<MileageUserList> mileageUserList = mileageMapper.getListById(memberId);
		
		for(int i = 0 ; i < mileageUserList.size() ; i++) {
			if(mileageUserList.get(i).getMileageUserListCancel() == 0) {
				mileageUserList.get(i).setMileageUserListCancelName("취소 안 됨");
			}else if(mileageUserList.get(i).getMileageUserListCancel() == 1) {
				mileageUserList.get(i).setMileageUserListCancelName("취소 됨");
			}
		}
		
		log.info("memberList : {}", mileageUserList);
		return mileageUserList;
	}
}

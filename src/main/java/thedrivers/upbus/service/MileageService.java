package thedrivers.upbus.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thedrivers.upbus.domain.MileageUserList;
import thedrivers.upbus.mapper.MileageMapper;

@Service
@Transactional
public class MileageService {
	private static final Logger log = LoggerFactory.getLogger(MileageService.class);
	
	private final MileageMapper mileageMapper;
	
	@Autowired
	public MileageService(MileageMapper mileageMapper) {
		this.mileageMapper = mileageMapper;
	}
	public int cancelMileageUserList(List<String> checkedCode){
		int cancelResult = mileageMapper.cancelMileageUserList(checkedCode);
		return cancelResult;		
	}
	
	public List<MileageUserList> getMileageUserList(){
		List<MileageUserList> mileageUserList = mileageMapper.getMileageUserList();		
		mileageUserList = changeField(mileageUserList);			
		log.info("mileageUserList : {}", mileageUserList);
		return mileageUserList;
	}
	
	//아이디를 기준으로 검색하게 하는 비즈니스 로직
	public List<MileageUserList> getMileageUserList(String memberId){
		List<MileageUserList> mileageUserList = mileageMapper.getMileageUserList(memberId);
		mileageUserList = changeField(mileageUserList);		
		log.info("mileageUserList : {}", mileageUserList);
		return mileageUserList;
	}
	
	//아이디와 마일리지 타입을 기준으로 검색하게 하는 비즈니스 로직
	public List<MileageUserList> getMileageUserList(String memberId, String MType){
		List<MileageUserList> mileageUserList = mileageMapper.getMileageUserList(memberId , MType);		
		mileageUserList = changeField(mileageUserList);
		log.info("mileageUserList : {}", mileageUserList);
		return mileageUserList;
		
	}
	
	//DB에서 가져온 데이터를 화면에 맞게 변경하는 메서드
	public List<MileageUserList> changeField(List<MileageUserList> mileageUserList){
		for(int i = 0 ; i < mileageUserList.size() ; i++) {
			//숫자로 된 취소 여부를 문자열로 변경
			if(mileageUserList.get(i).getMileageUserListCancel() == 0) {
				mileageUserList.get(i).setMileageUserListCancelName("취소 안 됨");
			}else if(mileageUserList.get(i).getMileageUserListCancel() == 1) {
				mileageUserList.get(i).setMileageUserListCancelName("취소 됨");
			}
			//적립 사용 여부를 영어에서 한글로 변경
			if(mileageUserList.get(i).getMileageUserListType().equals("accumulate")) {
				mileageUserList.get(i).setMileageUserListType("적립");
			} else if(mileageUserList.get(i).getMileageUserListType().equals("use")) {
				mileageUserList.get(i).setMileageUserListType("사용");
			}
		}
		return mileageUserList;
	}
}

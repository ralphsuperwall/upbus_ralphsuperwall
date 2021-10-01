package thedrivers.upbus.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import thedrivers.upbus.domain.MileageUserList;

@Mapper
public interface MileageMapper {
	public int cancelMileageUserList(List<String> checkedCode);
	
	public List<MileageUserList> getMileageUserList();

	public List<MileageUserList> getMileageUserList(String memberId);
	
	public List<MileageUserList> getMileageUserList(String memberId , String MType);
}

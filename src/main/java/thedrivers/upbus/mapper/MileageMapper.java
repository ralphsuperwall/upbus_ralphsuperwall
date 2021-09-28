package thedrivers.upbus.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import thedrivers.upbus.domain.MileageUserList;

@Mapper
public interface MileageMapper {
	public List<MileageUserList> getMileageUserList();

	public List<MileageUserList> getListById(String memberId);
}

package thedrivers.upbus.mapper;

import org.apache.ibatis.annotations.Mapper;
import thedrivers.upbus.domain.Shipping;

import java.util.List;

@Mapper
public interface ShippingMapper {

    public List<Shipping> getLogistics();
    public List<Shipping> getLogisticsContract(String logisticsContractCode);
}

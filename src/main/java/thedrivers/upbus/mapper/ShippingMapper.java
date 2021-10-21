package thedrivers.upbus.mapper;

import org.apache.ibatis.annotations.Mapper;
import thedrivers.upbus.domain.Shipping;

import java.util.List;

@Mapper
public interface ShippingMapper {

    List<Shipping> getLogistics();
    List<Shipping> getLogisticsContract(String logisticsContractCode);
    int renewContract(Shipping shipping);
    int newLogistics(Shipping shipping);
    String getLogisticsContractCode();
    int getExistingCode(String newLogisCode);
    int deleteLogistics(String logisticsCode);
}

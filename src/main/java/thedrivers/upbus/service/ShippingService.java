package thedrivers.upbus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thedrivers.upbus.domain.Shipping;
import thedrivers.upbus.mapper.ShippingMapper;

import java.util.List;

@Service
@Transactional
public class ShippingService {

    private static final Logger log = LoggerFactory.getLogger(thedrivers.upbus.service.GoodsService.class);

    private final ShippingMapper shippingMapper;

    public ShippingService(ShippingMapper shippingMapper) {
        this.shippingMapper = shippingMapper;
    }

    public List<Shipping> getLogistics() {
        return shippingMapper.getLogistics();
    }

    public List<Shipping> getLogisticsContract(String logisticsContractCode){
        return shippingMapper.getLogisticsContract(logisticsContractCode);
    }

    public int renewContract(Shipping shipping){
        return shippingMapper.renewContract(shipping);
    }

    public int newLogistics(Shipping shipping){
        return shippingMapper.newLogistics(shipping);
    }

    public String getLogisticsContractCode() {
        return shippingMapper.getLogisticsContractCode();
    }

    public int getExistingCode(String newLogisCode){
        return shippingMapper.getExistingCode(newLogisCode);
    }

    public int deleteLogistics(String logisticsCode){
        return shippingMapper.deleteLogistics(logisticsCode);
    }
}

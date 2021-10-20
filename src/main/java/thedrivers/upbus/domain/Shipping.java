package thedrivers.upbus.domain;

public class Shipping {

    private String logisticsCode;
    private String logisticsName;
    private String logisticsUpDate;
    private String logisticsContractCode;
    private String logisticsRenewDate;
    private int logisticsPer;
    private int logisticsStandard;
    private String logisticsBranch;
    private String logisticsPhone;
    private String logisticsCharge;
    private String logisticsIncharge;
    private String logisticsPaper;
    private int logisticsStatus;

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getLogisticsUpDate() {
        return logisticsUpDate;
    }

    public void setLogisticsUpDate(String logisticsUpDate) {
        this.logisticsUpDate = logisticsUpDate;
    }

    public String getLogisticsContractCode() {
        return logisticsContractCode;
    }

    public void setLogisticsContractCode(String logisticsContractCode) {
        this.logisticsContractCode = logisticsContractCode;
    }

    public String getLogisticsRenewDate() {
        return logisticsRenewDate;
    }

    public void setLogisticsRenewDate(String logisticsRenewDate) {
        this.logisticsRenewDate = logisticsRenewDate;
    }

    public int getLogisticsPer() {
        return logisticsPer;
    }

    public void setLogisticsPer(int logisticsPer) {
        this.logisticsPer = logisticsPer;
    }

    public int getLogisticsStandard() {
        return logisticsStandard;
    }

    public void setLogisticsStandard(int logisticsStandard) {
        this.logisticsStandard = logisticsStandard;
    }

    public String getLogisticsBranch() {
        return logisticsBranch;
    }

    public void setLogisticsBranch(String logisticsBranch) {
        this.logisticsBranch = logisticsBranch;
    }

    public String getLogisticsPhone() {
        return logisticsPhone;
    }

    public void setLogisticsPhone(String logisticsPhone) {
        this.logisticsPhone = logisticsPhone;
    }

    public String getLogisticsCharge() {
        return logisticsCharge;
    }

    public void setLogisticsCharge(String logisticsCharge) {
        this.logisticsCharge = logisticsCharge;
    }

    public String getLogisticsIncharge() {
        return logisticsIncharge;
    }

    public void setLogisticsIncharge(String logisticsIncharge) {
        this.logisticsIncharge = logisticsIncharge;
    }

    public String getLogisticsPaper() {
        return logisticsPaper;
    }

    public void setLogisticsPaper(String logisticsPaper) {
        this.logisticsPaper = logisticsPaper;
    }

    public int getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(int logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "logisticsCode='" + logisticsCode + '\'' +
                ", logisticsName='" + logisticsName + '\'' +
                ", logisticsUpDate='" + logisticsUpDate + '\'' +
                ", logisticsContractCode='" + logisticsContractCode + '\'' +
                ", logisticsRenewDate='" + logisticsRenewDate + '\'' +
                ", logisticsPer=" + logisticsPer +
                ", logisticsStandard=" + logisticsStandard +
                ", logisticsBranch='" + logisticsBranch + '\'' +
                ", logisticsPhone='" + logisticsPhone + '\'' +
                ", logisticsCharge='" + logisticsCharge + '\'' +
                ", logisticsIncharge='" + logisticsIncharge + '\'' +
                ", logisticsPaper='" + logisticsPaper + '\'' +
                ", logisticsStatus=" + logisticsStatus +
                '}';
    }
}

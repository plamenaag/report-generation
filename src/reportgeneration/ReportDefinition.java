package reportgeneration;


public class ReportDefinition {
    
    private Integer topPerformersThreshold;
    private Boolean useExprienceMultiplier;
    private Integer periodLimit;

    protected Integer getTopPerformersThreshold() {
        return topPerformersThreshold;
    }

    protected void setTopPerformersThreshold(Integer topPerformersThreshold) {
        this.topPerformersThreshold = topPerformersThreshold;
    }

    protected Boolean getUseExprienceMultiplier() {
        return useExprienceMultiplier;
    }

    protected void setUseExprienceMultiplier(Boolean useExprienceMultiplier) {
        this.useExprienceMultiplier = useExprienceMultiplier;
    }

    protected Integer getPeriodLimit() {
        return periodLimit;
    }

    protected void setPeriodLimit(Integer periodLimit) {
        this.periodLimit = periodLimit;
    }
}

package reportgeneration;

public class EmployeeStat {

    private String name;
    private Integer totalSales;
    private Integer salesPeriod;
    private Double experienceMultiplier;
    private Double score;

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected Integer getTotalSales() {
        return totalSales;
    }

    protected void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    protected Integer getSalesPeriod() {
        return salesPeriod;
    }

    protected void setSalesPeriod(Integer salesPeriod) {
        this.salesPeriod = salesPeriod;
    }

    protected Double getExperienceMultiplier() {
        return experienceMultiplier;
    }

    protected void setExperienceMultiplier(Double experienceMultiplier) {
        this.experienceMultiplier = experienceMultiplier;
    }

    protected Double getScore() {
        return score;
    }

    protected void setScore(Double score) {
        this.score = score;
    }

    public Double calculateScore(Boolean useExperienceMultiplier) {
        this.score = this.totalSales / this.salesPeriod * 1.0;

        if (useExperienceMultiplier!=null && useExperienceMultiplier) {
            this.score *= this.experienceMultiplier;
        }

        return this.score;
    }

    public String toCSV() {
        return this.name + ", " + this.score;
    }
}

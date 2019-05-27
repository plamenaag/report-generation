package reportgeneration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportGeneration {

    public static void main(String[] args) {

        String employeeStatFilePath = args[0];
        String reportDefinitionFilePath = args[1];
        String employeeStatContent;
        String reportDefContent;
        List<EmployeeStat> employeeStats;
        ReportDefinition reportDefinition;

        try {
            employeeStatContent = FileUtils.readFile(employeeStatFilePath);
            employeeStats = EmployeeStatUtils.deserialize(employeeStatContent);
        } catch (IOException ex) {
            System.err.println("Data file corrupted");
            return;
        }

        try {
            reportDefContent = FileUtils.readFile(reportDefinitionFilePath);
            reportDefinition = ReportDefUtils.deserialize(reportDefContent);
        } catch (IOException ex) {
            System.err.println("Report definition file corrupted");
            return;
        }

        String reportContent = prepareReportData(employeeStats, reportDefinition);
        System.out.println("Input full file name: ");
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();

        try {
            FileUtils.writeFile(reportContent, filePath);
        } catch (IOException ex) {
            System.err.println("Saving report file failed");
            return;
        }

    }

    public static String prepareReportData(List<EmployeeStat> employeeStats, ReportDefinition reportDefinition) {

        List<EmployeeStat> finalEmployeeStats = new ArrayList<>();
        Double maxScore = null;

        for (EmployeeStat employeeStat : employeeStats) {
            if (employeeStat.getSalesPeriod() <= reportDefinition.getPeriodLimit()) {
                employeeStat.calculateScore(reportDefinition.getUseExprienceMultiplier());
                finalEmployeeStats.add(employeeStat);
                if (maxScore == null || maxScore < employeeStat.getScore()) {
                    maxScore = employeeStat.getScore();
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append("Name , Score");
        sb.append(System.lineSeparator());
        for (EmployeeStat employeeStat : finalEmployeeStats) {
            if ((employeeStat.getScore() * 100) / maxScore >= 100 - reportDefinition.getTopPerformersThreshold()) {
                sb.append(employeeStat.toCSV());
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString();

    }
}

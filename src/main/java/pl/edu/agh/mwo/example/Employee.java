package pl.edu.agh.mwo.example;

import java.util.Date;

public class Employee {
        private String name;
        private String project;
        private Double hour;
        private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee(String name, String project, Double hour) {
            this.name = name;
            this.project = project;
            this.hour = hour;
            this.date = date;
        }

    public Employee(String name, String project, Double hour, Date date) {
        this.name = name;
        this.project = project;
        this.hour = hour;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Double getHour() {
        return hour;
    }

    public void setHour(Double hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", project='" + project + '\'' +
                ", hour=" + hour +
//                ", date=" + date +
                '}'+ "\n";
    }
}

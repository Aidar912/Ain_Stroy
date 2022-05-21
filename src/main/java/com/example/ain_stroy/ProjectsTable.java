package com.example.ain_stroy;

public class ProjectsTable {
    public String ProjectsName;
    public int ProjectsStatus;
    public String ProjectsDistrict;
    public int ProjectsApartment;
    public int ProjectsBudget;
    public String ProjectsTime;
    public String Description;

    public ProjectsTable(String projectsName, int projectsStatus, String projectsDistrict, int projectsApartment, int projectsBudget, String projectsTime, String description) {
        ProjectsName = projectsName;
        ProjectsStatus = projectsStatus;
        ProjectsDistrict = projectsDistrict;
        ProjectsApartment = projectsApartment;
        ProjectsBudget = projectsBudget;
        ProjectsTime = projectsTime;
        Description = description;
    }

    public String getProjectsName() {
        return ProjectsName;
    }

    public void setProjectsName(String projectsName) {
        ProjectsName = projectsName;
    }

    public int getProjectsStatus() {
        return ProjectsStatus;
    }

    public void setProjectsStatus(int projectsStatus) {
        ProjectsStatus = projectsStatus;
    }

    public String getProjectsDistrict() {
        return ProjectsDistrict;
    }

    public void setProjectsDistrict(String projectsDistrict) {
        ProjectsDistrict = projectsDistrict;
    }

    public int getProjectsApartment() {
        return ProjectsApartment;
    }

    public void setProjectsApartment(int projectsApartment) {
        ProjectsApartment = projectsApartment;
    }

    public int getProjectsBudget() {
        return ProjectsBudget;
    }

    public void setProjectsBudget(int projectsBudget) {
        ProjectsBudget = projectsBudget;
    }

    public String getProjectsTime() {
        return ProjectsTime;
    }

    public void setProjectsTime(String projectsTime) {
        ProjectsTime = projectsTime;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
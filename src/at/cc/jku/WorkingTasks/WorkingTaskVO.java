package at.cc.jku.WorkingTasks;

import java.sql.Date;
import java.sql.Time;

public class WorkingTaskVO {
    private int id;
    private EmployeeVO employeeVO;
    private ProjectVO projectVO;
    private ActivityVO activityVO;
    private String description;
    private Date date;
    private Time startTime;
    private Time endTime;

    public WorkingTaskVO(int id, EmployeeVO employeeVO, ProjectVO projectVO, ActivityVO activityVO, String description,
                         Date date, Time startTime, Time endTime) {
        this.id = id;
        this.employeeVO = employeeVO;
        this.projectVO = projectVO;
        this.activityVO = activityVO;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public EmployeeVO getEmployeeVO() {
        return employeeVO;
    }

    public void setEmployeeVO(EmployeeVO employeeVO) {
        this.employeeVO = employeeVO;
    }

    public ProjectVO getProjectVO() {
        return projectVO;
    }

    public void setProjectVO(ProjectVO projectVO) {
        this.projectVO = projectVO;
    }

    public ActivityVO getActivityVO() {
        return activityVO;
    }

    public void setActivityVO(ActivityVO activityVO) {
        this.activityVO = activityVO;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}

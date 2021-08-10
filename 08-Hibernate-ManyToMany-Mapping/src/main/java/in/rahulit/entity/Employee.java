package in.rahulit.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee_tbl")
public class Employee {
	
	@Id
	@Column(name="EmployeeId")
	private int eid;
	@Column(name="EmployeeName")
	private String employeename;
	@ManyToMany
	@JoinTable(                                            
			name="Em_Pr",
			joinColumns = {@JoinColumn(name="eId")},
			inverseJoinColumns = {@JoinColumn(name="pId")}
			)
	List<Project> projects;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	

}

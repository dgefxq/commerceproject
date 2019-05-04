/* 
This file definies the goal object and contains getters and setters for its defined data. 
*/

package sample9.demo9;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "goals")
public class goaldata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String goaltype;
	private Double goalamount;
	private String goalnote;
	private Double goalreward;
	private String goalstatus;
	private String accounttype;

	@UpdateTimestamp
	private Date createddate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate duedate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private userdata userid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGoaltype() {
		return goaltype;
	}

	public void setGoaltype(String goaltype) {
		this.goaltype = goaltype;
	}

	public Double getGoalamount() {
		return goalamount;
	}

	public void setGoalamount(Double goalamount) {
		this.goalamount = goalamount;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}

	public String getGoalnote() {
		return goalnote;
	}

	public void setGoalnote(String goalnote) {
		this.goalnote = goalnote;
	}

	public userdata getUserid() {
		return userid;
	}

	public void setUserid(userdata userid) {
		this.userid = userid;
	}

	public Double getGoalreward() {
		return goalreward;
	}

	public void setGoalreward(Double goalreward) {
		this.goalreward = goalreward;
	}

	public String getGoalstatus() {
		return goalstatus;
	}

	public void setGoalstatus(String goalstatus) {
		this.goalstatus = goalstatus;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
}
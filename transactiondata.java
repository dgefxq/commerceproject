package sample9.demo9;

import java.text.DecimalFormat;
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

@Entity
@Table(name = "transaction")

public class transactiondata {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String accounttype;

	private String accountnumber;

	@UpdateTimestamp
	private Date processingdate;

	private Double balance;

	private String crdr;

	private Double amount;

	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private userdata userid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Date getProcessingdate() {
		return processingdate;
	}

	public void setProcessingdate(Date processingdate) {
		this.processingdate = processingdate;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getCrdr() {
		return crdr;
	}

	public void setCrdr(String crdr) {
		this.crdr = crdr;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public userdata getUserid() {
		return userid;
	}

	public void setUserid(userdata userid) {
		this.userid = userid;
	}

}
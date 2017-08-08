package com.interview.config.admin.country.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
@Table(name="country")
public class Country implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	protected Date createdDate;
    protected long createdBy;
    protected Date updatedDate;
    protected long updatedBy;
    protected Long recordVersion = 0L;
    protected boolean logicallyDeleted = false;
    
	private String name;
	private String code;
	private boolean importStatus = false;
	private boolean exportStatus = false;
	private boolean transhipmentStatus = false;
	private String description;
	private Date effectiveDate;
	private Date expiryDate;	   
	private String cuscomRemarks;
	private String cuscomReferenceId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="ID", precision=19)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column()
	@Type(type="yes_no")
	public boolean isLogicallyDeleted() {
		return logicallyDeleted;
	}
	public void setLogicallyDeleted(boolean logicallyDeleted) {
		this.logicallyDeleted = logicallyDeleted;
	}
    
    @Column
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Version
    @Column(nullable = false)
	public Long getRecordVersion() {
		return recordVersion;
	}
	public void setRecordVersion(Long recordVersion) {
		this.recordVersion = recordVersion;
	}
	
	@Column
	public long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(length= 10)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column()
	@Type(type="yes_no")
	public boolean isExportStatus() {
		return exportStatus;
	}
	public void setExportStatus(boolean exportStatus) {
		this.exportStatus = exportStatus;
	}
	
	@Column()
	@Type(type="yes_no")
	public boolean isImportStatus() {
		return importStatus;
	}
	public void setImportStatus(boolean importStatus) {
		this.importStatus = importStatus;
	}
	
	@Column()
	@Type(type="yes_no")
	public boolean isTranshipmentStatus() {
		return transhipmentStatus;
	}
	public void setTranshipmentStatus(boolean transhipmentStatus) {
		this.transhipmentStatus = transhipmentStatus;
	}
	@Column(length = 100)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	
	@Column(length = 50)
	public String getCuscomRemarks() {
		return cuscomRemarks;
	}
	public void setCuscomRemarks(String cuscomRemarks) {
		this.cuscomRemarks = cuscomRemarks;
	}
	
	@Column
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	@Column
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Column(length = 50)
	public String getCuscomReferenceId() {
		return cuscomReferenceId;
	}
	public void setCuscomReferenceId(String cuscomReferenceId) {
		this.cuscomReferenceId = cuscomReferenceId;
	}	
}

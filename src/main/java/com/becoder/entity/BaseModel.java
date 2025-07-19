package com.becoder.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

	private Boolean isActive;

	private Boolean isDeleted;

	private Integer createdBy;

	private Date createdOn;

	private Integer updateBy;

	private Date updatedOn;

//	/**
//	 * @return the isActive
//	 */
//	public Boolean getIsActive() {
//		return isActive;
//	}
//
//	/**
//	 * @param isActive the isActive to set
//	 */
//	public void setIsActive(Boolean isActive) {
//		this.isActive = isActive;
//	}
//
//	/**
//	 * @return the isDeleted
//	 */
//	public Boolean getIsDeleted() {
//		return isDeleted;
//	}
//
//	/**
//	 * @param isDeleted the isDeleted to set
//	 */
//	public void setIsDeleted(Boolean isDeleted) {
//		this.isDeleted = isDeleted;
//	}
//
//	/**
//	 * @return the createdBy
//	 */
//	public Integer getCreatedBy() {
//		return createdBy;
//	}
//
//	/**
//	 * @param createdBy the createdBy to set
//	 */
//	public void setCreatedBy(Integer createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	/**
//	 * @return the createdOn
//	 */
//	public Date getCreatedOn() {
//		return createdOn;
//	}
//
//	/**
//	 * @param createdOn the createdOn to set
//	 */
//	public void setCreatedOn(Date createdOn) {
//		this.createdOn = createdOn;
//	}
//
//	/**
//	 * @return the updateBy
//	 */
//	public Integer getUpdateBy() {
//		return updateBy;
//	}
//
//	/**
//	 * @param updateBy the updateBy to set
//	 */
//	public void setUpdateBy(Integer updateBy) {
//		this.updateBy = updateBy;
//	}
//
//	/**
//	 * @return the updatedOn
//	 */
//	public Date getUpdatedOn() {
//		return updatedOn;
//	}
//
//	/**
//	 * @param updatedOn the updatedOn to set
//	 */
//	public void setUpdatedOn(Date updatedOn) {
//		this.updatedOn = updatedOn;
//	}
//	
	
}

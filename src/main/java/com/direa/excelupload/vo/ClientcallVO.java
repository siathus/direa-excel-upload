package com.direa.excelupload.vo;

import lombok.Data;

@Data
public class ClientcallVO {
	private String callSeq;
	private String callDate;
	private String siteCode;
	private String siteName;
	private String clientName;				//고객요청자
	private String receiverName;			//최초등록자
	private String callType;				//접수유형
	private String solutionType;			//솔루션구분
	private String riskLevel;				//긴급도
	private String receivedContents;		//접수내용
	private String situation;				//발생현상
	private String occurredTime;			//발생시각
	private String currentStatus;			//현재상황
	private String additionalSupport;		//추가지원여부

	public String getCallSeq() {
		return callSeq;
	}

	public void setCallSeq(String callSeq) {
		this.callSeq = callSeq;
	}

	public String getCallDate() {
		return callDate;
	}

	public void setCallDate(String callDate) {
		this.callDate = callDate;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getSolutionType() {
		return solutionType;
	}

	public void setSolutionType(String solutionType) {
		this.solutionType = solutionType;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getReceivedContents() {
		return receivedContents;
	}

	public void setReceivedContents(String receivedContents) {
		this.receivedContents = receivedContents;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getOccurredTime() {
		return occurredTime;
	}

	public void setOccurredTime(String occurredTime) {
		this.occurredTime = occurredTime;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getAdditionalSupport() {
		return additionalSupport;
	}

	public void setAdditionalSupport(String additionalSupport) {
		this.additionalSupport = additionalSupport;
	}
}

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
	
}

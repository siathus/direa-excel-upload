package com.direa.excelupload.elastic;

import java.util.List;

import com.direa.excelupload.CustomException;
import com.direa.excelupload.vo.ClientcallVO;
import com.direa.excelupload.vo.CommuteVO;

public interface ElasticAPI {
	/**
	 * 출결기록 데이터 입력
	 * @param list 엑셀 내 라인단위의 vo를 모음
	 * @return
	 */
	public boolean putCommuteIndex(List<CommuteVO> list) throws CustomException;
	
	/**
	 * 콜접수 데이터 입력
	 * 
	 * @param vo 주석처리되어 있는 값만 입력해서 파라미터보내명 됨
	 * @return
	 */
	public boolean putClientcallIndex(ClientcallVO vo)throws CustomException;
}

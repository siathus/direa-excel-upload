package com.direa.excelupload.elastic;

import java.util.List;

import com.direa.excelupload.CustomException;
import com.direa.excelupload.vo.ClientcallVO;
import com.direa.excelupload.vo.CommuteVO;
import org.springframework.stereotype.Service;

@Service
public class ElasticAPIImpl implements ElasticAPI {

	@Override
	public boolean putCommuteIndex(List<CommuteVO> list) throws CustomException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putClientcallIndex(ClientcallVO vo) throws CustomException {
		// TODO Auto-generated method stub
		return false;
	}

}

package service;

import java.util.List;

import dao.WorKingMapper;
import entity.Working;
import util.MyBatisUtil;

public class WorkingService {

  WorKingMapper worKingMapper=MyBatisUtil.createSqlSession().getMapper(WorKingMapper.class);

	public List<Working> getList(){
		return worKingMapper.getList();
	}

	public int getCount(String title){
		return worKingMapper.getCount(title);
	}

	public Working getWorking(int id){
		return worKingMapper.getWorking(id);
	}

	public int save(Working w){
		return worKingMapper.save(w);
	}

	public List<Working> getListPage(int currPageNo,int pageSize){
		int beginIndex = (currPageNo-1)*pageSize;
		return worKingMapper.getListPage(beginIndex,pageSize);
	}

	public int getTotalCount(){
		return worKingMapper.getTotalCount();
	}
}

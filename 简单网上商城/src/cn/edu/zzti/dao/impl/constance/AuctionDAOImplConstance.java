package cn.edu.zzti.dao.impl.constance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zzti.dao.AuctionDAO;
import cn.edu.zzti.entity.Auction;

public class AuctionDAOImplConstance implements AuctionDAO{
	private static Map<String,Auction> auctionList = new HashMap<String,Auction>();

	static{
		for(int i=0;i<20;i++){
			Auction auc = new Auction("商品"+i,"description"+i,100+(int)(Math.random()*100));
			auctionList.put("商品"+i,auc);
		}
	}
	@Override
	public Auction getAuction(String id) {
		return auctionList.get(id);
	}

	@Override
	public void addAuction(Auction auc) {
		auctionList.put(auc.getId(),auc);
	}

	@Override
	public List<Auction> getAll() {
		return new ArrayList<Auction>(auctionList.values());
	}
}

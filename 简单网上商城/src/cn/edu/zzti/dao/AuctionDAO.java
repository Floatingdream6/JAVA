package cn.edu.zzti.dao;

import cn.edu.zzti.entity.Auction;

import java.util.List;

/**
 * 商品操作
 * Created by guoli on 17/5/14.
 */
public interface AuctionDAO {
	/**
	 * 根据id获取某个商品信息
	 * @param id
	 * @return
	 */
    public Auction getAuction(String id);
    /**
     * 添加一个商品
     * @param auc
     */
    public void addAuction(Auction auc);
    /**
     * 获取全部商品
     * @return
     */
    public List<Auction> getAll();

}

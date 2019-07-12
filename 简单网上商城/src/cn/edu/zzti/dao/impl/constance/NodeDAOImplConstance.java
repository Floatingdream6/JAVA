package cn.edu.zzti.dao.impl.constance;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zzti.dao.NodeDAO;
import cn.edu.zzti.dao.ReplyDAO;
import cn.edu.zzti.dao.UserDAO;
import cn.edu.zzti.entity.Node;
import cn.edu.zzti.entity.User;

public class NodeDAOImplConstance implements NodeDAO{
	private static UserDAO userDAO = new UserDAOImplConstance();
	private static ReplyDAO repltDAO = new ReplyDAOImplConstance();
	private static Map<Integer,Node> nodeList = new HashMap<Integer,Node>();
	private static int maxId=0;//每插入一条数据，maxid+1，删除记录不用修改该值，该值持续增长，类似于数据库的自增长id
	static{
		for(int i=0;i<10;i++){
			User u =userDAO.getUserByName("admin0");
			Node node = new Node("admin0发布的帖子的标题"+i,
					u,
					new Date(new Date().getTime()+(i*100000))
					,0);
			maxId++;
			node.setId(maxId);
			nodeList.put(maxId, node);
		}
	}
	@Override
	public List<Node> getAllNodes() {
		
		return new ArrayList<Node>(nodeList.values());
	}
	@Override
	public void addNode(Node node) {
		maxId++;
		node.setId(maxId);
		nodeList.put(maxId, node);
		
	}
	@Override
	public void deleteNode(int nodeId) {
		Node node = nodeList.remove(nodeId);
		repltDAO.deleteReplyByNodeId(node.getId());
	}
	@Override
	public Node getNodeById(int nodeId) {
		Node node = nodeList.get(nodeId);
		
		return node;
	}

}

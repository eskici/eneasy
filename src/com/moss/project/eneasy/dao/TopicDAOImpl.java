package com.moss.project.eneasy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moss.project.eneasy.model.Topic;
import com.moss.project.eneasy.model.UserEntity;
import com.moss.project.eneasy.util.MyConstants;

public class TopicDAOImpl extends HibernateDaoSupport implements MyConstants{

	@SuppressWarnings("unchecked")
	public List<Topic> readLastTopics(){
		Criteria criteria = getSession().createCriteria(Topic.class);
		criteria.setMaxResults(50);
		criteria.add(Expression.eq("status", STATUS_APPROVE));
		criteria.createAlias("entries", "entry");
		criteria.add(Expression.eq("entry.status", STATUS_APPROVE));		
		criteria.addOrder(Order.asc("lastChangeDate"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Topic> readWaitingTopics(){
		Criteria criteria = getSession().createCriteria(Topic.class);
		criteria.add(Expression.eq("status", STATUS_WAITING));
		criteria.addOrder(Order.asc("lastChangeDate"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Topic> readMyTopics(UserEntity user){
		Criteria criteria = getSession().createCriteria(Topic.class);
		criteria.add(Expression.eq("status", STATUS_APPROVE));
		criteria.addOrder(Order.asc("lastChangeDate"));
		criteria.createAlias("entries", "entry");
		criteria.add(Expression.eq("entry.createdBy", user));
		 criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	
	public Topic readTopic(String objid){
		return (Topic) getHibernateTemplate().get(Topic.class, objid);
	}
	
	public void addNewTopic(Topic topic){
		try{
		getHibernateTemplate().persist(topic);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateTopic(Topic topic){
		getHibernateTemplate().update(topic);
	}
	
//	public List<Topic> searchTopic(String title){
//		 	Session session = getSession();
////			create a full text session
//			FullTextSession fSession = Search.getFullTextSession(session);
//			fSession.beginTransaction();
////			create a luceneQuery with a parser
//			QueryParser parser = new QueryParser(Version.LUCENE_20, title, new StandardAnalyzer(Version.LUCENE_20));
//			Query lucenceQuery = null;
//			try {
//				lucenceQuery = parser.parse("content:hibernate");
//
//			} catch (ParseException e) {
//				throw new RuntimeException("Cannot search with query string",e);
//			}
////			execute the query
//			List<Topic> topics = fSession.createFullTextQuery( new TermQuery(new Term("name", title)), Topic.class).list();
//			fSession.getTransaction().commit();
//			return topics;
//	}
//	
//    public List<Topic> searchByKeyword(String keyword) {
//        BooleanQuery booleanQuery = new BooleanQuery();
//        booleanQuery.add( new PrefixQuery( new Term( "name", keyword ) ), BooleanClause.Occur.SHOULD );
////        booleanQuery.add( new PrefixQuery( new Term( "message", keyword ) ), BooleanClause.Occur.SHOULD );
//        org.hibernate.Query fullTextQuery = getFullTextSession().createFullTextQuery(booleanQuery, Topic.class);
//        return fullTextQuery.list();
//        
//    }
//
//      public FullTextSession getFullTextSession() {
//        Session session = getSession();
//        FullTextSession fullTextSession = Search.createFullTextSession(session);
//        return fullTextSession;
//    }  	
    
}
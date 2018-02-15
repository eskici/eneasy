package com.moss.project.eneasy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moss.project.eneasy.model.Entry;
import com.moss.project.eneasy.model.UserEntity;
import com.moss.project.eneasy.util.MyConstants;

public class EntryDAOImpl extends HibernateDaoSupport implements MyConstants{

	@SuppressWarnings("unchecked")
	public List<Entry> readLastEntrys(){
		Criteria criteria = getSession().createCriteria(Entry.class);
		criteria.setMaxResults(50);
		criteria.addOrder(Order.asc("lastChangeDate"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Entry> readWaitingEntrys(){
		Criteria criteria = getSession().createCriteria(Entry.class);
		criteria.add(Expression.eq("status", STATUS_WAITING));
		criteria.addOrder(Order.asc("lastChangeDate"));
		return criteria.list();
	}
	
	public Entry readEntry(String objid){
		return (Entry) getHibernateTemplate().get(Entry.class, objid);
	}
	
	public void addNewEntry(Entry entry){
		try{
		getHibernateTemplate().persist(entry);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateEntry(Entry entry){
		getHibernateTemplate().update(entry);
	}
	
//	public List<Entry> searchEntry(String title){
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
//			List<Entry> entrys = fSession.createFullTextQuery( new TermQuery(new Term("name", title)), Entry.class).list();
//			fSession.getTransaction().commit();
//			return entrys;
//	}
	
	@SuppressWarnings("unchecked")
	public List<Entry> readMyEntries(UserEntity user){
		Criteria criteria = getSession().createCriteria(Entry.class);
		criteria.add(Expression.eq("createdBy", user));
		criteria.add(Expression.eq("status", STATUS_APPROVE));
		criteria.addOrder(Order.asc("lastChangeDate"));
		return criteria.list();
	}	
}

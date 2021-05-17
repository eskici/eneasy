package com.moss.project.eneasy.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moss.project.eneasy.model.UserEntity;
import com.moss.project.eneasy.util.MyConstants;

public class UserDAO extends HibernateDaoSupport implements MyConstants{

	@SuppressWarnings("unchecked")
	public UserEntity findByName(String username){
		return (UserEntity) getHibernateTemplate().get(UserEntity.class, username);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserEntity> readLastUserEntitys(){
		Criteria criteria = getSession().createCriteria(UserEntity.class);
		criteria.setMaxResults(50);
		criteria.addOrder(Order.asc("lastChangeDate"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<UserEntity> readWaitingUserEntitys(){
		Criteria criteria = getSession().createCriteria(UserEntity.class);
		criteria.add(Expression.eq("status", STATUS_WAITING));
		criteria.addOrder(Order.asc("lastChangeDate"));
		return criteria.list();
	}
	
	public UserEntity readUserEntity(String objid){
		return (UserEntity) getHibernateTemplate().get(UserEntity.class, objid);
	}
	
	public void addNewUserEntity(UserEntity topic){
		try{
		getHibernateTemplate().persist(topic);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateUserEntity(UserEntity topic){
		getHibernateTemplate().update(topic);
	}	

}

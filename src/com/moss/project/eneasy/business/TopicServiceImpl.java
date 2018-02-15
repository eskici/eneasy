package com.moss.project.eneasy.business;

import java.util.List;

import org.compass.core.CompassDetachedHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.annotation.Secured;

import com.moss.project.eneasy.dao.EntryDAOImpl;
import com.moss.project.eneasy.dao.TopicDAOImpl;
import com.moss.project.eneasy.dao.TopicSearchDAO;
import com.moss.project.eneasy.model.Entry;
import com.moss.project.eneasy.model.Topic;
import com.moss.project.eneasy.util.MyConstants;

public class TopicServiceImpl extends BaseServiceImpl implements ITopicService,MyConstants{

	@Autowired
	private TopicDAOImpl topicDAO;
	@Autowired
	private TopicSearchDAO topicSearchDAO;	
	@Autowired
	private EntryDAOImpl entryDAO;
	
	public List<Topic> readLastTopics() {
		// TODO Auto-generated method stub
		return topicDAO.readLastTopics();
	}

	@Secured( {"ROLE_ADMIN"} )
	public void approveTopic(String objid) {
		// TODO Auto-generated method stub
		Topic topic = topicDAO.readTopic(objid);
		topic.setStatus("ON");
		topicDAO.updateTopic(topic);		
	}

	 @Secured( {"ROLE_ADMIN"} )
	public void cancelTopic(String objid) {
		// TODO Auto-generated method stub
		Topic topic = topicDAO.readTopic(objid);
		topic.setStatus("IP");
		topicDAO.updateTopic(topic);
	}
	 
	 @Secured( {"ROLE_ADMIN","ROLE_USER"} )
	public void addNewTopic(String name,String content) {
		// TODO Auto-generated method stub
		Topic topic = new Topic();
		topic.setName(name);
		topic.setStatus(STATUS_WAITING);
		topic.setCreatedBy(getCurrentUser());
		topicDAO.addNewTopic(topic);
		
		Entry entry = new Entry();
		entry.setContent(content);
		entry.setTopic(topic);
		entry.setStatus(STATUS_WAITING);
		entry.setCreatedBy(getCurrentUser());
		entryDAO.addNewEntry(entry);
		
	}

	public Topic readTopic(String objid) {
		// TODO Auto-generated method stub
		return topicDAO.readTopic(objid);
	}

	public List<Topic> readWaitingTopics() {
		// TODO Auto-generated method stub
		return topicDAO.readWaitingTopics();
	}

	public CompassDetachedHits searchTopic(String title) {
		// TODO Auto-generated method stub
		return topicSearchDAO.find(title);
	}
	 @Secured( {"ROLE_USER"} )
	public List<Topic> readMyTopics() {
		// TODO Auto-generated method stub
		return topicDAO.readMyTopics(getCurrentUser());
	}
	

	public TopicDAOImpl getTopicDAO() {
		return topicDAO;
	}

	public void setTopicDAO(TopicDAOImpl topicDAO) {
		this.topicDAO = topicDAO;
	}	
}

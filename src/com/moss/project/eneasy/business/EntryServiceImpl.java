package com.moss.project.eneasy.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.annotation.Secured;

import com.moss.project.eneasy.dao.EntryDAOImpl;
import com.moss.project.eneasy.dao.TopicDAOImpl;
import com.moss.project.eneasy.model.Entry;
import com.moss.project.eneasy.model.Topic;
import com.moss.project.eneasy.util.MyConstants;

public class EntryServiceImpl extends BaseServiceImpl implements IEntryService,MyConstants{

	@Autowired
	private EntryDAOImpl entryDAO;
	@Autowired
	private TopicDAOImpl topicDAO;
	
	public List<Entry> readLastEntrys() {
		// TODO Auto-generated method stub
		return entryDAO.readLastEntrys();
	}

	@Secured( {"ROLE_ADMIN"} )
	public void approveEntry(String objid) {
		// TODO Auto-generated method stub
		Entry entry = entryDAO.readEntry(objid);
		entry.setStatus("ON");
		entryDAO.updateEntry(entry);		
	}

	@Secured( {"ROLE_ADMIN"} )
	public void cancelEntry(String objid) {
		// TODO Auto-generated method stub
		Entry entry = entryDAO.readEntry(objid);
		entry.setStatus("IP");
		entryDAO.updateEntry(entry);
	}

	public Entry readEntry(String objid) {
		// TODO Auto-generated method stub
		return entryDAO.readEntry(objid);
	}

	@Secured( {"ROLE_ADMIN"} )
	public List<Entry> readWaitingEntrys() {
		// TODO Auto-generated method stub
		return entryDAO.readWaitingEntrys();
	}

	@Secured( {"ROLE_ADMIN,ROLE_USER"} )
	public void addNewEntry(Topic topic, String content) {
		// TODO Auto-generated method stub
		Entry entry = new Entry();
		entry.setContent(content);
		entry.setTopic(topic);
		entry.setStatus(STATUS_WAITING);
		entry.setCreatedBy(getCurrentUser());
		entryDAO.addNewEntry(entry);
		
		topic.setLastChangeDate(new Date());
		topicDAO.updateTopic(topic);
	}

	@Secured( {"ROLE_ADMIN,ROLE_USER"} )
	public List<Entry> readMyEntries() {
		// TODO Auto-generated method stub
		return entryDAO.readMyEntries(getCurrentUser());
	}

	@Secured( {"ROLE_ADMIN,ROLE_USER"} )
	public void updateEntry(String objid, String content) {
		// TODO Auto-generated method stub
		Entry entry = entryDAO.readEntry(objid);
		entry.setContent(content);
		entryDAO.updateEntry(entry);
	}


	public EntryDAOImpl getEntryDAO() {
		return entryDAO;
	}

	public void setEntryDAO(EntryDAOImpl entryDAO) {
		this.entryDAO = entryDAO;
	}
}

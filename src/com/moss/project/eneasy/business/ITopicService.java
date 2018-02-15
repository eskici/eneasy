package com.moss.project.eneasy.business;

import java.util.List;

import org.compass.core.CompassDetachedHits;

import com.moss.project.eneasy.model.Topic;

public interface ITopicService {
	List<Topic> readLastTopics();
	void approveTopic(String objid);
	void cancelTopic(String objid);
	void addNewTopic(String name,String content);
	Topic readTopic(String objid);
	List<Topic> readWaitingTopics();
	public CompassDetachedHits searchTopic(String title);
	public List<Topic> readMyTopics();
}

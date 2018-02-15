package com.moss.project.eneasy.business;

import java.util.List;

import com.moss.project.eneasy.model.Entry;
import com.moss.project.eneasy.model.Topic;

public interface IEntryService {
	List<Entry> readLastEntrys();
	void approveEntry(String objid);
	void cancelEntry(String objid);
	void addNewEntry(Topic topic, String name);
	Entry readEntry(String objid);
	List<Entry> readWaitingEntrys();
	List<Entry> readMyEntries();
	void updateEntry(String objid, String content);
}

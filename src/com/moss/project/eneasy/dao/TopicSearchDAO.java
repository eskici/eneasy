package com.moss.project.eneasy.dao;

import org.compass.core.CompassCallback;
import org.compass.core.CompassDetachedHits;
import org.compass.core.CompassSession;
import org.compass.spring.CompassDaoSupport;

import com.moss.project.eneasy.util.MyConstants;

public class TopicSearchDAO extends CompassDaoSupport implements MyConstants{
      
      public CompassDetachedHits find(final String query) {  
          return (CompassDetachedHits)getCompassTemplate().execute(  
              new CompassCallback() {  
                  public Object doInCompass(CompassSession session) {  
                      return session.find(query).detach();  
                  }  
              }  
          );  
      }        
}
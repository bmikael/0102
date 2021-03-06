package com.amlm.honeygogroceryshopping.dataaccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONException;

import com.amlm.honeygogroceryshopping.interfaces.IGroceryFile;

public abstract class BaseGroceryFile implements IGroceryFile {

	private  String _fileName; // name of the grocery file - does not change  
	private  Boolean _shared; // indicates if file is shared across household members
	private String _revision; // the revsion of the in-memory GroceryFile
	private String _storeName; // the name of the store this file is for
	//private DropboxAPI<AndroidAuthSession> _dbapi = null;
	private boolean _saveToDbPending = false; // a save to the file was needed that also needed to be saved in db,
	  // was not available, so a save needs to be done when we are connected again
	private boolean _dbRevNeedsUpdating = false; // we downloaded a revision from dropbox, need to save settings  
	 

	@Override
	public String getFileName() {
		return _fileName;
	}	
	@Override 
	public String getRevision() {return _revision;}
	
	@Override
	public void setRevision(String rev)
	{
		_revision= rev;
	}


	@Override
	public Boolean getDBRevNeedsUpdating() { return _dbRevNeedsUpdating; }
	@Override
	public void setDBRevNeedsUpdating(Boolean value) { _dbRevNeedsUpdating = value;}

	@Override
	public Boolean isShared() {return _shared;}
	
	@Override
	public void init(/*DropboxAPI<AndroidAuthSession> api,*/ String sn, String filename, Boolean shared)
	{
		_storeName = sn;
		_fileName = filename;
		_shared = shared;
		// _dbapi = api;
		//_revision= rev;
	}
	@Override
	public String getStoreName() {return _storeName;}


	@Override
	public File getFile() {
		// TODO Auto-generated method stub
		return GroceryFile.getFile(this);
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean revisionsMatch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void syncWithDropbox() throws FileNotFoundException, IOException,
			JSONException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDbPath()
    {
    	//return String.format("%s\\%s\\%s", "dropbox", getStoreName(), getFileName());
    	return String.format("/%s/%s",  getStoreName(), getFileName());
    }
	
	@Override
	public String getRevisionKey() { return getStoreName().replaceAll("\\s","")+ "_" + getFileName();}

	@Override
	public String getDbPendingKey( )
    {
    	return getStoreName().replaceAll("\\s","")+ "_" + getFileName() + "_sp";
    }		  	    
	    
	
	protected void setSaveToDbPending(boolean value)
    {
    	_saveToDbPending= value;
    }
	
	@Override
	public boolean getSaveToDbPending()
    {
    	return _saveToDbPending;
    }
	/* protected DropboxAPI<AndroidAuthSession> getDbApi() {
			// TODO Auto-generated method stub
			return _dbapi;
		}
	*/

}

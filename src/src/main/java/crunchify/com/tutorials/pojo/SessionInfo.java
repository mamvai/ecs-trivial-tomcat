/*
**  Common
**
**  $Header: /its/cvsroot/OEPA/ApplicationPortal/us/oh/state/epa/aport/web/SessionInfo.java,v 1.3 2007/07/17 14:30:04 jbrownlee Exp $
*/
package crunchify.com.tutorials.pojo;

import java.io.Serializable;
import java.util.Calendar;



/**
**  This class represents an entry within the Session Manager's table.
**
**  @author  Joe Brownlee
**  @version 1.0
*/
public class SessionInfo implements Serializable  {
    //  Attributes.

    private String   itsSessionID;
    private User     itsUserObject  = null;
    private String   itsHostName    = null;
    private String   itsServerName  = null;
    private Calendar itsLastAccess  = null;
    private Duration itsTimeout     = null;

    /**
    **  Create a session information object.
    **
    **  @param  session_id     The session ID for this session.
    **  @param  user_object    The <B>User</B> object for this session.
    **  @param  host_name      The host name to which this session applies.
    **  @param  server_name    The application server name to which this session applies.
    **  @param  timeout        The time duration until this entry times out.
    */
    
    public SessionInfo() {
		// TODO Auto-generated constructor stub
    	itsSessionID = "My Custom Session ID";
    	itsUserObject = new User();
    	itsLastAccess = Calendar.getInstance();
	}
    
    public SessionInfo(String session_id, User user_object, String host_name, String server_name, Duration timeout) {
        itsSessionID     = session_id;
        itsHostName      = host_name;
        itsServerName    = server_name;
        itsUserObject    = user_object;
        itsLastAccess    = Calendar.getInstance();
        // itsTimeout       = (Duration) timeout.clone();
    }

    //  Accessors.

    

	/**
    **  Get the session ID of this session.
    **
    **  @return   The session ID of this session.
    */
    public String getSessionID()  {
        return itsSessionID;
    }

    /**
    **  Get the user object associated with this session.
    **
    **  @return   The user object associated with this session.
    */
    public User getUserObject()  {
        return itsUserObject;
    }

    /**
    **  Get the host name associated with this session.
    **
    **  @return   The host name associated with this session.
    */
    public String getHostName()  {
        return itsHostName;
    }

    /**
    **  Get the application server name associated with this session.
    **
    **  @return   The application server name associated with this session.
    */
    public String getServerName()  {
        return itsServerName;
    }

    /**
    **  Get the login name of the user associated with this session.
    **
    **  @return   The login name of the user associated with this session.
    */
    public String getLoginName()  {
        return itsUserObject != null ? itsUserObject.getName() : "<none>";
    }

    /**
    **  Get the full name of the user associated with this session.
    **
    **  @return   The full name of the user associated with this session.
    */
    public String getFullName()  {
        return itsUserObject != null ? itsUserObject.getFullName() : "<none>";
    }

    /**
    **  The time until this user's entry times out in milliseconds.
    **
    **  @return   The time until this user's entry times out in milliseconds.
    */
    public Duration getTimeout()  {
        return itsTimeout;
    }
    
    /**
    **  Return the last time the user's session was accessed.
    **
    **  @return   The last time the user's session was accessed.
    */
    public Calendar getLastAccess()  {
        return itsLastAccess;
    }

    /**
    **  Return whether this session has an associated user object.
    **
    **  @return   Returns <b>true</B> if this session has a user object
    **            associated with it.
    */
    public boolean hasUserObject()  {
        return (itsUserObject != null);
    }

    /**
    **  Return whether this session has an associated host name.
    **
    **  @return   Returns <b>true</B> if this session has a host name
    **            associated with it.
    */
    public boolean hasHostName()  {
        return (itsHostName != null);
    }

    /**
    **  Return whether this session has an associated application server name.
    **
    **  @return   Returns <b>true</B> if this session has a application server
    **            name associated with it.
    */
    public boolean hasServerName()  {
        return (itsServerName != null);
    }
    
    /**
    **  Update the access time of this record to the current time.
    */
    public void access()  {
        itsLastAccess = Calendar.getInstance();
    }
    
    /**
    **  Determine if this session entry has timed out.
    **
    **  @return   Returns <B>true</B> if this session has timed out.
    */
    public boolean hasTimedOut()  {
        //  The session has timed out if the timeout interval is less then the
        //  interval since last access.

        return itsTimeout.lessThan(
            Calendar.getInstance().getTimeInMillis() - itsLastAccess.getTimeInMillis()
        );
    }
    
    /**
    **  Compare a session ID to this entry.
    **
    **  @param  session_id    A session ID to compare to this session information.
    **
    **  @return               Returns <B>true</B> if the session ID matches the one in
    **                        this object.
    */
    public boolean equals(String session_id)  {
        return itsSessionID.equals(session_id);
    }
    
    /**
    **  Compare a session to this one.
    **
    **  @param  info    Session information to compare to this object.
    **
    **  @return         Returns <B>true</B> if the session ID matches the one in this object.
    */
    public boolean equals(SessionInfo info)  {
        return itsSessionID.equals(info.itsSessionID);
    }
    
    /**
    **  Create an independent copy of a <B>SessionInfo</B> object.
    **
    **  @return         Returns <B>true</B> if the session ID matches the one in this object.
    */
    public Object clone()  {
        SessionInfo info = new SessionInfo(
            new String(itsSessionID),
            itsUserObject,
            new String(itsHostName),
            new String(itsServerName),
            itsTimeout
        );
        
        info.itsLastAccess = (Calendar) itsLastAccess.clone();
        
        return info;
    }

    /**
    **  Provide a printable version of the session information, primarily
    **  for logging or debugging.
    **
    **  @return    A printable version of this object.
    */
    public String toString()  {
        StringBuffer sb = new StringBuffer(150);
        sb.append("[SessionInfo: ID=\"");
        sb.append(getSessionID() == null ? "<null>" : getSessionID());
        sb.append("\", User=");
        sb.append(hasUserObject() ? getUserObject().toString() : "<null>");
        sb.append(", HostName=");
        sb.append(itsHostName == null ? "<null>" : itsHostName);
        sb.append(", ServerName=");
        sb.append(itsServerName == null ? "<null>" : itsServerName);
        sb.append(", LastAccess=");
        //sb.append(itsLastAccess == null ? "<null>" : DateUtils.toString(itsLastAccess));
        sb.append(", Timeout=");
        sb.append(itsTimeout == null ? "<null>" : itsTimeout.toString());
        sb.append("]");

        return sb.toString();
    }
}
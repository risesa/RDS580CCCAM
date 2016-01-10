package com.AngelBarreraSanchez.ccam;

/**
 * The entity representing a cline
 * @author Angel Barrera Sanchez
 */
public class CCCAMEntity {
	/** Host */
	private String host;
	/** Port */
	private String port;
	/** User */
	private String user;
	/** Pass */
	private String pass;
	/** Hops */
	private String hops;
	
	/**
	 * @param host
	 * @param port
	 * @param user
	 * @param pass
	 * @param hops
	 */
	public CCCAMEntity(String host, String port, String user, String pass, String hops) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.pass = pass;
		this.hops = hops;
	}
	
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**
	 * @return the hops
	 */
	public String getHops() {
		return hops;
	}
	/**
	 * @param hops the hops to set
	 */
	public void setHops(String hops) {
		this.hops = hops;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hops == null) ? 0 : hops.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CCCAMEntity other = (CCCAMEntity) obj;
		if (hops == null) {
			if (other.hops != null)
				return false;
		} else if (!hops.equals(other.hops))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CCAMEntity [" + (host != null ? "host=" + host + ", " : "")
				+ (port != null ? "port=" + port + ", " : "") + (user != null ? "user=" + user + ", " : "")
				+ (pass != null ? "pass=" + pass + ", " : "") + (hops != null ? "hops=" + hops : "") + "]";
	}
}
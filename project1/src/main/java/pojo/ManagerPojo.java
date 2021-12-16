package pojo;

public class ManagerPojo {

	private int mgrId;
	private String mgrName;
	private String mgrAddress;

	public ManagerPojo() {
		super();
	}

	public ManagerPojo(int mgrId, String mgrName, String mgrAddress) {
		super();
		this.mgrId = mgrId;
		this.mgrName = mgrName;
		this.mgrAddress = mgrAddress;

	}

	public int getMgrId() {
		return mgrId;
	}

	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}

	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	public String getMgrAddress() {
		return mgrAddress;
	}

	public void setMgrAddress(String mgrAddress) {
		this.mgrAddress = mgrAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mgrAddress == null) ? 0 : mgrAddress.hashCode());
		result = prime * result + mgrId;
		result = prime * result + ((mgrName == null) ? 0 : mgrName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManagerPojo other = (ManagerPojo) obj;
		if (mgrAddress == null) {
			if (other.mgrAddress != null)
				return false;
		} else if (!mgrAddress.equals(other.mgrAddress))
			return false;
		if (mgrId != other.mgrId)
			return false;
		if (mgrName == null) {
			if (other.mgrName != null)
				return false;
		} else if (!mgrName.equals(other.mgrName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ManagerPojo [mgrId=" + mgrId + ", mgrName=" + mgrName + ", mgrAddress=" + mgrAddress + "]";
	}

}

package pojo;

public class ReimbursmentPojo {
	private int rbId;
	private int empId;
	private int mgrId;
	private int rbAmount;
	private String rbStatus;
	
	public ReimbursmentPojo() {
		super();
	}
	
	public ReimbursmentPojo(int rbId,int empId, int mgrId, int rbAmount, String rbStatus) {
		super();
		this.rbId = rbId;
		this.empId = empId;
		this.mgrId = mgrId;
		this.rbAmount = rbAmount;
		this.rbStatus = rbStatus;
	}

	public int getRbId() {
		return rbId;
	}

	public void setRbId(int rbId) {
		this.rbId = rbId;
	}

	public int getRbAmount() {
		return rbAmount;
	}

	public void setRbAmount(int rbAmount) {
		this.rbAmount = rbAmount;
	}

	public String getRbStatus() {
		return rbStatus;
	}

	public void setRbStatus(String rbStatus) {
		this.rbStatus = rbStatus;
	}
	
    
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	

	public int getMgrId() {
		return mgrId;
	}

	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rbAmount;
		result = prime * result + rbId;
		result = prime * result + ((rbStatus == null) ? 0 : rbStatus.hashCode());
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
		ReimbursmentPojo other = (ReimbursmentPojo) obj;
		if (rbAmount != other.rbAmount)
			return false;
		if (rbId != other.rbId)
			return false;
		if (rbStatus == null) {
			if (other.rbStatus != null)
				return false;
		} else if (!rbStatus.equals(other.rbStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursmentPojo [rbId=" + rbId + ", rbAmount=" + rbAmount + ", rbStatus=" + rbStatus + "]";
	}
    
}

package dto;

public class ResourceListDto {
	private int rId;
	private String rName;
	private String rPermission;

	public String getrPermission() {
		return rPermission;
	}

	public void setrPermission(String rPermission) {
		this.rPermission = rPermission;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}
}

package dto;

import org.json.JSONObject;

public class ConfigDto {
	private JSONObject mandatoryAttributes;

	public JSONObject getMandatoryAttributes() {
		return mandatoryAttributes;
	}

	public void setMandatoryAttributes(JSONObject mandatoryAttributes) {
		this.mandatoryAttributes = mandatoryAttributes;
	}
}
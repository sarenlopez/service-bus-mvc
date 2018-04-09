package mx.com.ege.bus.enums;

public enum TipoCampo { COMBO("COMBO"),TEXTO("TEXTO"),CHECK("CHECK"), RADIO("RADIO");
	
	private String value;

	public String getValue(){
		return value;
	}
	
	private TipoCampo(String value) {
		this.value = value;
	}

}

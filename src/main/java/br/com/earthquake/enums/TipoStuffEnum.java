package br.com.earthquake.enums;

public enum TipoStuffEnum {
	
	ITEM(0, "Item"),
	GEAR(1, "Gear"),
	ETC(2, "Etc");
	
	private Integer id;
	private String descricao;
	
	private TipoStuffEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoStuffEnum fromInt(int codigo) {
		switch(codigo) {
			case 1: return ITEM;
			case 2: return GEAR;
			case 3: return ETC;
			default: return null;
		}
	}
}
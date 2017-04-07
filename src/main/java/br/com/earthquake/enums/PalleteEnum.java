package br.com.earthquake.enums;

public enum PalleteEnum {
	
	YELLOW(1, "yellow"),
	WHITE(2, "white"),
	RED(3, "red"),
	PURPLE(4, "purple"),
	GREEN(5, "green"),
	BROWN(6, "brown"),
	BLUE(7, "blue"),
	BLACK(8, "black");
	
	private Integer id;
	private String descricao;
	
	private PalleteEnum(Integer id, String descricao) {
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

	public static PalleteEnum fromInt(int codigo) {
		switch(codigo) {
			case 1: return YELLOW;
			case 2: return WHITE;
			case 3: return RED;
			case 4:	return PURPLE;
			case 5: return GREEN;
			case 6: return BROWN;
			case 7: return BLUE;
			case 8: return BLACK;
			default: return null;
		}
	}
	
}

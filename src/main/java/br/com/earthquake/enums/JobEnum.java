package br.com.earthquake.enums;

public enum JobEnum {
	
	NOVICE(1, "Novice"),
	SUPER_NOVICE(2, "Super Novice"),
	ACOLYTE(3, "Acolyte"),
	ARCHER(4, "Archer"),
	MAGICIAN(5, "Magician"),
	MERCHANT(6, "Merchant"),
	SWORDSMAN(7, "Swordsman"),
	THIEF(8, "Thief"),
	PRIEST(9, "Priest"),
	MONK(10, "Monk"),
	HUNTER(11, "Hunter"),
	BARD(12, "Bard"),
	DANCER(13, "Dancer"),
	WIZARD(14, "Wizard"),
	SAGE(15, "Sage"),
	BLACKSMITH(16, "Blacksmith"),
	ALCHEMIST(17, "Alchemist"),
	KNIGHT(18, "Knight"),
	CRUSADER(19, "Crusader"),
	ASSASSIN(20, "Assassin"),
	ROGUE(21, "Rogue"),
	HIGH_PRIEST(22, "High Priest"),
	CHAMPION(23, "Champion"),
	SNIPER(24, "Sniper"),
	CLOWN(25, "Clown"),
	GYPSY(26, "Gypsy"),
	HIGH_WIZARD(27, "High Wizard"),
	SCHOLAR(28, "Scholar"),
	WHITESMITH(29, "Whitesmith"),
	CREATOR(30, "Creator"),
	LORD_KNIGHT(31, "Lord Knight"),
	PALADIN(32, "Paladin"),
	ASSASSIN_CROSS(33, "Assassin Cross"),
	STALKER(34, "Stalker"),
	GUNSLINGER(35, "Gunslinger"),
	NINJA(36, "Ninja"),
	TAEKWON(37, "Taekwon"),
	STAR_GLADIATOR(38, "Star Gladiator"),
	SOUL_LINKER(39, "Soul Linker");
	
	Integer id;
	String descricao;
	
	private JobEnum(Integer id, String descricao) {
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
	
	public static JobEnum fromInt(Integer codigo) {
		switch(codigo) {
			case 1: return ACOLYTE;
			case 2: return SUPER_NOVICE;
			case 3: return ACOLYTE;
			case 4: return ARCHER;
			case 5: return MAGICIAN;
			case 6: return MERCHANT;
			case 7: return SWORDSMAN;
			case 8: return THIEF;
			case 9: return PRIEST;
			case 10: return MONK;
			case 11: return HUNTER;
			case 12: return BARD;
			case 13: return DANCER;
			case 14: return WIZARD;
			case 15: return SAGE;
			case 16: return BLACKSMITH;
			case 17: return ALCHEMIST;
			case 18: return KNIGHT;
			case 19: return CRUSADER;
			case 20: return ASSASSIN;
			case 21: return ROGUE;
			case 22: return HIGH_PRIEST;
			case 23: return CHAMPION;
			case 24: return SNIPER;
			case 25: return CLOWN;
			case 26: return GYPSY;
			case 27: return HIGH_WIZARD;
			case 28: return SCHOLAR;
			case 29: return WHITESMITH;
			case 30: return CREATOR;
			case 31: return LORD_KNIGHT;
			case 32: return PALADIN;
			case 33: return ASSASSIN_CROSS;
			case 34: return STALKER;
			case 35: return GUNSLINGER;
			case 36: return NINJA;
			case 37: return TAEKWON;
			case 38: return STAR_GLADIATOR;
			case 39: return SOUL_LINKER;
		}
		return null;
	}
}
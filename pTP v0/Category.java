package modele;

public enum Category {
	

	networks("networks", 1),
	operatingSystems("operating systems", 2),
	cybersecurity("cybersecurity", 3),
	programmingLanguages("programming languages", 4),
	internet("internet", 5),
	socialNetworks("social networks", 6);
	
	private String name;
	private int idCategory;
	
	private Category(String name, int idCategory) {
		this.name = name;
		this.idCategory = idCategory;
	}
	
	public String getName() {
		return name;
	}
	
	public int getIdCategory() {
		return idCategory;
	}
		
}



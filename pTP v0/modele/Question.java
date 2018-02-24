package modele;

public class Question {
	
	private String author, statement, answer;
	private Category category;
	
	
	public Question(String author, String statement, String answer, Category category)
	{
		this.author=author;
		this.statement = statement;
		this.answer = answer;
		this.category = category;
		
	}
	
	public String getAuthor() {
		return author;
	}
	
	public Category getCategory() {
		return category;
	}

	public String getStatement() {
		return statement;
	}
	public String getAnswer() {
		return answer;
	}
	
	public Question clone() {
		return new Question(author, statement, answer, category);
	}

	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (category != other.category)
			return false;
		if (statement == null) {
			if (other.statement != null)
				return false;
		} else if (!statement.equals(other.statement))
			return false;
		return true;
	}
	
	

}

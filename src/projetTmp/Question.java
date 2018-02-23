package projetTmp;

public class Question {

	private String question;
	private String answer;
	private Category caterogy;
	
	
	public Question(String question, String answer, Category category)
	{
		this.question = question;
		this.answer = answer;
		
	}
	
	public String getQuestion() {
		return question;
	}
	public String getAnswer() {
		return answer;
	}
	
	
	
}

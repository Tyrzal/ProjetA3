package modele;

import java.util.List;

public class IteratorQuestion {
	
	private List<Question> questions;
	private int index;
	
	public IteratorQuestion(List<Question> questions)
	{
		this.questions = questions;
		index = 0;
	}

	public void next()
	{
		if(hasNext())
		{
			index++;
			return;
		}
		
	}
	
	public boolean hasNext()
	{
		if(index < questions.size())
		{
			return true;
		}
		return false;
		
	}
	
	public boolean checkAnswer(String answer)
	{
		if( questions.get(index).getAnswer().equals(answer) )
		{
			return true;
		}
		return false;
	}
	
	public Question value()
	{
		return questions.get(index);
	}
	
}



package projetTmp;

import java.util.ArrayList;
import java.util.List;

import exceptions.AlreadyInTheListException;

public class Deck{

	private List<Question> questions;
	private static Deck instance = null;
	
	private Deck()
	{
		questions = new ArrayList<Question>();
		init();
	}
	
	public static Deck getInstance()
	{
		if(instance == null)
		{
			instance = new Deck();
		}
		return instance;
	}
	
	private void init()
	{
		//lecture Json
		//ajout question
	}
	
	public List<Question> getQuestions()
	{
		return instance.questions;
	}
	
	
	public boolean addQuestion(Question question)throws AlreadyInTheListException
	{
		if(!instance.questions.contains(question))
		{
			return instance.questions.add(question);
			
			
			
			
		}
		throw new AlreadyInTheListException("question");
		
		
	}
	
	public boolean removeQuestion(Question question)
	{
		return instance.questions.remove(question);
	}
	
	public String toString()
	{
		String result = "Question list :\n";
		
		for(Question q: instance.questions)
		{
			result += q.getQuestion() + " ==== " + q.getAnswer() +"\n";
		}
		
		return result;
	}
	
}

package searchtree.attempt1;

public class StringState implements IState<String>
{

	private String state;
	
	
	public StringState(String state)
	{
		this.state = state;
	}	
	
	
	
	@Override
	public String getValue()
	{
		return state;
	}

	
	@Override
	public boolean equals(IState<String> toBeCompared)
	{
		return state.equals(toBeCompared.getValue());
	}
	
	
	@Override
	public int hashCode()
	{
		return state.hashCode();
	}
	
	
	
	@Override
	public String toString()
	{
		return state;
	}
}

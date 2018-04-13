package searchtree.attempt1;

public interface IState<T>
{
	public abstract T getValue();
	public abstract boolean equals(IState<T> toBeCompared);
	public abstract int hashCode();
}

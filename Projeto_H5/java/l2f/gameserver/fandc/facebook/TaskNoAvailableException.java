package l2f.gameserver.fandc.facebook;

public class TaskNoAvailableException extends RuntimeException
{
	private static final long serialVersionUID = -704448987661543410L;

	public TaskNoAvailableException()
	{
	}

	public TaskNoAvailableException(String s)
	{
		super(s);
	}
}

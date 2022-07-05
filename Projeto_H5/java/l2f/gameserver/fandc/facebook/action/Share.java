package l2f.gameserver.fandc.facebook.action;

import java.sql.ResultSet;
import java.sql.SQLException;

import l2f.gameserver.fandc.facebook.FacebookAction;
import l2f.gameserver.fandc.facebook.FacebookActionType;
import l2f.gameserver.fandc.facebook.FacebookProfile;
import l2f.gameserver.fandc.facebook.FacebookProfilesHolder;
import l2f.gameserver.fandc.facebook.OfficialPostsHolder;

public class Share implements FacebookAction
{
	private final FacebookProfile profile;
	private final long extractionDate;
	private final FacebookAction fatherAction;

	public Share(FacebookProfile profile, long extractionDate, FacebookAction fatherAction)
	{
		this.profile = profile;
		this.extractionDate = extractionDate;
		this.fatherAction = fatherAction;
	}

	public Share(ResultSet rset) throws SQLException
	{
		profile = FacebookProfilesHolder.getInstance().getProfileById(rset.getString("executor_id"));
		extractionDate = rset.getLong("extraction_date");
		fatherAction = OfficialPostsHolder.getInstance().getOfficialPost(rset.getString("father_id"));
	}

	@Override
	public String getId()
	{
		return null;
	}

	@Override
	public FacebookActionType getActionType()
	{
		return FacebookActionType.SHARE;
	}

	@Override
	public FacebookProfile getExecutor()
	{
		return profile;
	}

	@Override
	public long getCreatedDate()
	{
		return -1L;
	}

	@Override
	public long getExtractionDate()
	{
		return extractionDate;
	}

	@Override
	public String getMessage()
	{
		return "";
	}

	@Override
	public void changeMessage(String newMessage)
	{
	}

	@Override
	public FacebookAction getFather()
	{
		return fatherAction;
	}

	@Override
	public boolean canBeRemoved()
	{
		return false;
	}

	@Override
	public void remove()
	{
	}

	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof Share && profile.equals(((Share) obj).profile) && fatherAction.equals(((Share) obj).fatherAction);
	}

	@Override
	public int hashCode()
	{
		int result = profile.hashCode();
		result = 31 * result + fatherAction.hashCode();
		return result;
	}

	@Override
	public String toString()
	{
		return "Share{profile=" + profile + ", extractionDate=" + extractionDate + ", fatherAction=" + fatherAction + '}';
	}
}

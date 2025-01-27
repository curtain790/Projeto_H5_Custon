package l2mv.gameserver.network.clientpackets;

import l2mv.gameserver.Config;
import l2mv.gameserver.model.Player;

public class SetPrivateStoreMsgSell extends L2GameClientPacket
{
	private static final int MAX_MSG_LENGTH = 29;

	private String _storename;

	@Override
	protected void readImpl()
	{
		_storename = readS();
	}

	@Override
	protected void runImpl()
	{
		Player activeChar = getClient().getActiveChar();
		if ((activeChar == null) || ((_storename != null) && (_storename.length() > MAX_MSG_LENGTH)))
		{
			return;
		}

		if (Config.containsAbuseWord(_storename))
		{
			_storename = "...";
		}

		activeChar.setSellStoreName(_storename);
	}
}
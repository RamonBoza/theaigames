package it.net.ramonboza.theaigames.fourinarow;

import org.junit.Assert;
import org.junit.Test;

import net.ramonboza.theaigames.fourinarow.BotStarter;
import net.ramonboza.theaigames.fourinarow.Field;
import net.ramonboza.theaigames.fourinarow.providers.RealGameFieldFactory;

public class BotStarterTest {

	@Test
	public void winningMoveShouldNotLaunchAnException() throws Exception {
		Field field = RealGameFieldFactory.createOnlineGameBugField();
		BotStarter botStarter = new BotStarter();
		int makeTurn = botStarter.makeTurn(field);
		Assert.assertEquals("Moving in 0 creates a four in row", 0,makeTurn);
	}
}

package com.sirma.itt.evgeni.task6.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.itt.evgeni.task6.DatagramTransmiter;
import com.sirma.itt.evgeni.task6.KeyTransmiter;

/**
 * Key transmiter test.
 * 
 * @author root
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class KeyTransmiterTest {

	@Mock
	private DatagramTransmiter firstTransmiter;
	@Mock
	private DatagramTransmiter secondTransmiter;

	@Test
	public void sendPacketTest() {
		KeyTransmiter keyTransmiter = new KeyTransmiter(firstTransmiter,
				secondTransmiter);
		byte[] firstKey = new byte[8];
		byte[] secondKey = new byte[32];
		keyTransmiter.send(firstKey);
		keyTransmiter.send(secondKey);
		Mockito.verify(firstTransmiter, Mockito.atLeastOnce()).sendPacked(
				firstKey);
		Mockito.verify(secondTransmiter, Mockito.atLeastOnce()).sendPacked(
				secondKey);
	}

}

/*******************************************************************************
 *     Copyright (C) 2015 Jordan Dalton (jordan.8474@gmail.com)
 *
 *     This program is free software; you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation; either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License along
 *     with this program; if not, write to the Free Software Foundation, Inc.,
 *     51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *******************************************************************************/
package ovh.tgrhavoc.aibot.protocol.v5x.play.server;

import java.io.*;

import ovh.tgrhavoc.aibot.protocol.*;
import ovh.tgrhavoc.aibot.protocol.ProtocolX.State;
import ovh.tgrhavoc.aibot.world.item.InventoryType;

public class PacketS2D_OpenWindow extends AbstractPacketX implements ReadablePacket {
	private int windowId;
	private InventoryType inventoryType;
	private String windowTitle;
	private int slotCount;
	private boolean useWindowTitle;
	private int entityId;

	public PacketS2D_OpenWindow() {
		super(0x2D, State.PLAY, Direction.DOWNSTREAM);
	}

	@Override
	public void readData(DataInputStream in) throws IOException {
		windowId = in.readByte() & 255;
		inventoryType = InventoryType.byId(in.readByte() & 255);
		windowTitle = readString(in);
		slotCount = in.readByte() & 255;
		useWindowTitle = in.readBoolean();
		if(inventoryType == InventoryType.ANIMAL_CHEST)
			entityId = in.readInt();
	}

	public int getWindowId() {
		return windowId;
	}

	public InventoryType getInventoryType() {
		return inventoryType;
	}

	public String getWindowTitle() {
		return windowTitle;
	}

	public int getSlotCount() {
		return slotCount;
	}

	public boolean useWindowTitle() {
		return useWindowTitle;
	}

	public int getEntityId() {
		return entityId;
	}
}

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
package ovh.tgrhavoc.aibot.protocol.v5x.play.client;

import java.io.*;

import ovh.tgrhavoc.aibot.protocol.*;
import ovh.tgrhavoc.aibot.protocol.ProtocolX.State;

public class PacketC0B_EntityAction extends AbstractPacketX implements WriteablePacket {
	private int entityId, jumpBoost;
	private Action action;

	public PacketC0B_EntityAction(int entityId, Action action, int jumpBoost) {
		super(0x0B, State.PLAY, Direction.UPSTREAM);

		this.entityId = entityId;
		this.action = action;
		this.jumpBoost = jumpBoost;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException {
		out.writeInt(entityId);
		out.write(action.getId());
		out.writeInt(jumpBoost);
	}

	public int getEntityId() {
		return entityId;
	}

	public Action getAction() {
		return action;
	}

	public int getJumpBoost() {
		return jumpBoost;
	}

	public enum Action {
		CROUCH(1),
		UNCROUCH(2),
		LEAVE_BED(3),
		START_SPRINTING(4),
		STOP_SPRINTING(5);

		private final int id;

		private Action(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}
}

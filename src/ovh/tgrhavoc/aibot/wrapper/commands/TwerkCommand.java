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
package ovh.tgrhavoc.aibot.wrapper.commands;

import ovh.tgrhavoc.aibot.ai.TwerkTask;
import ovh.tgrhavoc.aibot.wrapper.MinecraftBotWrapper;

public class TwerkCommand extends AbstractCommand {

	public TwerkCommand(MinecraftBotWrapper bot) {
		super(bot, "twerk", "Make that booty twerk", "[on/off]", "(?i)(on|off)?");
	}

	@Override
	public void execute(String[] args) {
		TwerkTask task = bot.getTaskManager().getTaskFor(TwerkTask.class);
		if (args.length == 1){
			//Either on or off
			if (args[0].equalsIgnoreCase("on")){
				if(!task.isActive())
					task.start(args);
			}else if (task.isActive()){
				task.stop();
			}
		}else{
			if (!task.isActive())
				task.start(args);
			else
				task.stop();
		}
	}

}

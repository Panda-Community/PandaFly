package dev.panda.combofly.commands.spawn;

import dev.panda.combofly.ComboFly;
import dev.panda.lib.chat.ChatUtil;
import dev.panda.lib.command.BaseCommand;
import dev.panda.lib.command.Command;
import dev.panda.lib.command.CommandArgs;
import org.bukkit.entity.Player;

public class SetSpawnCommand extends BaseCommand {

    @Command(name = "setspawn", permission = "pandafly.setspawn")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        ComboFly.get().getSpawnManager().createSpawn(player);
        player.sendMessage(ChatUtil.translate("&aSuccessfully! &cSpawn &a has been set."));
    }

}

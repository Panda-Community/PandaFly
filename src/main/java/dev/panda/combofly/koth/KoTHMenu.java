package dev.panda.combofly.koth;

import com.google.common.collect.Maps;
import dev.panda.combofly.utilities.menu.Button;
import dev.panda.combofly.utilities.menu.Menu;
import dev.panda.item.ItemBuilder;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class KoTHMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return "&9KoTH´s events";
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = Maps.newHashMap();
        for (KoTH koth : KoTH.getKoths()) {
            buttons.put(buttons.size(), new KoTHButton(koth));
        }
        return buttons;
    }

    @AllArgsConstructor
    private static class KoTHButton extends Button {

        private final KoTH koth;

        @Override
        public ItemStack getButtonItem(Player player) {
            return new ItemBuilder(Material.PAPER)
                    .name("&b" + koth.getName())
                    .lore("&7Click to host this KoTH!")
                    .build();
        }

        @Override
        public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "koth start " + koth.getName());
        }
    }
}

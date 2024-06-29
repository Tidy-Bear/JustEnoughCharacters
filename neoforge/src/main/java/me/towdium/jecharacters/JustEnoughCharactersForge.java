package me.towdium.jecharacters;

import me.towdium.jecharacters.config.JechConfig;
import me.towdium.jecharacters.utils.Greetings;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

import static me.towdium.jecharacters.JustEnoughCharacters.*;
import static me.towdium.jecharacters.config.JechConfig.Spell.QUANPIN;


@Mod(value = JustEnoughCharacters.MODID, dist = Dist.CLIENT)
public class JustEnoughCharactersForge {
    static boolean messageSent = false;

    public JustEnoughCharactersForge(IEventBus modBus) {
        JechConfigForge.register();
        modBus.register(this);
    }

    @SubscribeEvent
    public static void onConstruct(FMLConstructModEvent event) {
        Greetings.send(logger, MODID, id -> ModList.get().isLoaded(id));
    }

    @EventBusSubscriber(value = Dist.CLIENT)
    static class EventHandler {
        @SubscribeEvent
        public static void onPlayerLogin(EntityJoinLevelEvent event) {
            if (event.getEntity() instanceof Player &&
                    event.getLevel().isClientSide &&
                    JechConfig.enableChat && !messageSent &&
                    (JechConfig.enumKeyboard == QUANPIN) &&
                    "zh_tw".equals(Minecraft.getInstance().options.languageCode)) {
                printMessage(Component.translatable("jecharacters.chat.taiwan"));
                messageSent = true;
            }
        }

        @SubscribeEvent
        public static void onClientCommandRegister(RegisterClientCommandsEvent event) {
            event.getDispatcher().register(JechCommand.getBuilder());
        }

    }
}


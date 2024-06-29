package me.towdium.jecharacters;

import me.towdium.jecharacters.config.JechConfigFabric;
import me.towdium.jecharacters.utils.Greetings;
import me.towdium.jecharacters.utils.Profiler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;

import static me.towdium.jecharacters.JustEnoughCharacters.MODID;
import static me.towdium.jecharacters.JustEnoughCharacters.logger;

public class JustEnoughCharactersFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Greetings.send(logger, MODID, id -> FabricLoader.getInstance().isModLoaded(id));
        JechConfigFabric.register();
        JechConfigFabric.loadConfig();
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(JechCommand.getBuilder()));
        Profiler.init(JustEnoughCharacters.suffixClassName);
    }
}

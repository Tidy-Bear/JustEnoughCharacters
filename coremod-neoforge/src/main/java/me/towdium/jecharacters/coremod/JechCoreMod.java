package me.towdium.jecharacters.coremod;

import com.google.auto.service.AutoService;
import cpw.mods.modlauncher.api.ITransformer;
import net.neoforged.neoforgespi.coremod.ICoreMod;

import java.util.Collections;

@AutoService(ICoreMod.class)
public class JechCoreMod implements ICoreMod {

    private final WrapperTransformer transformer = new WrapperTransformer();

    @Override
    public Iterable<? extends ITransformer<?>> getTransformers() {
        return Collections.singleton(transformer);
    }
}

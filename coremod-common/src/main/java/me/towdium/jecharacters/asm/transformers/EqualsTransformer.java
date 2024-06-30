package me.towdium.jecharacters.asm.transformers;

import com.google.auto.service.AutoService;
import me.towdium.jecharacters.asm.ConfigurableTransformer;
import me.towdium.jecharacters.asm.Transformer;
import org.objectweb.asm.tree.MethodNode;

@AutoService(Transformer.class)
public class EqualsTransformer extends ConfigurableTransformer {
    @Override
    protected String getConfigOwner() {
        return "equals";
    }

    @Override
    protected void transformMethod(MethodNode method) {
        Transformer.transformEquals(method);
    }
}

package me.towdium.jecharacters.asm.transformers;

import com.google.auto.service.AutoService;
import me.towdium.jecharacters.asm.ConfigurableTransformer;
import me.towdium.jecharacters.asm.Transformer;
import org.objectweb.asm.tree.MethodNode;

@AutoService(Transformer.class)
public class RegExpTransformer extends ConfigurableTransformer {
    @Override
    protected String getConfigOwner() {
        return "regExp";
    }

    @Override
    protected void transformMethod(MethodNode method) {
        Transformer.transformRegExp(method);
    }
}

package me.towdium.jecharacters.asm.transformers;

import com.google.auto.service.AutoService;
import me.towdium.jecharacters.asm.ConfigurableTransformer;
import me.towdium.jecharacters.asm.Transformer;
import me.towdium.jecharacters.asm.JechClassTransformer;
import org.objectweb.asm.tree.MethodNode;

@AutoService(Transformer.class)
public class SuffixArrayTransformer extends ConfigurableTransformer {
    @Override
    protected String getConfigOwner() {
        return "suffix";
    }

    @Override
    protected void transformMethod(MethodNode method) {
        Transformer.transformSuffix(method, JechClassTransformer.suffixClassName);
    }
}

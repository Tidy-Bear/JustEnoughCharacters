package me.towdium.jecharacters.asm;

import org.objectweb.asm.tree.ClassNode;

import java.util.Set;

/**
 * Used for special compatibility with mods like jei.
 */
public interface ICustomTransformer {

    Set<String> targetClasses();

    default boolean accept(ClassNode node) {
        return targetClasses().contains(node.name);
    }

    void transform(ClassNode node);
}

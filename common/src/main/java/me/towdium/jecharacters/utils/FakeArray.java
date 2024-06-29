package me.towdium.jecharacters.utils;

import me.towdium.jecharacters.JustEnoughCharacters;
import me.towdium.jecharacters.config.JechConfig;
import me.towdium.pinin.searchers.TreeSearcher;
import net.minecraft.client.searchtree.SuffixArray;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static me.towdium.jecharacters.utils.Match.searcher;

public class FakeArray<T> extends SuffixArray<T> {

    TreeSearcher<T> tree = searcher();

    @Override
    public void add(@NotNull T v, @NotNull String k) {
        if (JechConfig.enableVerbose) JustEnoughCharacters.logger.info("FakeArray:put(" + v + ',' + k + ')');
        tree.put(k, v);
    }

    @Override
    public void generate() {
    }

    @Override
    public @NotNull List<T> search(String k) {
        if (JechConfig.enableVerbose) JustEnoughCharacters.logger.info("FakeArray:search(" + k + ')');
        return tree.search(k);
    }

}

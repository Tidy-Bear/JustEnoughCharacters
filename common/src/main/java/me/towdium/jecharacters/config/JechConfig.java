package me.towdium.jecharacters.config;

import me.towdium.pinin.Keyboard;
import org.jetbrains.annotations.Nullable;

public final class JechConfig {

    public static final String GENERAL = "general";
    public static final String UTILITIES = "utilities";

    public static boolean enableQuote = false;

    public static Spell enumKeyboard = Spell.QUANPIN;
    public static boolean enableFZh2z = true;
    public static boolean enableFSh2s = true;
    public static boolean enableFCh2c = true;
    public static boolean enableFAng2an = true;
    public static boolean enableFIng2in = true;
    public static boolean enableFEng2en = true;
    public static boolean enableFU2v = true;

    public static boolean enableVerbose;
    public static boolean enableChat;

    @Nullable
    public static Runnable reload;

    public static void tryReload() {
        if (reload != null) reload.run();
    }

    public enum Spell {
        QUANPIN(Keyboard.QUANPIN),
        DAQIAN(Keyboard.DAQIAN),
        XIAOHE(Keyboard.XIAOHE),
        ZIRANMA(Keyboard.ZIRANMA),
        SOUGOU(Keyboard.SOUGOU),
        GUOBIAO(Keyboard.GUOBIAO),
        MICROSOFT(Keyboard.MICROSOFT),
        PINYINPP(Keyboard.PINYINPP),
        ZIGUANG(Keyboard.ZIGUANG);

        public final Keyboard keyboard;

        Spell(Keyboard keyboard) {
            this.keyboard = keyboard;
        }

        public Keyboard get() {
            return keyboard;
        }
    }

}

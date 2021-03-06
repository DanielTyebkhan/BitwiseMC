package com.bitwisemc.org.datagen;

import com.bitwisemc.org.BitwiseMC;
import com.bitwisemc.org.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.bitwisemc.org.setup.ModSetup.TAB_NAME;

public class BitwiseLanguageProvider extends LanguageProvider {
    public BitwiseLanguageProvider(DataGenerator generator, String locale) {
        super(generator, BitwiseMC.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + TAB_NAME, "BitwiseMC");

        add(Registration.AND_GATE.get(), "AND Gate");
        add(Registration.EXCLUSIVE_OR_GATE.get(), "XOR Gate");
        add(Registration.NOT_GATE.get(), "NOT Gate");
    }
}

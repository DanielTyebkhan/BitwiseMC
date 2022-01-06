package com.bitwisemc.org;

import com.bitwisemc.org.setup.ClientSetup;
import com.bitwisemc.org.setup.ModSetup;
import com.bitwisemc.org.setup.Registration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BitwiseMC.MODID)
public class BitwiseMC
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public final static String MODID = "bitwisemc";

    public BitwiseMC() {
        Registration.init();

        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetup::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));
    }

}

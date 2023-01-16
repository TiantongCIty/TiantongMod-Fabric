package net.fabricmc.tiantong.particles;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.tiantong.TiantongClient;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

public class TParticles {
    public static final DefaultParticleType Metal = FabricParticleTypes.simple();
    public void InitParticleMain() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier("tiantong", "metal"), Metal);
    }
    public void InitParticleClient() {
        //Client
    }
}

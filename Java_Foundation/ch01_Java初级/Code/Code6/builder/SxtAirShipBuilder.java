package com.klaus.builder;

public class SxtAirShipBuilder implements AirShipBuilder{//StringBuilder 以后学XML解析中，JDOM库中的类DomBuilder,SaxBuilder
    @Override
    public Engine builderEngine() {
        System.out.println("构建发动机");
        return new Engine("k牌发动机");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("构建轨道仓");
        return new OrbitalModule("k牌轨道仓");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构建逃逸塔");
        return new EscapeTower("k牌逃逸塔");
    }
}
